package menu;

import enums.*;

import java.util.Scanner;

/**
 * Created by sergiojimenez on 4/4/17.
 */
public class Main {
    private Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
       // new Main().arranque();
        GestionDatos Datos = new GestionDatos();
        Datos.cargarDatos();
        MenuEnum menu = new MenuEnum();
        menu.arranque();



    }

   }