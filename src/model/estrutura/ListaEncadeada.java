package model.estrutura;

public class ListaEncadeada<T> {
    private Node<T> inicio;
    private Node<T> ultimo;
    private int size;

    public void Add(T elemento){
    	Node<T> buffer = new Node<T>(elemento);

        if(this.inicio == null){
            this.inicio = buffer;
        }else{
            this.ultimo.setNext(buffer);
        }
        this.ultimo = buffer;
        
        this.size++;
    }
    public int getSize(){
        return this.size;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(inicio).append("]");
        return builder.toString();
    }
}
