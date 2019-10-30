package br.com.fatec.pagamento;

import br.com.fatec.Cliente.Banco;
import br.com.fatec.Cliente.Pessoa;

public class Boleto extends Pagamento {

	private String numeroBoleto;
	public Boleto(Banco bancoDestinatario, Banco bancoEmissor, Pessoa cliente, String dataPagamento, String horaPagamento,
			double valorPagamento, String numeroBoleto) {
		super(bancoDestinatario, bancoEmissor, cliente, dataPagamento, horaPagamento, valorPagamento);
		// TODO Auto-generated constructor stub
		this.numeroBoleto=numeroBoleto;
	}
	public Boleto() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNumeroBoleto() {
		return numeroBoleto;
	}

	
	
	
}
