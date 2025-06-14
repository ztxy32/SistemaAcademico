package model;

public class Disciplina {
	public int cod;
	public String nome;
	public int diaSemana;
	public int horarioInicial;
	public int qtHoras;
	public String curso;
	
	
	@Override
	public String toString() {
		return cod+";"+nome+";"+diaSemana+";"+horarioInicial+";"+qtHoras+";"+curso+";";
	}	
}
