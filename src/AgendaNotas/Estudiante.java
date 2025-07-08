package AgendaNotas;

import java.util.ArrayList;
import java.util.Collections;

public class Estudiante {
    private String nombre;
    private ArrayList<Double> notas;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarNota(double nota) {
        if (nota >= 1.0 && nota <= 7.0) {
            notas.add(nota);
        }
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public double obtenerPromedio() {
        if (notas.isEmpty()) return 0;
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    public double notaMaxima() {
        return Collections.max(notas);
    }

    public double notaMinima() {
        return Collections.min(notas);
    }
}
