package facturacion.tarifa;

import facturacion.factura.Llamada;

/**
 * Created by sergiojimenez on 28/3/17.
 */
public class PromocionTardes extends Promociones {

    private Tarifa tarifa;

    public PromocionTardes(Tarifa tarifa, int precio){
        super(tarifa, precio);
        this.tarifa=tarifa;
    }

    @Override
    public float costeLlamada(Llamada llamada) {;
        float precio1= tarifa.costeLlamada(llamada);
        float precio2= llamada.getDuración() * super.getPrecioMinuto();
        if (llamada.getFecha().getHour()>16 && llamada.getFecha().getHour()<20)
            return precio2;
        return precio1;
    }

    @Override
    public String toString(){
        return tarifa.toString()+", tardes de 16:00 a 20:00 a "+super.toString(); //super.toString devuelve los cent/min de la tarifa reducida.
    }
}
