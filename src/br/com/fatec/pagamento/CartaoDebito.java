package br.com.fatec.pagamento;

import br.com.fatec.Cliente.Banco;
import br.com.fatec.Cliente.Pessoa;

public class CartaoDebito extends Pagamento {

	private String numeroCartao;
	private String nomeTitular;
	
	public CartaoDebito() {
		// TODO Auto-generated constructor stub
	}
	public CartaoDebito(Banco bancoDestinatario, Banco bancoEmissor, Pessoa cliente, String dataPagamento, String horaPagamento,
			double valorPagamento, String nomeTitular, String numeroCartao) {
		super(bancoDestinatario, bancoEmissor,cliente, dataPagamento, horaPagamento, valorPagamento);
		// TODO Auto-generated constructor stub
		this.nomeTitular=nomeTitular;
		this.numeroCartao=numeroCartao;
	}
	
	public String getNumeroCartao() {
		return numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	
	
	
		
		
	
	
	
}
