package br.com.fatec.Cliente;

public class Pessoa {
	private String nome;
	private String cpf;
	
	public Pessoa(String nome, String cpf) {
		// TODO Auto-generated constructor stub
		this.cpf=cpf;
		this.nome=nome;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public String getCpf()
	{
		return cpf;
	}
}
