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

    public void darDeAltaLlamada(int telefono, int  duracion){
        LocalDateTime fecha = LocalDateTime.now();
        telefono = telefono;
        duracion = duracion;
        Llamada nuevaLlamada = new Llamada(telefono,fecha, duracion);
        llamadas.darDeAlta(,Llamada);


    }
    public Llamada pedirDatosLlamada(){
        System.out.println("Introduce");


        Llamada nuevaLlamada= new Llamada(telefono,fecha, duracion);
        return nuevaLlamada;
    }
}
