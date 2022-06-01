package listas;

import javax.swing.JOptionPane;

public class LinkedList<T> {

    private Nodo<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void insertEnd(T dato, Nodo<T> current) {
        if (this.head == null) {
            this.head = new Nodo<>(dato);
        } else {
            if (current.getNext() == null) {
                current.setNext(new Nodo<>(dato));
            } else {
                insertEnd(dato, current.getNext());
            }
        }
    }

    public void insertStart(T dato) {
        if (this.head == null) {
            this.head = new Nodo<>(dato);
        } else {
            Nodo<T> newNodo = new Nodo<>(dato);
            newNodo.setNext(this.head);
            this.head = newNodo;
        }
    }

    public Nodo<T> deleteHead() {
        if (this.head == null) {
            return null;
        }
        Nodo<T> aux = this.head;
        this.head = this.head.getNext();
        return aux;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
    
    public Nodo<T> deleteElementForValues(T value){
        if(this.head == null){
            return null;
        }
        Nodo<T> current = this.head;
        Nodo<T> previous = null;
        while(current != null){
            if(current.getValue() == value){
                break;
            }
            previous = current;
            current = current.getNext();
        }
        if(previous == null){
            this.head = this.head.getNext();
            current.setNext(null);
            return current;
        }
        if(current == null){
            return null;
        }
        previous.setNext(current.getNext());
        current.setNext(null);
        return current;
    }

    @Override
    public String toString() {
        String state = "";
        Nodo<T> current = this.head;

        while (current != null) {
            state += "[" + current.getValue() + "]->";
            current = current.getNext();
        }

        return state + current;
    }

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();

        lista.insertEnd(10, lista.head);
        lista.insertEnd(20, lista.head);
        lista.insertEnd(30, lista.head);
        lista.insertEnd(40, lista.head);
        lista.insertStart(0);
        lista.insertStart(-10);
        lista.insertStart(-20);
        lista.insertStart(-30);
        lista.insertStart(-40);
      
        System.out.println(lista);
        lista.deleteElementForValues(20);
        System.out.println(lista);
    }
}
