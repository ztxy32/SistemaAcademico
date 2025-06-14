package model;

public class Inscricao {
	public String cpfProfessor;
	public int codDisciplina;
	public String codProcesso;
	
	@Override
	public String toString() {
		return cpfProfessor+";"+codDisciplina+";"+codProcesso+";";
	}
	
}
