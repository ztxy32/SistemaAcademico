package model;

public class Professor {
	String cpf;
	String nome;
	String area;
	float pontos;
	
	@Override
	public String toString() {
		return cpf+";"+nome+";"+area+";"+pontos+";";
	}
	
}
