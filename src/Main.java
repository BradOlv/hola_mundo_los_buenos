import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Model.Conexion;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("--- Menú de Utilidades ---");
            System.out.println("1. Verificar si un número es par o impar");
            System.out.println("2. Verificar si un número es primo");
            System.out.println("3. Adivinar un número");
            System.out.println("4. Gestor de tareas");
            System.out.println("5. Convertir Fahrenheit a Celsius");
            System.out.println("6. Probar la conexión a la base de datos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    verificarParImpar(sc);
                    break;
                case 2:
                    verificarPrimo(sc);
                    break;
                case 3:
                    jugarAdivinanza();
                    break;
                case 4:
                    gestionarTareas(sc);
                    break;
                case 5:
                    convertirTemperatura();
                    break;
                case 6:
                    probarConexion();
                    break;
                case 7:
                    System.out.println("Saliendo del programa. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }

            System.out.println();

        } while (opcion != 7);

        sc.close();
    }

    public static void verificarParImpar(Scanner scanner) {
        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();
        if (numero % 2 == 0) {
            System.out.println("El número " + numero + " es par.");
        } else {
            System.out.println("El número " + numero + " es impar.");
        }
    }

    public static void verificarPrimo(Scanner sc) {
        System.out.print("Ingresa un número: ");
        int num = sc.nextInt();
        boolean esPrimo = true;

        if (num <= 1) {
            esPrimo = false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    esPrimo = false;
                    break;
                }
            }
        }

        if (esPrimo) {
            System.out.println("El número " + num + " es primo.");
        } else {
            System.out.println("El número " + num + " no es primo.");
        }
    }

    public static void jugarAdivinanza() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int numeroAleatorio = random.nextInt(10) + 1;
        int intento;
        boolean adivinado = false;
        System.out.println("He pensado un número entre 1 y 10. Intenta adivinarlo");

        while (!adivinado) {
            System.out.print("Ingresa tu intento: ");
            intento = sc.nextInt();

            if (intento == numeroAleatorio) {
                System.out.println("¡Número adivinado!");
                adivinado = true;
            } else if (intento < numeroAleatorio) {
                System.out.println("No es el número, prueba con uno más grande.");
            } else {
                System.out.println("No es el número, prueba con uno más pequeño.");
            }
        }
    }

    public static void gestionarTareas(Scanner scanner) {
        Tareas tareas = new Tareas();
        int opcionTareas;
        do {
            System.out.println("--- Gestor de Tareas ---");
            System.out.println("1. Ver tareas");
            System.out.println("2. Agregar tarea");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcionTareas = scanner.nextInt();
            scanner.nextLine();
            switch (opcionTareas) {
                case 1:
                    tareas.verTareas();
                    break;
                case 2:
                    tareas.agregarTarea(scanner);
                    break;
                case 3:
                    tareas.eliminarTarea(scanner);
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println();
        } while (opcionTareas != 4);
    }

    public static void convertirTemperatura() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la temperatura en Fahrenheit:");
        double fahrenheit = sc.nextDouble();
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        System.out.println(fahrenheit + "°F es igual a " + celsius + "°C");
    }

    public static void probarConexion() {
        Conexion conexion = new Conexion();
        conexion.conectar();
    }
}

class Tareas {
    private ArrayList<String> listaDeTareas;

    public Tareas() {
        this.listaDeTareas = new ArrayList<>();
    }

    public void verTareas() {
        System.out.println("Tus Tareas");
        if (listaDeTareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            for (int i = 0; i < listaDeTareas.size(); i++) {
                System.out.println((i + 1) + ". " + listaDeTareas.get(i));
            }
        }
    }

    public void agregarTarea(Scanner scanner) {
        System.out.print("Ingrese la nueva tarea: ");
        String nuevaTarea = scanner.nextLine();
        listaDeTareas.add(nuevaTarea);
        System.out.println("Tarea agregada: " + nuevaTarea);
    }

    public void eliminarTarea(Scanner scanner) {
        System.out.print("Ingrese el número de la tarea a eliminar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();
        if (indice >= 0 && indice < listaDeTareas.size()) {
            String tareaEliminada = listaDeTareas.remove(indice);
            System.out.println("Tarea eliminada: " + tareaEliminada);
        } else {
            System.out.println("Índice no válido.");
        }
    }
}