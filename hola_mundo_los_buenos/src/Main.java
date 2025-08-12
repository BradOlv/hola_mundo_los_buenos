import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido!");
        System.out.println(" aquí podrás ver si un numero es par o impar");
        System.out.println("Seleccione el numero 1 para iniciar el menú");
        int opcion = sc.nextInt();

        switch (opcion){
            case 1:
                numeroPar();
            break;
             }
        }
        public static void numeroPar(){
            Scanner sc = new Scanner(System.in);
            System.out.println("ingrese un numero");
            int num1 = sc.nextInt();
            if (num1 % 2 == 0){
                System.out.println("el numero es par");
            }else {
                System.out.println("el numero es impar");
            }

        }

}
