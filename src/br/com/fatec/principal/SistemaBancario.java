package br.com.fatec.principal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.fate.Read.Read;
import br.com.fate.Read.ReadJson;
import br.com.fate.Read.ReadXml;
import br.com.fatec.Cliente.Banco;
import br.com.fatec.Cliente.Pessoa;
import br.com.fatec.Write.Write;
import br.com.fatec.Write.WriteJson;
import br.com.fatec.Write.WriteXml;
import br.com.fatec.pagamento.Boleto;
import br.com.fatec.pagamento.CartaoCredito;
import br.com.fatec.pagamento.CartaoDebito;
import br.com.fatec.pagamento.Pagamento;

public class SistemaBancario {

	private List<Pagamento> pagamentos;
	private Read leitura;
	private Write escrita;
	
	public SistemaBancario() {
		this.pagamentos = new ArrayList<>();
	}
	
	//funções do sistema
	public int menuSistemaBancario()
	{
		try
		{
			int escolha;
			String esolha = JOptionPane.showInputDialog("Digite uma da opções do Sistema Bancario\n"
					+ "1 - Inserir Pagamento\n"
					+ "2 - Obter Pagamentos\n"
					+ "3 - Mostrar Pagamentos\n"
					+ "0 - Sair");
			
			escolha =Integer.parseInt(esolha);
			return escolha;
		}catch (NullPointerException e) {
			// TODO: handle exception
			System.err.print("Erro: "+e.getMessage());
			return -1;
		}catch (NumberFormatException e) {
			// TODO: handle exception
			System.err.print("Erro: "+e.getMessage());
			return -1;
		}	
	}
	public void adicionarPagamentos()
	{
		String resposta="";
		int escolha=0;
		Pagamento pagamento;
		try {
			
			do
			{
				pagamento=adicionarPagamentoUnitario();
				if(pagamento!= null) {
					pagamentos.add(pagamento);
					resposta= JOptionPane.showInputDialog("Deseja continuar? S(sim) ou N(Não)").toUpperCase();
				}else
				{
					JOptionPane.showMessageDialog(null, "Não foi posivel inserir pagamento");
					break;
				}
			}while(resposta.equals("S"));
				if(pagamento != null) {
					escolha=Integer.parseInt(JOptionPane.showInputDialog("Escolha as opções de salvar:\n"
							+ "1 - Salvar o aruivo no formato JSON\n"
							+ "2 - Salvar o aruivo no formato XML"));
					if(escolha==1) {
						escrita =new WriteJson();
					}
					else {
						escrita =new WriteXml();
					}
					escrita.salvarArquivo(pagamentos);
				}
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Não foi posivel inserir pagamento");
		}
	}
	public void obterPagamentos()
	{
		int escolha;
		escolha=Integer.parseInt(JOptionPane.showInputDialog("Escolha as opções de salvar:\n"
				+ "1 - Abrir o arquivo no formato JSON\n"
				+ "2 - Abrir o arquivo no formato XML"));
		if(escolha==1)
			leitura =new ReadJson();
		else
			leitura =new ReadXml();
		
		pagamentos= leitura.CarregarLista();
		System.out.println(pagamentos.size());
		
	}
	public void mostrarPagamentos()
	{
		String respota;
		for(Pagamento p:pagamentos)
		{
			respota = "";
			if(p instanceof Boleto) {
				Boleto b =(Boleto)p;
				respota = "Pagamento em Boleto\n--------------------------"
						+ "\nNumero Boleto:"+b.getNumeroBoleto()+"\n";
			}
			else if(p instanceof CartaoDebito)
			{
				CartaoDebito cd =(CartaoDebito)p;
				respota = "Pagamento em Cartão de Debito\n--------------------------"
						+ "\nNome titular:"+cd.getNomeTitular()+
						"\nNumero do cartão:"+cd.getNumeroCartao()+"\n";
			}
			else if(p instanceof CartaoCredito) {
				CartaoCredito cc =(CartaoCredito)p;
				respota = "Pagamento em Cartão de Debito\n"+
						"\nNome titular:"+cc.getNomeTitular()+
						"\nNumero do cartão:"+cc.getNumeroCartao()+
						"\nParcelado em "+ cc.getNumeroParcelas()+" vezes\n";
			}
			respota+="Cliente: "+p.getCliente().getNome()+
					"\nCpf: "+p.getCliente().getCpf()+
					"\nBanco Emissor: "+p.getBancoEmissor().getNomeBanco()+
					"\nBanco Destinatario; "+p.getBancoDestinatario().getNomeBanco()+
					"\nData: "+p.getDataPagamento()+"     Hora: "+p.getHoraPagamento()+
					"\nValor do pagamento: "+p.getValorPagamento();
			JOptionPane.showMessageDialog(null, respota);
		}
	}

