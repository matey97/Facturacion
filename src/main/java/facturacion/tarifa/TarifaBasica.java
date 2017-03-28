package facturacion.tarifa;

import facturacion.factura.Llamada;

/**
 * Created by al341802 on 28/03/17.
 */
public class TarifaBasica extends Tarifa {

    public TarifaBasica(){
        super();
    }

    public float costeLlamada(Llamada llamada){
        return llamada.getDuración()*getPrecioMinuto();
    }
}
