package br.com.fatec.Cliente;

public class VerificadorCpf implements Verificador {

	
	private Boolean vereficarDigito(String cpf, Boolean Numdigito)
	{
		char[] car, num;
		int secao= 0;
		int total=0;
		
		cpf= cpf.replace(".", "");
		cpf= cpf.replace("-", "");
		if(cpf.length()<11)
			return false;
		
		if(Numdigito)
			car = cpf.substring(0, 9).toCharArray();
		else
			car = cpf.substring(0, 10).toCharArray();
		
		while(secao<car.length)
		{
			total+=(Integer.parseInt(""+car[secao]))*(car.length-secao+1);
			secao++;
		}
		num=cpf.substring(car.length, car.length+1).toCharArray();
		return Integer.parseInt(""+num[0])==(11-(total%11));
	}
	@Override
	public Boolean verificar(String dado) {
		// TODO Auto-generated method stub
		Boolean digito1, digito2;
		digito1=vereficarDigito(dado, true);
		digito2=vereficarDigito(dado, false);
		return digito1 && digito2;
	}
}
