package br.com.fate.Read;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import br.com.fatec.pagamento.Boleto;
import br.com.fatec.pagamento.CartaoCredito;
import br.com.fatec.pagamento.CartaoDebito;
import br.com.fatec.pagamento.Pagamento;


public class ReadJson extends Read {

	@Override
	protected List<Pagamento> obterList(String dados) {
		// TODO Auto-generated method stub
		List<Pagamento> pagamentos= new ArrayList<Pagamento>();
		
		
		pagamentos = converterLista(dados, new TypeToken<List<Boleto>>() {}.getType(), pagamentos);
		
		pagamentos = converterLista(dados, new TypeToken<List<CartaoCredito>>() {}.getType(), pagamentos);
		
		pagamentos = converterLista(dados, new TypeToken<List<CartaoDebito>>() {}.getType(), pagamentos);
		
		return pagamentos;
		
	}
	private List<Pagamento> converterLista(String dados,Type tipo, List<Pagamento> pagamentos)
	{
		Gson gson = new  GsonBuilder().create();
		List<Pagamento>pagamentos1;
		
		pagamentos1=gson.fromJson(dados,tipo);
		
		for(Pagamento pagamento: pagamentos1)
		{
			if(pagamento instanceof Boleto) 
			{
				if(((Boleto)pagamento).getNumeroBoleto()!=null) 
					pagamentos.add(pagamento);
			}
			else if(pagamento instanceof CartaoCredito) 
			{
				 if(((CartaoCredito)pagamento).getNumeroParcelas()!=0) 
					pagamentos.add(pagamento);
			}
			else
			{
				if(((CartaoDebito)pagamento).getNumeroCartao()!=null) 
					pagamentos.add(pagamento);
			}
		}
		return pagamentos;
	}
	
	

}