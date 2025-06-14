package model;

public class Professor {
	public String cpf;
	public String nome;
	public String area;
	public float pontos;
	
	@Override
	public String toString() {
		return cpf+";"+nome+";"+area+";"+pontos+";";
	}
	
}
