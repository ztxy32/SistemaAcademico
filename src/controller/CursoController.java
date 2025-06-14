package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

import model.Curso;

public class CursoController implements ActionListener{
	private JTextField tfCursoCod;
	private JTextField tfCursoNome;
	private JTextField tfCursoArea;
	
	public CursoController(JTextField tfCursoCod, JTextField tfCursoNome, JTextField tfCursoArea) {
		super();
		this.tfCursoCod = tfCursoCod;
		this.tfCursoNome = tfCursoNome;
		this.tfCursoArea = tfCursoArea;
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
		// TODO Auto-generated method stub
		
	}

	private void cadastro() throws IOException{
		Curso curso = new Curso();
		curso.cod = Integer.parseInt(tfCursoCod.getText());
		curso.nome = tfCursoNome.getText();
		curso.area = tfCursoArea.getText();
		
		System.out.println(curso);
	}
}