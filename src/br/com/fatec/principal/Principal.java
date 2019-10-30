package br.com.fatec.principal;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SistemaBancario sistema= new SistemaBancario();
		int escolha=0;
		do
		{
			escolha= sistema.menuSistemaBancario();
			if(escolha==1)
			{
				sistema.adicionarPagamentos();
			}
			if(escolha==2)
			{
				sistema.obterPagamentos();
			}
			if(escolha==3)
			{
				sistema.mostrarPagamentos();
			}
		}while(escolha!=0);
		System.exit(0);
	}

}
