package model;

public class Oferecimento {
	public String codigoProcesso;
	public String disciplina;
	public boolean ativo;
	
	@Override
	public String toString() {
		return codigoProcesso + ";" + disciplina + ";" + ativo+ ";";
	}
	
}
