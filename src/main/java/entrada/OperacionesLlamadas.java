package entrada;

import facturacion.colecciones.ColeccionLlamadas;
import facturacion.factura.Llamada;
import java.util.Scanner;

import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 28/2/17.
 */
public class OperacionesLlamadas {
    private int telefono;
    private LocalDateTime fecha;
    private int duracion;
    private ColeccionLlamadas llamadas=new ColeccionLlamadas();

    public OperacionesLlamadas(int telefono, LocalDateTime fecha, int duracion) {
        this.telefono = telefono;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public void darDeAltaLlamada(Llamada llamada){
        Scanner sc = new Scanner(System.in)
        System.out.println("introduce NIF del cliente:  ");
        String nif = sc.toString();
        llamadas.darDeAlta(nif,llamada);


    }
    public Llamada pedirDatosLlamada(){
        Scanner sc = new Scanner(System.in)
        System.out.println("Introduce el telefono : ");
        int telefono = sc.nextInt();
        System.out.println("Introduce la duración: ");
        int duracion = sc.nextInt();
        LocalDateTime fecha = LocalDateTime.now();

        Llamada nuevaLlamada= new Llamada(telefono,fecha, duracion);
        darDeAltaLlamada(nuevaLlamada);
        return nuevaLlamada;
    }
}
