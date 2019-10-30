package br.com.fatec.pagamento;

import br.com.fatec.Cliente.Banco;
import br.com.fatec.Cliente.Pessoa;

public abstract class  Pagamento {
	
	protected Banco bancoDestinatario;
	protected Banco bancoEmissor;
	protected Pessoa cliente;
	protected String dataPagamento;
	protected String horaPagamento;
	protected double valorPagamento;
	
	//Construtor Pagamento
	
	public Pagamento(Banco bancoDestinatario,Banco bancoEmissor, Pessoa cliente,
			String dataPagamento, String horaPagamento, double valorPagamento) {
		// TODO Auto-generated constructor stub
		 this.bancoDestinatario=bancoDestinatario;
		 this.bancoEmissor=bancoEmissor;
		 this.cliente=cliente;
		 this.dataPagamento=dataPagamento;
		 this.horaPagamento=horaPagamento;
		 this.valorPagamento=valorPagamento;
	}
	public Pagamento()
	{
		
	}
	//Get de Pagamento
	
	public Banco getBancoDestinatario() {
		return bancoDestinatario;
	}

	public Banco getBancoEmissor() {
		return bancoEmissor;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public String getHoraPagamento() {
		return horaPagamento;
	}

	public double getValorPagamento() {
		return valorPagamento;
	}
	public Pessoa getCliente() {
		return cliente;
	}

	
	
	
	
	
	
}
