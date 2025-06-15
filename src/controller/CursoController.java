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