package listas;

public class LinkedList<T> {

    public Nodo<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void insertEnd(T dato, Nodo<T> current) {
        if (this.head == null) {
            this.head = new Nodo<>(dato);
        } else {
            if (current.next == null) {
                current.next = new Nodo<>(dato);
            } else {
                insertEnd(dato, current.next);
            }
        }
    }

    public void insertStart(T dato) {
        if (this.head == null) {
            this.head = new Nodo<>(dato);
        } else {
            Nodo<T> newNodo = new Nodo<>(dato);
            newNodo.next = this.head;
            this.head = newNodo;
        }
    }

    public Nodo<T> deleteHead() {
        if (this.head == null) {
            return null;
        }
        Nodo<T> aux = this.head;
        this.head = this.head.next;
        return aux;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public Nodo<T> deleteElementForValues(T value) {
        if (this.head == null) {
            return null;
        }
        Nodo<T> current = this.head;
        Nodo<T> previous = null;
        while (current != null) {
            if (current.value == value) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            this.head = this.head.next;
            current.next = null;
            return current;
        }
        if (current == null) {
            return null;
        }
        previous.next = current.next;
        current.next = null;
        return current;
    }

    @Override
    public String toString() {
        String state = "";
        Nodo<T> current = this.head;

        while (current != null) {
            state += "[" + current.value + "]->";
            current = current.next;
        }

        return state + current;
    }

    public static void main(String[] args) {
    }
}
