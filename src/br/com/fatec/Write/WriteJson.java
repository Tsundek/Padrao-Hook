package br.com.fatec.Write;

import java.util.List;

import com.google.gson.Gson;

import br.com.fatec.pagamento.Pagamento;


public class WriteJson extends Write {
	
	public WriteJson() {
		// TODO Auto-generated constructor stub
		
	}
	@Override
	protected String converterArquivoFarmato(List<Pagamento> pagamentos) {
		
		Gson gson = new Gson();
		return gson.toJson(pagamentos);
	}
	@Override
	protected String getNomeExtensao() {
		// TODO Auto-generated method stub
		return "Arquivo no formato json";
	}
	@Override
	protected String getTipoExtensao() {
		// TODO Auto-generated method stub
		return ".json";
	}

}
