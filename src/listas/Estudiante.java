package listas;

public class Estudiante {
    private String ci;
    private String nombre;
    private int edad;
    private String telefono;
    
    public Estudiante(String ci, String nombre, int edad, String telefono){
        this.ci = ci;
        this.nombre =nombre;
        this.edad = edad;
        this.telefono = telefono;
    }
    
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("123", "Charlie", 19, "1109");
        Nodo nodo = new Nodo(estudiante);
        
    }
}
