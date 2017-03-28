package facturacion.tarifa;

import facturacion.factura.Llamada;

/**
 * Created by sergiojimenez on 28/3/17.
 */
public abstract class Promociones extends Tarifa {

    private Tarifa tarifa;

    public Promociones(Tarifa tarifa, int precio){
        super(precio);
        this.tarifa=tarifa;
    }

}
