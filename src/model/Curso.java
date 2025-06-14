package model;

public class Curso {
	public int cod;
	public String nome;
	public String area;
	
	@Override
	public String toString() {
		return cod+";"+nome+";"+area+";";
	}
}