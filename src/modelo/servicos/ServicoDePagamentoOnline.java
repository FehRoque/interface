package modelo.servicos;

public interface ServicoDePagamentoOnline {
	
	public Double taxaDePagamento(Double quantia);
	public Double interesse(Double quantia, Integer meses);

}
