package facturacion.tarifa;

import java.io.Serializable;

import facturacion.factura.Llamada;

/**
 * Created by al341802 on 21/02/17.
 */
public abstract class Tarifa implements Serializable{
    private int precioMinuto;

    public Tarifa(){
        this.precioMinuto=15;
    }

    public Tarifa(int precioMinuto){
        this.precioMinuto=precioMinuto;
    }

    public int getPrecioMinuto() {
        return precioMinuto;
    }

    public abstract float costeLlamada(Llamada llamada);


    public String toString(){
        return this.precioMinuto+" cent/min";

    }
}
