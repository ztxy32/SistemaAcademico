package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

import model.Inscricao;

public class InscricaoController implements ActionListener{
	
	private JTextField  tfInscricaoCpfProfessor;
	private JTextField  tfInscricaoCodDisciplina;
	private JTextField  tfInscricaoCodProcesso;
	
	public InscricaoController(JTextField tfInscricaoCpfProfessor, JTextField tfInscricaoCodDisciplina, JTextField tfInscricaoCodProcesso) {
		super();
		this.tfInscricaoCpfProfessor = tfInscricaoCpfProfessor;
		this.tfInscricaoCodDisciplina = tfInscricaoCodDisciplina;
		this.tfInscricaoCodProcesso = tfInscricaoCodProcesso;
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
		Inscricao inscricao = new Inscricao();
		inscricao.cpfProfessor = tfInscricaoCpfProfessor.getText();
		inscricao.codDisciplina = Integer.parseInt(tfInscricaoCodDisciplina.getText());
		inscricao.codProcesso = tfInscricaoCodProcesso.getText();
		
		System.out.println(inscricao);
		
	}
}