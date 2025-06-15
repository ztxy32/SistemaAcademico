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
import model.Curso;

public class CursoController implements ActionListener{
	private JTextField tfCursoCod;
	private JTextField tfCursoNome;
	private JTextField tfCursoArea;
	private JTextArea taCurso;
	
	public CursoController(
		JTextField tfCursoCod, 
		JTextField tfCursoNome, 
		JTextField tfCursoArea, 
		JTextArea taCurso) {
			super();
			this.tfCursoCod = tfCursoCod;
			this.tfCursoNome = tfCursoNome;
			this.tfCursoArea = tfCursoArea;
			this.taCurso = taCurso;
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
			}catch(Exception e1) {
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
	    String cod = tfCursoCod.getText();

	    if (cod.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Informe o código do curso para remover", "ERRO", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
	    File arq = new File(path, "curso.csv");

	    if (!arq.exists()) {
	        JOptionPane.showMessageDialog(null, "Arquivo não encontrado.", "ERRO", JOptionPane.ERROR_MESSAGE);
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
	        if (!dados[0].equals(cod)) {
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
	        JOptionPane.showMessageDialog(null, "Curso não encontrado para remoção.", "ERRO", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    FileWriter fw = new FileWriter(arq, false);
	    PrintWriter pw = new PrintWriter(fw);
	    pw.write(sb.toString());
	    pw.flush();
	    pw.close();
	    fw.close();

	    JOptionPane.showMessageDialog(null, "Curso removido com sucesso!");

	    tfCursoCod.setText("");
	    tfCursoNome.setText("");
	    tfCursoArea.setText("");
	    taCurso.setText("");
	}

	private void atualizar() throws Exception {
	    String cod = tfCursoCod.getText();
	    String novoNome = tfCursoNome.getText();
	    String novaArea = tfCursoArea.getText();

	    if (cod.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Informe o código do curso para atualizar", "ERRO", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
	    File arq = new File(path, "curso.csv");

	    if (!arq.exists()) {
	        JOptionPane.showMessageDialog(null, "Arquivo de cursos não encontrado.", "ERRO", JOptionPane.ERROR_MESSAGE);
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
	        if (dados[0].equals(cod)) {
	            sb.append(cod).append(";").append(novoNome).append(";").append(novaArea).append(";\r\n");
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
	        JOptionPane.showMessageDialog(null, "Curso não encontrado para atualização.", "ERRO", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    FileWriter fw = new FileWriter(arq, false);
	    PrintWriter pw = new PrintWriter(fw);
	    pw.write(sb.toString());
	    pw.flush();
	    pw.close();
	    fw.close();

	    JOptionPane.showMessageDialog(null, "Curso atualizado com sucesso!");

	    tfCursoCod.setText("");
	    tfCursoNome.setText("");
	    tfCursoArea.setText("");
	    taCurso.setText("");
	}

	private void busca() throws IOException{
		Curso curso = new Curso();		
		curso.cod = tfCursoCod.getText();
		
		curso = buscarCurso(curso);
		if(curso.nome != null) {
			taCurso.setText("Código do curso: "+curso.cod+" Nome: "+curso.nome);
		}
	}

	private Curso buscarCurso(Curso curso) throws IOException{
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File arq = new File(path, "curso.csv");
		
		if(arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			
			while(linha != null) {
				String[] vetLinha = linha.split(";");
				if(vetLinha[0].equals(String.valueOf(curso.cod))) {
					curso.nome = vetLinha[1];
					break;
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			isr.close();
			fis.close();
		}
		return curso;
	}

	private void cadastro() throws IOException{
		Curso curso = new Curso();
		curso.cod = tfCursoCod.getText();
		curso.nome = tfCursoNome.getText();
		curso.area = tfCursoArea.getText();
		
		handleCadastrarCurso(curso.toString());
		
		tfCursoCod.setText("");
		tfCursoNome.setText("");
		tfCursoArea.setText("");
	}

	private void handleCadastrarCurso(String csvCurso) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File dir = new File(path);
		
		if(!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "curso.csv");
		
		boolean exists = false;
		
		if(arq.exists()) {
			exists = true;
		}
		
		FileWriter fw = new FileWriter(arq, exists);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.write(csvCurso+"\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
		JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
		
	}
}