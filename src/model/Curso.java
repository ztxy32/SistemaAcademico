package model;

public class Curso {
	String cod;
	String nome;
	String area;
	
	@Override
	public String toString() {
		return cod+";"+nome+";"+area+";";
	}
}