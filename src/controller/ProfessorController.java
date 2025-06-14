package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

import model.Professor;

public class ProfessorController implements ActionListener{
	private JTextField tfProfessorCpf;
	private JTextField tfProfessorNome;
	private JTextField tfProfessorArea;
	private JTextField tfProfessorPontos;
	
	public ProfessorController(JTextField tfProfessorCpf, JTextField tfProfessorNome, JTextField tfProfessorArea, JTextField tfProfessorPontos) {
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
		Professor professor = new Professor();
		professor.cpf = tfProfessorCpf.getText();
		professor.nome = tfProfessorNome.getText();
		professor.area = tfProfessorArea.getText();
		professor.pontos = Float.parseFloat(tfProfessorPontos.getText());
		
		System.out.println(professor);
		
	}
}
