package model;

public class Disciplina {
	public int cod;
	public String nome;
	public String diaSemana;
	public String horarioInicial;
	public int qtHoras;
	public String curso;
	
	
	@Override
	public String toString() {
		return cod+";"+nome+";"+diaSemana+";"+horarioInicial+";"+qtHoras+";"+curso+";";
	}	
}
