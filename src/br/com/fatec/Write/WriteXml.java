package br.com.fatec.Write;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import br.com.fatec.Cliente.Banco;
import br.com.fatec.Cliente.Pessoa;
import br.com.fatec.pagamento.Boleto;
import br.com.fatec.pagamento.CartaoCredito;
import br.com.fatec.pagamento.CartaoDebito;
import br.com.fatec.pagamento.Pagamento;

public class WriteXml extends Write{

	@Override
	protected String converterArquivoFarmato(List<Pagamento> pagamentos) {
		// TODO Auto-generated method stub
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("Pagamentos", List.class);
		xstream.alias("pagamento", Pagamento.class);
		xstream.alias("boleto", Boleto.class);
		xstream.alias("cartaoCredito",CartaoCredito.class);
		xstream.alias("cartaoDebito", CartaoDebito.class);
		xstream.alias("cliente", Pessoa.class);
		xstream.alias("bancoEmissor", Banco.class);
		xstream.alias("bancoDestinatario", Banco.class);
	
		String xml= xstream.toXML(pagamentos);
		System.out.println(xml);
		return xml;
	}
	@Override
	protected String getNomeExtensao() {
		// TODO Auto-generated method stub
		return "Arquivo no formato xml";
	}

	@Override
	protected String getTipoExtensao() {
		// TODO Auto-generated method stub
		return ".xml";
	}
}
