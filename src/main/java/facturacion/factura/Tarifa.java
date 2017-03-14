package facturacion.factura;

import java.io.Serializable;

/**
 * Created by al341802 on 21/02/17.
 */
public class Tarifa implements Serializable{
    private int precioMinuto;

    public Tarifa(int precioMinuto) {
        this.precioMinuto = precioMinuto;
    }

    public int getPrecioMinuto() {
        return precioMinuto;
    }

    public void setPrecioMinuto(int precioMinuto) {
        this.precioMinuto = precioMinuto;
    }


    public String toString(){
        return this.precioMinuto+"";

    }
}
