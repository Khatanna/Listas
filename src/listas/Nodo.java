package listas;

public class Nodo<T> {
    public T value;
    public Nodo<T> next;
    
    public Nodo(T value){
        this.value = value;
        this.next = null;
    }
}

