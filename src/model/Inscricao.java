package model;

public class Inscricao {
	public String cpfProfessor;
	public int codDisciplina;
	public int codProcesso;
	
	@Override
	public String toString() {
		return cpfProfessor+";"+codDisciplina+";"+codProcesso+";";
	}
	
}
