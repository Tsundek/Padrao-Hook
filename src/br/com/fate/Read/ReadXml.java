package br.com.fate.Read;

import java.io.StringReader;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import br.com.fatec.Cliente.Banco;
import br.com.fatec.Cliente.Pessoa;
import br.com.fatec.pagamento.Boleto;
import br.com.fatec.pagamento.CartaoCredito;
import br.com.fatec.pagamento.CartaoDebito;
import br.com.fatec.pagamento.Pagamento;

public class ReadXml extends Read {

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected List<Pagamento> obterList(String dados) {
		// TODO Auto-generated method stub
		XStream xstream= new XStream(new StaxDriver());
		xstream.alias("Pagamentos", List.class);
		xstream.alias("pagamento", Pagamento.class);
		xstream.alias("boleto", Boleto.class);
		xstream.alias("cartaoCredito", CartaoCredito.class);
		xstream.alias("cartaoDebito",CartaoDebito.class);
		xstream.alias("cliente", Pessoa.class);
		xstream.alias("bancoEmissor", Banco.class);
		xstream.alias("bancoDestinatario", Banco.class);
		
		return (List) xstream.fromXML(new StringReader(dados));
		
	}

	

	
}
