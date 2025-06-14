package model;

public class Inscricao {
	String cpfProfessor;
	int codDisciplina;
	String codProcesso;
	
	@Override
	public String toString() {
		return cpfProfessor+";"+codDisciplina+";"+codProcesso+";";
	}
	
}
