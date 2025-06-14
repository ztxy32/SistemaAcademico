package controller;

import javax.swing.JTextField;

public class OferecimentoController {
	private JTextField codigoProcesso;
	private JTextField disciplina;
	private JTextField ativo;
	
	public OferecimentoController(JTextField codigoProcesso, JTextField disciplina, JTextField ativo) {
		super();
		this.codigoProcesso = codigoProcesso;
		this.disciplina = disciplina;
		this.ativo = ativo;
	}	
}