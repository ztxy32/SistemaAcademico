package controller;

import javax.swing.JTextField;

public class InscricaoController {
	
	private JTextField  cpfProfessor;
	private JTextField  codDisciplina;
	private JTextField  codProcesso;
	
	public InscricaoController(JTextField cpfProfessor, JTextField codDisciplina, JTextField codProcesso) {
		super();
		this.cpfProfessor = cpfProfessor;
		this.codDisciplina = codDisciplina;
		this.codProcesso = codProcesso;
	}
}