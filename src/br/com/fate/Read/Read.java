package br.com.fate.Read;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import br.com.fatec.Cliente.Verificador;
import br.com.fatec.Cliente.VerificadorCpf;
import br.com.fatec.pagamento.Pagamento;

public abstract class Read{

	private Verificador verificar;
	
	public Read() {
		// TODO Auto-generated constructor stub
	}
	private String pegarCaminho()
	{
		JFrame janela= new JFrame();
		JFileChooser caminhoAbrir= new JFileChooser();
		caminhoAbrir.setToolTipText("Abrir Arquivo em: ");
		if(caminhoAbrir.showOpenDialog(janela)== JFileChooser.APPROVE_OPTION)	
		{
			File caminho = caminhoAbrir.getSelectedFile();
			return caminho.getAbsolutePath();
		}
		else
		{
			return "Cancelado salvamento";
		}
	}
	
	private String obterDados(String caminho)
	{
		try {
			FileInputStream entrada= new FileInputStream(caminho);
			
			ObjectInputStream ob= new ObjectInputStream(entrada);
			String r = (String) ob.readObject();
			ob.close();
			entrada.close();
			
			System.out.println(r);
			return r;
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	protected abstract List<Pagamento> obterList(String dados);
	
	public List<Pagamento> CarregarLista()
	{
		List<Pagamento>pagamentos= new ArrayList<Pagamento>();
		List<Pagamento>p2;
		String caminho=pegarCaminho();
		String dados= obterDados(caminho);
		if(caminho!=null && dados!=null) {
			verificar = new VerificadorCpf();
			p2= obterList(dados);
			
			for(Pagamento pagamento: p2) {
				if(verificar.verificar(pagamento.getCliente().getCpf()))
				{
					pagamentos.add(pagamento);
				}
			}
			return pagamentos;
		}
		System.out.println("Não foi");
		return null;
	}
	
	
}
