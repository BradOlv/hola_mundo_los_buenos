import java.util.Scanner;

public class numeroPrimo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¡Bienvenido!");
        System.out.println("Aquí podrás ver si un número es primo");
        System.out.println("Seleccione el numero 1 para iniciar el menú");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                verificarPrimo();
                break;
        }
        sc.close();
    }

    public static void verificarPrimo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa un número");
        int num = sc.nextInt();
        boolean esPrimo = true;

        if (num <= 1) {
            esPrimo = false;
        } else {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    esPrimo = false;
                    break;
                }
            }
        }

        if (esPrimo) {
            System.out.println("El num es primo");
        } else {
            System.out.println("El num no es primo");
        }
        sc.close();
    }
}