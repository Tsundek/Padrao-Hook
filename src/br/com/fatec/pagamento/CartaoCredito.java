package br.com.fatec.pagamento;

import br.com.fatec.Cliente.Banco;
import br.com.fatec.Cliente.Pessoa;

public class CartaoCredito extends Pagamento{
	
	private String numeroCartao;
	private String nomeTitular;
	private int numeroParcelas=0;
	
	public CartaoCredito() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public CartaoCredito(Banco bancoDestinatario, Banco bancoEmissor, Pessoa cliente, String dataPagamento,
			String horaPagamento, double valorPagamento, String nomeTitular, String numeroCartao,
			int numeroParcelas) {
		super(bancoDestinatario, bancoEmissor, cliente, dataPagamento, horaPagamento, valorPagamento);
		// TODO Auto-generated constructor stub
		this.nomeTitular=nomeTitular;
		this.numeroCartao=numeroCartao;
		this.numeroParcelas=numeroParcelas;
	}
	
	
	public String getNumeroCartao() {
		return numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public int getNumeroParcelas() {
		return numeroParcelas;
	}

	
	
	
	
}
