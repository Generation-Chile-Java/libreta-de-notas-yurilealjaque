package AgendaNotas;

import java.util.HashMap;
import java.util.ArrayList;

public class Curso {
    private HashMap<String, Estudiante> estudiantes;

    public Curso() {
        estudiantes = new HashMap<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.put(estudiante.getNombre(), estudiante);
    }

    public Estudiante obtenerEstudiante(String nombre) {
        return estudiantes.get(nombre);
    }

    public boolean contieneEstudiante(String nombre) {
        return estudiantes.containsKey(nombre);
    }

    public void mostrarPromedios() {
        for (Estudiante est : estudiantes.values()) {
            System.out.println("\nEstudiante: " + est.getNombre());
            System.out.println("Promedio: " + est.obtenerPromedio());
            System.out.println("Máxima: " + est.notaMaxima());
            System.out.println("Mínima: " + est.notaMinima());
        }
    }

    public double obtenerPromedioCurso() {
        double suma = 0;
        int totalNotas = 0;
        for (Estudiante est : estudiantes.values()) {
            for (double nota : est.getNotas()) {
                suma += nota;
                totalNotas++;
            }
        }
        return totalNotas == 0 ? 0 : suma / totalNotas;
    }
}