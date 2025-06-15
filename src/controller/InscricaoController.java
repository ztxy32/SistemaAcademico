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
			}catch(IOException e1) {
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

	private void busca() throws IOException{
		Inscricao inscricao = new Inscricao();
		inscricao.cpfProfessor = tfInscricaoCpfProfessor.getText();
		
		inscricao = buscaInscricao(inscricao);
		
		if(inscricao.cpfProfessor != null) {
			taInscricao.setText("Cpf professor: "+inscricao.cpfProfessor+" Código da disciplina: "+inscricao.codDisciplina);
		}else {
			taInscricao.setText("Inscrição não encontrada");
		}
		
	}

	private Inscricao buscaInscricao(Inscricao inscricao) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File arq = new File(path, "inscricao.csv");
		
		if(arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			
			while(linha != null) {
				String[] vetLinha = linha.split(";");
				if(vetLinha[0].equals(inscricao.cpfProfessor)) {
					inscricao.codDisciplina = Integer.parseInt(vetLinha[1]);
					inscricao.codProcesso = Integer.parseInt(vetLinha[2]);
					break;
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			isr.close();
			fis.close();
		}
		return inscricao;
	}

	private void cadastro() throws IOException{
		Inscricao inscricao = new Inscricao();
		inscricao.cpfProfessor = tfInscricaoCpfProfessor.getText();
		inscricao.codDisciplina = Integer.parseInt(tfInscricaoCodDisciplina.getText());
		inscricao.codProcesso = Integer.parseInt(tfInscricaoCodProcesso.getText());
		
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