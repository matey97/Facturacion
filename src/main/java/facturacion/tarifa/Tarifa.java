package facturacion.tarifa;

import java.io.Serializable;

import facturacion.excepciones.PrecioTarifaNoValido;

/**
 * Created by al341802 on 21/02/17.
 */
public abstract class Tarifa implements Serializable{
    private int precioMinuto;

    public Tarifa(){
        this.precioMinuto=15;
    }

    public int getPrecioMinuto() {
        return precioMinuto;
    }

    public String toString(){
        return this.precioMinuto+"";

    }
}
