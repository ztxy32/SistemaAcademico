package model;

public class Disciplina {
	public String cod;
	public String nome;
	public String diaSemana;
	public String horarioInicial;
	public String qtHoras;
	public String curso;
	
	
	@Override
	public String toString() {
		return cod+";"+nome+";"+diaSemana+";"+horarioInicial+";"+qtHoras+";"+curso+";";
	}	
}
