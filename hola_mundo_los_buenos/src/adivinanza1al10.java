import java.util.Random;
import java.util.Scanner;

public class adivinanza1al10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¡Bienvenido al juego de adivinanzas!");
        System.out.println("Aquí podrás adivinar un número del 1 al 10.");
        System.out.println("Selecciona el numero 1 para jugar");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                jugarAdivinanza();
                break;
            default:
        }
        sc.close();
    }

    public static void jugarAdivinanza() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int numeroAleatorio = random.nextInt(10) + 1;
        int intento;
        boolean adivinado = false;

        System.out.println("He metido un número entre 1 y 10. Intente adivinarlo");

        while (!adivinado) {
            System.out.print("Ingresa tu intento: ");
            intento = sc.nextInt();

            if (intento == numeroAleatorio) {
                System.out.println("numero adivinado");
                adivinado = true;
            } else if (intento < numeroAleatorio) {
                System.out.println("no es el número");
            } else {
                System.out.println("no es el número");
            }
        }
        sc.close();
    }
}