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

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Disciplina;

public class DisciplinaController implements ActionListener{
	private JTextField tfDisciplinaCod;
	private JTextField tfDisciplinNome;
	private JTextField tfDisciplinaDiaSemana;
	private JTextField tfDisciplinaHorarioInicial;
	private JTextField tfDisciplinaQtHoras;
	private JTextField tfDisciplinaCurso;
	private JTextArea taDisciplina;
	
	
	public DisciplinaController(
			JTextField tfDisciplinaCod, JTextField tfDisciplinNome,
			JTextField tfDisciplinaDiaSemana, JTextField tfDisciplinaHorarioInicial, JTextField tfDisciplinaQtHoras,
			JTextField tfDisciplinaCurso, JTextArea taDisciplina) {
		super();
		this.tfDisciplinaCod = tfDisciplinaCod;
		this.tfDisciplinNome = tfDisciplinNome;
		this.tfDisciplinaDiaSemana = tfDisciplinaDiaSemana;
		this.tfDisciplinaHorarioInicial = tfDisciplinaHorarioInicial;
		this.tfDisciplinaQtHoras = tfDisciplinaQtHoras;
		this.tfDisciplinaCurso = tfDisciplinaCurso;
		this.taDisciplina = taDisciplina;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals("Cadastrar")) {
			try {
				cadastro();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
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
		
	}


	private void busca() throws IOException {
		Disciplina disciplina = new Disciplina();
		
		disciplina.cod = Integer.parseInt(tfDisciplinaCod.getText());
		
		disciplina = buscaDisciplina(disciplina);
		if(disciplina.nome != null) {
			taDisciplina.setText("Codigo: "+disciplina.cod+" Nome: "+disciplina.nome);
		}else {
			taDisciplina.setText("Disciplina não encontrada");
		}
		
	}


	private Disciplina buscaDisciplina(Disciplina disciplina) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File arq = new File(path, "disciplina.csv");
		
		if(arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			
			while(linha != null) {
				String[] vetLinha = linha.split(";");
				if(vetLinha[0].equals(String.valueOf(disciplina.cod))) {
					disciplina.nome = vetLinha[1];
					break;
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			isr.close();
			fis.close();
		}
		return disciplina;
	}


	private void cadastro() throws IOException {
		Disciplina disciplina = new Disciplina();
		
		//capturar input
		
		disciplina.cod = Integer.parseInt(tfDisciplinaCod.getText());
		disciplina.nome = tfDisciplinNome.getText();
		disciplina.diaSemana = Integer.parseInt(tfDisciplinaDiaSemana.getText());
		disciplina.horarioInicial = Integer.parseInt(tfDisciplinaHorarioInicial.getText());
		disciplina.qtHoras = Integer.parseInt(tfDisciplinaQtHoras.getText());
		disciplina.curso = tfDisciplinaCurso.getText();
		
		handleCadastrarDisciplina(disciplina.toString());
		
		//limpar input
		
		tfDisciplinaCod.setText("");
		tfDisciplinNome.setText("");
		tfDisciplinaDiaSemana.setText("");
		tfDisciplinaHorarioInicial.setText("");
		tfDisciplinaQtHoras.setText("");
		tfDisciplinaCurso.setText("");
	}


	private void handleCadastrarDisciplina(String csvDisciplina) throws IOException{
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File dir = new File(path);
		
		if(!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "disciplina.csv");
		
		boolean exists = false;
		
		if(arq.exists()) {
			exists = true;
		}
		
		FileWriter fw = new FileWriter(arq, exists);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.write(csvDisciplina+"\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
	}
	
	
}
