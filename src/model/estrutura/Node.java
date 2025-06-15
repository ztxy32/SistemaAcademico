package model.estrutura;

public class Node<T>{
    private Node<T> proximo;
    private T elemento;

    public Node(T elemento){
        this.elemento = elemento;
    }
    public Node(T elemento, Node<T> proximo){
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public void setProximo(Node<T> proximo){
        this.proximo = proximo;
    }
    public Node<T> getProximo(){
        return this.proximo;
    }

    public void setElemento(T elemento){
        this.elemento = elemento;
    }
    public T getElemento(){
        return this.elemento;
    }

    @Override
    public String toString(){
        return elemento.toString();
    }
}