package controller;

import model.estrutura.Fila;

public class FilaController {
	public FilaController() {
		super();
	}
	
	public String teste() throws Exception{
		Fila<Integer> f = new Fila<>();
		
		f.queue(1);
		f.queue(2);
		f.queue(3);
		
		return f.toString();
	}
}
