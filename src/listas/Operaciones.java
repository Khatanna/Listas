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

    public LinkedList<Integer> unirListaIntercaladamente(LinkedList<Integer> listA, LinkedList<Integer> listB) {
        Nodo<Integer> currentA = listA.head;
        Nodo<Integer> currentB = listB.head;
        LinkedList<Integer> finalList = new LinkedList<>();

        while (currentA != null || currentB != null) {
            if (currentA != null) {
                finalList.insertEnd(currentA.value, finalList.head);
                currentA = currentA.next;
            }
            if (currentB != null) {
                finalList.insertEnd(currentB.value, finalList.head);
                currentB = currentB.next;
            }
        }
        return finalList;
    }

    public void eliminarMenoresDeUnElementoDado(LinkedList<Integer> List, int elemento) {
        Nodo<Integer> current = List.head;
        LinkedList<Integer> auxList = new LinkedList<>();

        while (current != null) {
            if (current.value > elemento) {
                auxList.insertEnd(current.value, auxList.head);
            }
            current = current.next;
        }

        List.head = auxList.head;
    }

    public int elementoMayor(LinkedList<Integer> List) {
        int mayor = 0;
        Nodo<Integer> current = List.head;

        while (current != null) {
            if (current.value > mayor) {
                mayor = current.value;
            }
            current = current.next;
        }
        return mayor;
    }

    public int elementoMenor(LinkedList<Integer> List) {
        int menor = elementoMayor(List);
        Nodo<Integer> current = List.head;

        while (current != null) {
            if (current.value < menor) {
                menor = current.value;
            }
            current = current.next;
        }
        return menor;
    }

    public int segundoElementoMenor(LinkedList<Integer> List) {
        List.deleteElementForValues(elementoMenor(List));
        int menor = elementoMayor(List);
        Nodo<Integer> current = List.head;

        while (current != null) {
            if (current.value < menor) {
                menor = current.value;
            }
            current = current.next;
        }
        return menor;
    }
    
    public static void main(String args[]) {
        Operaciones op = new Operaciones();
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> listB = new LinkedList<>();
        
        list.insertEnd(10, list.head);
        list.insertEnd(20, list.head);
        list.insertEnd(30, list.head);
        list.insertEnd(40, list.head);
        list.insertEnd(50, list.head);
        list.insertEnd(60, list.head);
        list.insertEnd(70, list.head);
        listB.insertEnd(80, listB.head);
        listB.insertEnd(90, listB.head);
        listB.insertEnd(100, listB.head);
        
        list.concat(listB);
        
        System.out.println(list);
        System.out.println(listB);
    }
}
