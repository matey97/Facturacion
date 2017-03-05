package facturacion.factura;

import facturacion.Fecha;

import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 21/2/17.
 */
public class Llamada implements Fecha{

    private int telefono;
    private LocalDateTime fecha;
    private int duracion;



    public Llamada(int telefono, LocalDateTime fecha, int duracion) {
        this.telefono = telefono;
        this.fecha = fecha;
        this.duracion=duracion;

    }

    public int getTelefono() {
        return telefono;
    }

    @Override
    public LocalDateTime getFecha() {

        return fecha;
    }

    public int getDuración() {
        return duracion;
    }

    @Override
    public String toString(){
        return("Llamada realizada al telefono: "+this.telefono+" con duración: "+ this.duracion+" a fecha de: "+this.fecha);
    }

}
