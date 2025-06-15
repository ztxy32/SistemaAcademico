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
import javax.swing.JTextField;
import model.Professor;

public class ProfessorController implements ActionListener{
	private JTextField tfProfessorCpf;
	private JTextField tfProfessorNome;
	private JTextField tfProfessorArea;
	private JTextField tfProfessorPontos;
	
	public ProfessorController(
		JTextField tfProfessorCpf, 
		JTextField tfProfessorNome, 
		JTextField tfProfessorArea, 
		JTextField tfProfessorPontos
		) {
			super();
			this.tfProfessorCpf = tfProfessorCpf;
			this.tfProfessorNome = tfProfessorNome;
			this.tfProfessorArea = tfProfessorArea;
			this.tfProfessorPontos = tfProfessorPontos;
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

	private void remover() throws IOException {
	    String cpf = tfProfessorCpf.getText();

	    if (cpf.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Informe o CPF do professor para remover", "ERRO", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
	    File arq = new File(path, "professor.csv");

	    if (!arq.exists()) {
	        JOptionPane.showMessageDialog(null, "Arquivo de professores não encontrado.", "ERRO", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    FileInputStream fis = new FileInputStream(arq);
	    InputStreamReader isr = new InputStreamReader(fis);
	    BufferedReader reader = new BufferedReader(isr);

	    StringBuilder sb = new StringBuilder();
	    String linha = reader.readLine();
	    boolean removido = false;

	    while (linha != null) {
	        String[] dados = linha.split(";");
	        if (!dados[0].equals(cpf)) {
	            sb.append(linha).append("\r\n");
	        } else {
	            removido = true;
	        }
	        linha = reader.readLine();
	    }

	    reader.close();
	    isr.close();
	    fis.close();

	    if (!removido) {
	        JOptionPane.showMessageDialog(null, "Professor não encontrado para remoção.", "ERRO", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    FileWriter fw = new FileWriter(arq, false);
	    PrintWriter pw = new PrintWriter(fw);
	    pw.write(sb.toString());
	    pw.flush();
	    pw.close();
	    fw.close();

	    JOptionPane.showMessageDialog(null, "Professor removido com sucesso!");

	    tfProfessorCpf.setText("");
	    tfProfessorNome.setText("");
	    tfProfessorArea.setText("");
	    tfProfessorPontos.setText("");
	}

	private void atualizar() throws IOException {
	    String cpf = tfProfessorCpf.getText();
	    String novoNome = tfProfessorNome.getText();
	    String novaArea = tfProfessorArea.getText();
	    String novosPontosStr = tfProfessorPontos.getText();

	    if (cpf.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Informe o CPF do professor para atualizar", "ERRO", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    float novosPontos;
	    try {
	        novosPontos = Float.parseFloat(novosPontosStr);
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "Informe um valor numérico válido para os pontos", "ERRO", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
	    File arq = new File(path, "professor.csv");

	    if (!arq.exists()) {
	        JOptionPane.showMessageDialog(null, "Arquivo de professores não encontrado.", "ERRO", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    FileInputStream fis = new FileInputStream(arq);
	    InputStreamReader isr = new InputStreamReader(fis);
	    BufferedReader reader = new BufferedReader(isr);

	    StringBuilder sb = new StringBuilder();
	    String linha = reader.readLine();
	    boolean atualizado = false;

	    while (linha != null) {
	        String[] dados = linha.split(";");
	        if (dados[0].equals(cpf)) {
	            sb.append(cpf).append(";").append(novoNome).append(";").append(novaArea).append(";").append(novosPontos).append(";\r\n");
	            atualizado = true;
	        } else {
	            sb.append(linha).append("\r\n");
	        }
	        linha = reader.readLine();
	    }

	    reader.close();
	    isr.close();
	    fis.close();

	    if (!atualizado) {
	        JOptionPane.showMessageDialog(null, "Professor não encontrado para atualização.", "ERRO", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    FileWriter fw = new FileWriter(arq, false);
	    PrintWriter pw = new PrintWriter(fw);
	    pw.write(sb.toString());
	    pw.flush();
	    pw.close();
	    fw.close();

	    JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso!");

	    tfProfessorCpf.setText("");
	    tfProfessorNome.setText("");
	    tfProfessorArea.setText("");
	    tfProfessorPontos.setText("");
	}

	private void busca() throws IOException{
		Professor professor = new Professor();
		
		professor.cpf = tfProfessorCpf.getText();
		
		professor = buscarProfessor(professor);
		
	}

	private Professor buscarProfessor(Professor professor) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File arq = new File(path, "professor.csv");
		
		if(arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			
			while(linha != null) {
				String[] vetLinha = linha.split(";");
				if(vetLinha[0].equals(professor.cpf)) {
					professor.nome = vetLinha[1];
					break;
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			isr.close();
			fis.close();
		}
		return professor;
	}

	private void cadastro() throws IOException{
		Professor professor = new Professor();
		professor.cpf = tfProfessorCpf.getText();
		professor.nome = tfProfessorNome.getText();
		professor.area = tfProfessorArea.getText();
		professor.pontos = Float.parseFloat(tfProfessorPontos.getText());
		
		handleCadastrarProfessor(professor.toString());
		
		tfProfessorCpf.setText("");
		tfProfessorNome.setText("");
		tfProfessorArea.setText("");
		tfProfessorPontos.setText("");
		
	}

	private void handleCadastrarProfessor(String csvProfessor) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File dir = new File(path);
		
		if(!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "professor.csv");
		
		boolean exists = false;
		
		if(arq.exists()) {
			exists = true;
		}
		
		FileWriter fw = new FileWriter(arq, exists);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.write(csvProfessor+"\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
		JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
		
	}
}
