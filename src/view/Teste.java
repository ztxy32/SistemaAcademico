package view;

import controller.FilaController;

public class Teste {
	public static void main(String[]args) {
		try {
			FilaController obj = new FilaController();
			System.out.println(obj.teste());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}