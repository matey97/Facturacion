package entrada;

import facturacion.colecciones.ColeccionLlamadas;
import facturacion.factura.Llamada;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 28/2/17.
 */
public class OperacionesLlamadas {
    private int telefono;
    private LocalDateTime fecha;
    private int duracion;
    private ColeccionLlamadas llamadas;



    public void darDeAltaLlamada(Llamada llamada){
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce NIF del cliente:  ");
        String nif = sc.next();
        llamadas.darDeAlta(nif,llamada);


    }
    public void pedirDatosLlamada(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el telefono: ");
        int telefono = sc.nextInt();
        System.out.println("Introduce la duración: ");
        int duracion = sc.nextInt();
        LocalDateTime fecha = LocalDateTime.now();

        Llamada nuevaLlamada= new Llamada(telefono,fecha, duracion);
        darDeAltaLlamada(nuevaLlamada);

    }
    public void listadoLlamadascliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el NIF del cliente:  ");
        String nif = sc.next();
        llamadas =new ColeccionLlamadas();
        ListIterator lista= llamadas.listarLlamadas(nif).listIterator();
        while (lista.hasNext()){
            System.out.println(lista.next().toString());
        }



    }

}
