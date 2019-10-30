package br.com.fatec.Write;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.fatec.pagamento.Pagamento;

public abstract class  Write {

	
	
	private String caminhoSalvar()
	{
		JFrame janela= new JFrame();
		JFileChooser caminhoSalvar= new JFileChooser();
		caminhoSalvar.setToolTipText("Salvar Arquivo em: ");
		if(caminhoSalvar.showSaveDialog(janela)== JFileChooser.APPROVE_OPTION)	
		{
			File caminho = caminhoSalvar.getSelectedFile();
			return caminho.getAbsolutePath();
		}
		else
		{
			return null;
		}
	}
	private void salvarArquivoEm(String arquivo, String caminho)
	{
		try {
			
			FileOutputStream escrever= new FileOutputStream(caminho+this.getTipoExtensao());
			ObjectOutputStream ob= new ObjectOutputStream(escrever);
			ob.writeObject(arquivo);
			ob.close();
			escrever.close();
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	protected abstract String converterArquivoFarmato(List<Pagamento> pagamentos);
	protected abstract String getNomeExtensao();
	protected abstract String getTipoExtensao();
	
	public void salvarArquivo(List<Pagamento> pagamentos)
	{
		
		String caminho=caminhoSalvar();
		String arquivo=converterArquivoFarmato(pagamentos);
		if(caminho!=null && arquivo!=null) {
			salvarArquivoEm(arquivo, caminho);
			JOptionPane.showMessageDialog(null, "Salvado com sucesso");
		}else
		{
			JOptionPane.showMessageDialog(null, "Não salvo");
		}
	}
}