	//funções que ajudam outras funções
	private Pessoa adicionarDadosCliente()
	{
		String nome, cpf;
		nome= JOptionPane.showInputDialog("Digite o Nome do dono da conta:");
		cpf= JOptionPane.showInputDialog("Escreva o Cpf do dono da conta:");
		return new Pessoa(nome,cpf);
	}
	private Banco adicionarBanco(int posicao)
	{
		String nomeBanco, texto;
		if(posicao==0)
			texto="Digite o nome do banco Emissor";
		else
			texto="Digite o nome do banco recebidor";
		nomeBanco= JOptionPane.showInputDialog(texto);
		return new Banco(nomeBanco);
	}
	private Pagamento adicionarPagamentoUnitario()
	{
		try {
			//Variaveis do metodo pagamento Unitario
			Pessoa cliente;
			int posicao=0;
			String data="", hora="", escolha;
			Banco[] bancos= new Banco[2];
			Calendar calendario;
			double valor=0;
			
			//Apresentação
			JOptionPane.showMessageDialog(null, "Adicionando Pagamento");
			//Adionando data
			calendario = Calendar.getInstance();
			data += calendario.get(Calendar.DAY_OF_MONTH)+"/"+
					(calendario.get(Calendar.MONTH)+1)+"/"+
					calendario.get(Calendar.YEAR);
			//Adicionando Hora
			hora+= calendario.get(Calendar.HOUR_OF_DAY)+":"+
					calendario.get(Calendar.MINUTE);
			
			//Adicionando Cliente
			cliente = adicionarDadosCliente();
			//Adicionando 2 bancos
			do
			{
				bancos[posicao] = adicionarBanco(posicao);
				posicao++;
				
			}while(posicao<2);
			//Adicionado valor
			valor= Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do pagamento"));
			//escolhendo o forma de pagamento
			escolha= JOptionPane.showInputDialog("Escolha o tipo de pagamento:\n"
					+ "1 - Boleto\n"
					+ "2 - Cartão de credito\n"
					+ "3 - Cartão de Debito");
			
			//Tipos de pagamentos
			if(escolha.equals("1")) {
				String numeroBoleto= JOptionPane.showInputDialog("Escreva o numero do boleto");
				return new Boleto(bancos[1], bancos[0], cliente, data, hora, valor, numeroBoleto);
			}
			else if(escolha.equals("2"))
			{
				String nomeTitular= JOptionPane.showInputDialog("Escreva o nome do titular");
				String numeroCartao= JOptionPane.showInputDialog("Escreva o numero do cartão");
				int numeroParcelas= Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de pacelas"));
				return new CartaoCredito(bancos[1], bancos[0], cliente, data, hora, valor, nomeTitular, numeroCartao, numeroParcelas);
			}
			else 
			{
				String nomeTitular= JOptionPane.showInputDialog("Escreva o nome do titular");
				String numeroCartao= JOptionPane.showInputDialog("Escreva o numero do cartão");
				return new CartaoDebito(bancos[1], bancos[0], cliente, data, hora, valor, nomeTitular, numeroCartao);
			}
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}


