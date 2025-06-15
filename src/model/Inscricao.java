package model;

public class Inscricao {
	public String cpfProfessor;
	public String codDisciplina;
	public String codProcesso;
	
	@Override
	public String toString() {
		return cpfProfessor+";"+codDisciplina+";"+codProcesso+";";
	}
	
}
