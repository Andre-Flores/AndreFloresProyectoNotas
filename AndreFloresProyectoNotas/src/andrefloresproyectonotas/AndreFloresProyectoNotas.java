
package andrefloresproyectonotas;

import java.util.ArrayList;
import java.util.Scanner;

public class AndreFloresProyectoNotas {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int numeroEstudiantes;
        int numeroAsignaturas;

        System.out.print("Ingrese el numero de estudiantes: ");
        numeroEstudiantes = entrada.nextInt();

        System.out.print("Ingrese el numero de asignaturas: ");
        numeroAsignaturas = entrada.nextInt();

        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<String> nombresAsignaturas = new ArrayList<>();

        System.out.println("Ingrese los nombres de las asignaturas:");
// Pedir y Guardar los nombres de las asignaturas
        for (int j = 0; j < numeroAsignaturas; j++) {
            System.out.print("Nombre de la asignatura " + (j + 1) + ": ");
            String nombreAsignatura = entrada.next();
            nombresAsignaturas.add(nombreAsignatura);
        }

        for (int i = 0; i < numeroEstudiantes; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            String nombreEstudiante = entrada.next();

            System.out.print("Ingrese la edad del estudiante " + (i + 1) + ": ");
            int edadEstudiante = entrada.nextInt();

            Estudiante estudiante = new Estudiante(nombreEstudiante, edadEstudiante, numeroAsignaturas);
            estudiantes.add(estudiante);

            System.out.println("Ingrese las calificaciones de " + nombreEstudiante + ":");
            // pedir y guardar las calificaciones de cada asignatura para el estudiante actual
            for (int j = 0; j < numeroAsignaturas; j++) {
                double calificacion;
                do {
                    System.out.print("Nota en " + nombresAsignaturas.get(j) + ": ");
                    calificacion = entrada.nextDouble();
                    if (calificacion < 0 || calificacion > 100) {
                        System.out.println("Error: La calificacion debe estar entre 0 y 100.");
                    }
                } while (calificacion < 0 || calificacion > 100);
                estudiante.setCalificacion(j, calificacion);
            }
        }
// Imprimir las calificaciones ingresadas (\t es como un tab y \n es como un enter)
        System.out.println("\nNotas ingresadas:");
        System.out.print("Estudiante/Asignatura\t");
        for (String nombreAsignatura : nombresAsignaturas) {
            System.out.print(nombreAsignatura + "\t\t");
        }
        System.out.println();
        for (Estudiante estudiante : estudiantes) {
            System.out.print(estudiante.getNombre() + ":\t\t\t");
            for (int j = 0; j < numeroAsignaturas; j++) {
                System.out.print(estudiante.getCalificacion(j) + "\t\t");
            }
            System.out.println();
        }
// Calcular y mostrar los promedios de calificaciones de cada estudiante
        System.out.println("\nPromedio de calificaciones:");
        for (Estudiante estudiante : estudiantes) {
            double promedioEstudiante = estudiante.getPromedio();
            System.out.println(estudiante.getNombre() + ": " + promedioEstudiante);
        }
// Comparar las calificaciones entre los estudiantes
        System.out.println("\nComparacion de calificaciones:");

        for (int i = 0; i < numeroEstudiantes - 1; i++) {
            for (int j = i + 1; j < numeroEstudiantes; j++) {
                Estudiante estudianteI = estudiantes.get(i);
                Estudiante estudianteJ = estudiantes.get(j);

                double promedioEstudianteI = estudianteI.getPromedio();
                double promedioEstudianteJ = estudianteJ.getPromedio();

                if (promedioEstudianteI > promedioEstudianteJ) {
                    System.out.println(estudianteI.getNombre() + " tiene un promedio mas alto que " + estudianteJ.getNombre());
                } else if (promedioEstudianteI < promedioEstudianteJ) {
                    System.out.println(estudianteJ.getNombre() + " tiene un promedio mas alto que " + estudianteI.getNombre());
                } else {
                    System.out.println(estudianteI.getNombre() + " y " + estudianteJ.getNombre() + " tienen el mismo promedio");
                }
            }
        }
// Imprimir la lista de nombres de estudiantes utilizando recursividad
        System.out.println("\nLista de nombres de estudiantes:");
        imprimirArrayListRecursivo(estudiantes, 0);
    }

    public static void imprimirArrayListRecursivo(ArrayList<Estudiante> lista, int indice) {
        if (indice == lista.size()) {
            return;
        }

        System.out.println(lista.get(indice).getNombre());

        imprimirArrayListRecursivo(lista, indice + 1);
    }
}
