package facturacion.factura;

import java.io.Serializable;

import facturacion.Excepciones.PrecioTarifaNoValido;

/**
 * Created by al341802 on 21/02/17.
 */
public class Tarifa implements Serializable{
    private int precioMinuto;

    public Tarifa(int precioMinuto) throws PrecioTarifaNoValido{
        if(precioMinuto<0 || precioMinuto>15 ){
            throw new PrecioTarifaNoValido("El precio indicado no se encuentra disponible en nuestras tarifas,\n Recuerde de 0 a 15 ");
        }

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
