package model.estrutura;

public class Fila<T> extends EstruturaEstatica<T>{
	public Fila() {
		super();
	}
	public Fila(int capacidade) {
		super(capacidade);
	}
	
	public void queue(T elemento) {	
		super.adiciona(elemento);
	}
	public T dequeue() {
		final int POSICAO = 0;
		
		if(this.isEmpty()) {return null;}
		
		T dequeueElement = this.elementos[POSICAO];
		super.remove(POSICAO);
		
		return dequeueElement;
	}
	
	public T peek() {
		return this.elementos[0];
	}
}