package controller;

import javax.swing.JTextField;

public class CursoController {
	private JTextField cod;
	private JTextField nome;
	private JTextField area;
	
	public CursoController(JTextField cod, JTextField nome, JTextField area) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.area = area;
	}
}