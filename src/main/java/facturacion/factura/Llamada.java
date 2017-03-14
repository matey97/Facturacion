package facturacion.factura;

import facturacion.Excepciones.DuracionNoValida;
import facturacion.Fecha;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 21/2/17.
 */
public class Llamada implements Fecha, Serializable{

    private int telefono;
    private LocalDateTime fecha;
    private int duracion;



    public Llamada(int telefono, LocalDateTime fecha, int duracion) throws DuracionNoValida {
        if(duracion <= 0){
            throw new DuracionNoValida("la duración de una llamada no puede ser negativa");
        }
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
