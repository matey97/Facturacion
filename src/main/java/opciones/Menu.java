package opciones;

import java.util.Scanner;

/**
 * Created by al341802 on 21/02/17.
 */
public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que tipo de gestión quieres realizar?");
        System.out.println("");
        System.out.println("Introduce 1 para --> Gestión clientes");
        System.out.println("Introduce 2 para --> Gestión llamadas");
        System.out.println("Introduce 3 para --> Gestión facturas");
        int n = sc.nextInt();
        switch (n){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;


        }


    }
}
