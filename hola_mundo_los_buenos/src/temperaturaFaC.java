import java.util.Scanner;

public class temperaturaFaC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido!");
        System.out.println("Aquí podrás convertir de Fahrenheit a Celsius.");
        System.out.println("Seleccione el numero 1 para iniciar el menú");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                convertirTemperatura();
                break;
        }
        sc.close();
    }

    public static void convertirTemperatura() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la temperatura en Fahrenheit:");
        double fahrenheit = sc.nextDouble();


        double celsius = (fahrenheit - 32) * 5.0 / 9.0;

        System.out.println(fahrenheit + "°F es igual a " + celsius + "°C");
        sc.close();
    }
}










