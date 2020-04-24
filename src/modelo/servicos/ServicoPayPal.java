package modelo.servicos;

public class ServicoPayPal implements ServicoDePagamentoOnline{

	private static final double TAXA_PERCENTUAL = 0.02;
	private static final double INTERESSE_MENSAL = 0.01;
	
	@Override
	public Double taxaDePagamento(Double quantia) {
		return quantia * TAXA_PERCENTUAL;
	}

	@Override
	public Double interesse(Double quantia, Integer meses) {
		return quantia * INTERESSE_MENSAL * meses;
	}
	
}
