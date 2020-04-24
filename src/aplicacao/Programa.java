package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.Contrato;
import modelo.entidades.Parcela;
import modelo.servicos.ServicoDeContrato;
import modelo.servicos.ServicoPayPal;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		
		
		
		System.out.println("Entre com os dados do contrato ");
		System.out.print("Número: ");
		int numero = sc.nextInt();
		
		System.out.print("Data (dd/MM/aaaa): ");
		Date data = sdf.parse(sc.next());
		
		System.out.print("Valor do contrato: ");
		double valorTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valorTotal);
		
		System.out.print("Entre com o número de parcelas: ");
		int n = sc.nextInt();
		
		ServicoDeContrato servicoDeContrato = new ServicoDeContrato(new ServicoPayPal());
		
		servicoDeContrato.processaContrato(contrato, n);
		
		System.out.println("Parcelas: ");
		for (Parcela x : contrato.getParcelas()) {
			System.out.println(x);
		}
		
		sc.close();
	}
}
