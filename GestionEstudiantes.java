import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Persona> personas = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("Seleccione el tipo de persona a agregar:");
                System.out.println("1. Estudiante");
                System.out.println("2. Salir");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        String nombreEstudiante = "";
                        while (true) {
                            try {
                                System.out.println("Ingrese el nombre del estudiante:");
                                nombreEstudiante = scanner.nextLine();
                                if (nombreEstudiante.trim().isEmpty()) {
                                    throw new IllegalArgumentException("El nombre no puede estar vacío.");
                                }
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        int edadEstudiante = 0;
                        while (true) {
                            try {
                                System.out.println("Ingrese la edad del estudiante:");
                                edadEstudiante = scanner.nextInt();
                                scanner.nextLine(); // Limpiar el buffer
                                if (edadEstudiante <= 0) {
                                    throw new IllegalArgumentException("La edad debe ser mayor que 0.");
                                }
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("La edad debe ser un número entero.");
                                scanner.nextLine(); // Limpiar el buffer
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        String cursoEstudiante = "";
                        while (true) {
                            try {
                                System.out.println("Ingrese el curso del estudiante:");
                                cursoEstudiante = scanner.nextLine();
                                if (cursoEstudiante.trim().isEmpty()) {
                                    throw new IllegalArgumentException("El curso no puede estar vacío.");
                                }
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        Persona estudiante = new Estudiante(nombreEstudiante, edadEstudiante, cursoEstudiante);
                        personas.add(estudiante);
                        break;

                    case 2:
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                scanner.nextLine(); 
            }
        }

        System.out.println("Lista de personas:");
        for (Persona persona : personas) {
            System.out.println(persona);
        }

        scanner.close();
    }
}

