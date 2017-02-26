package facturacion.factura;

/**
 * Created by al341802 on 21/02/17.
 */
public class Tarifa {
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
}
