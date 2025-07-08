package AgendaNotas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Curso curso = new Curso();

        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = scanner.nextInt();

        System.out.print("Ingrese la cantidad de notas por alumno: ");
        int cantidadNotas = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        // Ingreso de datos
        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.print("Nombre del alumno " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            Estudiante estudiante = new Estudiante(nombre);

            for (int j = 0; j < cantidadNotas; j++) {
                double nota;
                do {
                    System.out.print("Nota " + (j + 1) + " para " + nombre + " (1.0 a 7.0): ");
                    nota = scanner.nextDouble();
                } while (nota < 1.0 || nota > 7.0);
                estudiante.agregarNota(nota);
            }

            scanner.nextLine(); // limpiar buffer
            curso.agregarEstudiante(estudiante);
        }

        double promedioCurso = curso.obtenerPromedioCurso();

        // Menú
        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Mostrar promedio, nota máxima y mínima por estudiante");
            System.out.println("2. Evaluar si una nota es aprobatoria o reprobatoria");
            System.out.println("3. Comparar nota con promedio del curso");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> curso.mostrarPromedios();

                case 2 -> {
                    System.out.print("Nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    if (curso.contieneEstudiante(nombre)) {
                        System.out.print("Ingrese la nota a evaluar: ");
                        double nota = scanner.nextDouble();
                        if (nota >= 1.0 && nota <= 7.0) {
                            System.out.println(nota >= 4.0 ? "Nota Aprobatoria" : "Nota Reprobatoria");
                        } else {
                            System.out.println("Nota fuera de rango.");
                        }
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                }

                case 3 -> {
                    System.out.print("Nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    if (curso.contieneEstudiante(nombre)) {
                        System.out.print("Ingrese la nota a comparar: ");
                        double nota = scanner.nextDouble();
                        if (nota >= 1.0 && nota <= 7.0) {
                            if (nota > promedioCurso) {
                                System.out.println("Nota sobre el promedio del curso (" + promedioCurso + ")");
                            } else if (nota < promedioCurso) {
                                System.out.println("Nota bajo el promedio del curso (" + promedioCurso + ")");
                            } else {
                                System.out.println("Nota igual al promedio del curso.");
                            }
                        } else {
                            System.out.println("Nota fuera de rango.");
                        }
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                }

                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}