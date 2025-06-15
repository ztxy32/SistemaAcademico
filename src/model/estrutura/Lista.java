package model.estrutura;

public class Lista<T> implements ILista<T>{
    Node<T> primeiro;
    Node<T> ultimo;

    public Lista(){
        primeiro = null;
    }

    @Override
    public boolean isEmpty() {
        if(primeiro == null){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        int count = 0;
        if(!isEmpty()){
            Node<T> buffer = primeiro;

            while(buffer != null){
                count++;
                buffer = buffer.getProximo();
            }
        }
        return count;
    }

    @Override
    public void addFirst(T valor) {
        Node<T> elemento = new Node<>(valor);

        elemento.setProximo(primeiro);
        primeiro = elemento;
    }

    @Override
    public void addLast(T valor) throws Exception {
        if(isEmpty()){
            addFirst(valor);
            return;
        }

        int tamanho = size();
        Node<T> elemento = new Node<>(valor);

        elemento.setProximo(null);
        Node<T> ultimo = getNode(tamanho - 1);
        ultimo.setProximo(elemento);
    }

    @Override
    public void add(T valor, int posicao) throws Exception {
        int tamanho = size();
        if(posicao < 0 || posicao > tamanho){
            throw new Exception("Posição inválida");
        }

        if(posicao == 0){
            addFirst(valor);
        }else if(posicao == tamanho){
            addLast(valor);
        }else{
            Node<T> elemento = new Node<T>(valor);
            Node<T> anterior = getNode(posicao - 1);

            elemento.setProximo(anterior.getProximo());
            anterior.setProximo(elemento); 
        }
    }

    @Override
    public void removeFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("Lista vazia");
        }
        primeiro = primeiro.getProximo();
    }

    @Override
    public void removeLast() throws Exception {
        if(isEmpty()){
            throw new Exception("Lista vazia");
        }

        if(size() == 1){
            removeFirst();
        }else{
            Node<T> penultimo = getNode(size() - 2);
            penultimo.setProximo(null);
        }
    }

    @Override
    public void remove(int posicao) throws Exception {
        if(isEmpty()){
            throw new Exception("Lista vazia");
        }
        if(posicao < 0 || posicao > size() - 1){
            throw new Exception("Posição inválida");
        }
        if(posicao == 0){
            removeFirst();
        }else if(posicao == size() - 1){
            removeLast();
        }else{
            Node<T> anterior = getNode(posicao -1 );
            Node<T> atual = getNode(posicao);

            anterior.setProximo(atual.getProximo());
        }
    }

    @Override
    public T getPosicao(int posicao) throws Exception{
        Node<T> elemento = getNode(posicao);
        return elemento.getElemento();
    }

    private Node<T> getNode(int posicao) throws Exception{
        if(isEmpty()){
            throw new Exception("Lista vazia");
        }
        int tamanho = size();

        if(posicao < 0 || posicao > tamanho-1){
            throw new Exception("Posição inválida");
        }

        Node<T> buffer = primeiro;
        int count = 0;

        while(count < posicao){
            buffer = buffer.getProximo();
            count++;
        }

        return buffer;
    }

    @Override
    public String toString(){
       if(this.primeiro == null){
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        Node<T> ponteiro = this.primeiro;
        
        for(int i = 0; i < (size() - 1); i++){
            builder.append(ponteiro.getElemento()).append(", ");
            ponteiro = ponteiro.getProximo();
        }
        builder.append(ponteiro.getElemento()).append("]");

        return builder.toString();

    }

    @Override
    public void invert(){
        for(int i = 0; i < size(); i++){
            try{
                add(getPosicao(size()-1), i);
                removeLast();
            }catch(Exception e ){e.printStackTrace();}
        }
    }
}