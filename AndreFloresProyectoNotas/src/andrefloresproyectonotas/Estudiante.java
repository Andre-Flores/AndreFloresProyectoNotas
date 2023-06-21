
package andrefloresproyectonotas;

public class Estudiante {

    private String nombre;
    private int edad;
    private double[] calificaciones;

    public Estudiante(String nombre, int edad, int numeroAsignaturas) {
        this.nombre = nombre;
        this.edad = edad;
        calificaciones = new double[numeroAsignaturas];
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getCalificacion(int indice) {
        return calificaciones[indice];
    }

    public void setCalificacion(int indice, double calificacion) {
        calificaciones[indice] = calificacion;
    }

    public double getPromedio() {
        int numeroAsignaturas = calificaciones.length;
        double suma = 0;

        for (int i = 0; i < numeroAsignaturas; i++) {
            suma += calificaciones[i];
        }

        return suma / numeroAsignaturas;
    }
}
