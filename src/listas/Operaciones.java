package listas;

public class Operaciones {

    public LinkedList<Integer> generarLista(int n) {
        LinkedList<Integer> Lista = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int value = (int) (Math.random() * 50 + 1);
            Lista.insertEnd(value, Lista.head);
        }
        return Lista;
    }

    public int SumarTodosLosElementos(LinkedList<Integer> Lista) {
        Nodo<Integer> aux = Lista.head;
        int resultado = 0;

        while (aux != null) {
            resultado += aux.value;
            aux = aux.next;
        }

        return resultado;
    }

    public int ContarNodos(LinkedList<Integer> Lista) {
        Nodo<Integer> aux = Lista.head;
        int count = 0;

        while (aux != null) {
            count++;
            aux = aux.next;
        }

        return count;
    }

    public int SumarTodosLosElementosPrimos(LinkedList<Integer> Lista) {
        Nodo<Integer> aux = Lista.head;
        Controllers controller = new Controllers();
        int resultado = 0;

        while (aux != null) {
            if (controller.esPrimo(aux.value, 1, 0)) {
                resultado += aux.value;
            }
            aux = aux.next;
        }

        return resultado;
    }

    public int ContarNodosConValoresPares(LinkedList<Integer> Lista) {
        Nodo<Integer> aux = Lista.head;
        int count = 0;

        while (aux != null) {
            count = aux.value % 2 == 0 ? count + 1 : count;

            aux = aux.next;
        }

        return count;
    }

    public LinkedList<Integer> sumarDosListas(LinkedList<Integer> ListaA, LinkedList<Integer> ListaB) {
        if (this.ContarNodos(ListaA) != this.ContarNodos(ListaB)) {
            return null;
        }
        LinkedList<Integer> listaResultado = new LinkedList<>();
        Nodo<Integer> auxA = ListaA.head;
        Nodo<Integer> auxB = ListaB.head;

        while (auxA != null && auxB != null) {
            listaResultado.insertEnd(auxA.value + auxB.value, listaResultado.head);
            auxA = auxA.next;
            auxB = auxB.next;
        }

        return listaResultado;
    }

    public void insertInOrder(LinkedList<Integer> Lista, int value) {
        Nodo<Integer> nuevo = new Nodo(value);
        if (Lista.head == null) {
            Lista.head = nuevo;
        } else {
            Nodo<Integer> current = Lista.head;
            Nodo<Integer> previous = null;

            while (current != null && current.value < value) {
                previous = current;
                current = current.next;
            }
            if (previous == null) {
                Lista.head = nuevo;
            } else {
                previous.next = nuevo;
            }
            nuevo.next = current;
        }
    }

    public static void main(String args[]) {

    }
}
