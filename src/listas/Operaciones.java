package listas;

public class Operaciones {

    public void generarLista(LinkedList<Integer> Lista, int n) {
        for (int i = 0; i < n; i++) {
            int value = (int) (Math.random() * 50 + 1);
            Lista.insertEnd(value, Lista.head);
        }
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

    public static void main(String args[]) {
        Operaciones op = new Operaciones();
        LinkedList<Integer> lista = new LinkedList<>();

        op.generarLista(lista, 10);
        System.out.println(lista);
        int total = op.SumarTodosLosElementos(lista);
        int nodos = op.ContarNodos(lista);
        int pares = op.ContarNodosConValoresPares(lista);
        int primos = op.SumarTodosLosElementosPrimos(lista);
        System.out.println(total);
        System.out.println(nodos);
        System.out.println(pares);
        System.out.println(primos);
    }
}
