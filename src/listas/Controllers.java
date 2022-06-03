package listas;

public class Controllers {

    public boolean esPrimo(int n, int i, int cont) {
        if (n <= 1) {
            return false;
        }
        if (n % i == 0) {
            cont++;
        }
        if (i == n) {
            return cont == 2;
        }
        return esPrimo(n, i + 1, cont);
    }
}
