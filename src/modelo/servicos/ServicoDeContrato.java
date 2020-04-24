package modelo.servicos;

import java.util.Calendar;
import java.util.Date;

import modelo.entidades.Contrato;
import modelo.entidades.Parcela;

public class ServicoDeContrato {
	
	private ServicoDePagamentoOnline servicoDePagamentoOnline;
	
	
	
	public ServicoDeContrato(ServicoDePagamentoOnline servicoDePagamentoOnline) {
		this.servicoDePagamentoOnline = servicoDePagamentoOnline;
	}



	public void processaContrato(Contrato contrato, Integer meses) {
		double cotaBasica = contrato.getValorTotal() / meses;
		
		for (int i = 1; i <= meses; i++) {
			Date data = adicionaMeses(contrato.getData(), i);
			double cotaAtualizada = cotaBasica + servicoDePagamentoOnline.interesse(cotaBasica, i);
			double cotaTotal = cotaAtualizada + servicoDePagamentoOnline.taxaDePagamento(cotaAtualizada);
			contrato.adicionaParcela(new Parcela(data, cotaTotal));
		}
	}
	
	private Date adicionaMeses(Date data, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}
