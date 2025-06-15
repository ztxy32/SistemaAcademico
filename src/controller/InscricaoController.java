package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Inscricao;
import model.estrutura.Lista;

public class InscricaoController implements ActionListener{
	
	private JTextField  tfInscricaoCpfProfessor;
	private JTextField  tfInscricaoCodDisciplina;
	private JTextField  tfInscricaoCodProcesso;
	private JTextArea taInscricao;
	
	public InscricaoController(JTextField tfInscricaoCpfProfessor, JTextField tfInscricaoCodDisciplina, JTextField tfInscricaoCodProcesso, JTextArea taInscricao) {
		super();
		this.tfInscricaoCpfProfessor = tfInscricaoCpfProfessor;
		this.tfInscricaoCodDisciplina = tfInscricaoCodDisciplina;
		this.tfInscricaoCodProcesso = tfInscricaoCodProcesso;
		this.taInscricao = taInscricao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals("Cadastrar")) {
			try {
				cadastro();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(cmd.equals("Buscar")) {
			try {
				busca();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		if(cmd.equals("Atualizar")) {
			try {
				atualizar();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}
		if(cmd.equals("Remover")) {
			try {
				remover();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	private void remover() throws IOException{
		// TODO Auto-generated method stub
		
	}

	private void atualizar() throws IOException{
		// TODO Auto-generated method stub
		
	}

	private void busca() throws Exception{
		Inscricao inscricao = new Inscricao();
		inscricao.cpfProfessor = tfInscricaoCpfProfessor.getText();
		inscricao.codDisciplina = tfInscricaoCodDisciplina.getText();
		inscricao.codProcesso = tfInscricaoCodProcesso.getText();
		
		Lista<Inscricao> inscricoes = new Lista<>();
		
		if(!inscricao.cpfProfessor.equals("")) {
			inscricao = buscaCpf(inscricao.cpfProfessor);
			if(inscricao != null) {
				taInscricao.setText("Cpf professor: "+inscricao.cpfProfessor+" Código da disciplina: "+inscricao.codDisciplina+" Código de processo: "+inscricao.codProcesso);
			}
		}else if(!inscricao.codDisciplina.equals("")) {
			inscricoes = buscaDisciplina(inscricao.codDisciplina);
		}else if(!inscricao.codProcesso.equals("")) {
			inscricoes = buscaProcesso(inscricao.codProcesso);
		}else {
			JOptionPane.showMessageDialog(null, "Preencha um campo", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		
		int listSize = inscricoes.size();
		
		StringBuffer buffer = new StringBuffer();
		if(listSize > 0) {
			for(int i = 0; i < listSize; i++) {
				Inscricao inscr = (Inscricao) inscricoes.getPosicao(i);
				buffer.append("Cpf professor: "+inscr.cpfProfessor+" Código da disciplina: "+inscr.codDisciplina+" Código de processo: "+inscr.codProcesso+"\r\n");
			}
			taInscricao.setText(buffer.toString());
			
		}else {
			JOptionPane.showMessageDialog(null, "Nenhum processo encontrado", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		tfInscricaoCpfProfessor.setText("");
		tfInscricaoCodDisciplina.setText("");
		tfInscricaoCodProcesso.setText("");
		
	}

	private Lista<Inscricao> buscaProcesso(String codProcesso) throws IOException{
		Lista<Inscricao> inscricoes = new Lista<>();
		
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File arq = new File(path, "inscricoes.csv");
		
		if(arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();

			while(linha != null) {
				String[] vetLinha = linha.split(";");
				if(vetLinha[2].equals(codProcesso)) {
					Inscricao inscricao = new Inscricao();
					inscricao.cpfProfessor = vetLinha[0];
					inscricao.codDisciplina = vetLinha[1];
					inscricao.codProcesso = vetLinha[2];
					
					inscricoes.addFirst(inscricao);
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			isr.close();
			fis.close();
		}
		return inscricoes;
	}

	private Lista<Inscricao> buscaDisciplina(String codDisciplina) throws IOException{
		Lista<Inscricao> inscricoes = new Lista<>();
		
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File arq = new File(path, "inscricoes.csv");
		
		if(arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();

			while(linha != null) {
				String[] vetLinha = linha.split(";");
				if(vetLinha[1].equals(codDisciplina)) {
					Inscricao inscricao = new Inscricao();
					inscricao.cpfProfessor = vetLinha[0];
					inscricao.codDisciplina = vetLinha[1];
					inscricao.codProcesso = vetLinha[2];
					
					inscricoes.addFirst(inscricao);
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			isr.close();
			fis.close();
		}
		return inscricoes;
	}

	private Inscricao buscaCpf(String cpfProfessor) throws IOException{
		Inscricao inscricao = new Inscricao();
		
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File arq = new File(path, "inscricoes.csv");
		
		if(arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			
			while(linha != null) {
				String[] vetLinha = linha.split(";");
				if(vetLinha[0].equals(cpfProfessor)) {
					inscricao.cpfProfessor = vetLinha[0];
					inscricao.codDisciplina = vetLinha[1];
					inscricao.codProcesso = vetLinha[2];
					break;
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			isr.close();
			fis.close();
		}
		if(inscricao.cpfProfessor == null) {
			inscricao = null;
		}
		return inscricao;
	}

	private void cadastro() throws IOException{
		Inscricao inscricao = new Inscricao();
		inscricao.cpfProfessor = tfInscricaoCpfProfessor.getText();
		inscricao.codDisciplina = tfInscricaoCodDisciplina.getText();
		inscricao.codProcesso = tfInscricaoCodProcesso.getText();
		
		handleCadastrarInscricao(inscricao.toString());
		
		tfInscricaoCpfProfessor.setText("");
		tfInscricaoCodDisciplina.setText("");
		tfInscricaoCodProcesso.setText("");
		
	}

	private void handleCadastrarInscricao(String csvInscricao) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File dir = new File(path);
		
		if(!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "inscricoes.csv");
		
		boolean exists = false;
		
		if(arq.exists()) {
			exists = true;
		}
		
		FileWriter fw = new FileWriter(arq, exists);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.write(csvInscricao+"\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
		JOptionPane.showMessageDialog(null, "Inscrição cadastrada com sucesso!");
		
	}
}