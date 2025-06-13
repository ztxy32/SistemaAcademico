package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ProfessorController implements ActionListener{
	private JTextField tfCPF;
	private JTextField tfNome;
	private JTextField tfArea;
	private JTextField tfPontos;
	
	public ProfessorController(JTextField tfCPF, JTextField tfNome, JTextField tfArea, JTextField tfPontos) {
		super();
		this.tfCPF = tfCPF;
		this.tfNome = tfNome;
		this.tfArea = tfArea;
		this.tfPontos = tfPontos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
