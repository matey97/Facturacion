package facturacion.tarifa;

import facturacion.factura.Llamada;

/**
 * Created by sergiojimenez on 28/3/17.
 */
public class PromocionDomingos extends Promociones{
    private Tarifa tarifa;

    public PromocionDomingos(Tarifa tarifa){
        super(tarifa,0);
        this.tarifa=tarifa;
    }

    @Override
    public float costeLlamada(Llamada llamada) {
        float precio1=tarifa.costeLlamada(llamada);
        if (llamada.getFecha().getDayOfWeek().getValue() == 7)
            precio1=0;
        return precio1;
    }

    @Override
    public String toString(){
        return tarifa.toString()+", domingos gratis";
    }
}
