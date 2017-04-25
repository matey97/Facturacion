package modelo.factorias;

import modelo.tarifa.*;

/**
 * Created by al341802 on 4/04/17.
 */
public class FactoriaTarifas implements FactoriaTarifa {

    public FactoriaTarifas(){
        super();
    }

    @Override
    public Tarifa getTarifaBasica() {
        return new TarifaBasica();
    }

    @Override
    public Tarifa getTarifaPromocion(Tarifa tarifa, TipoPromocion tipo) {
        Tarifa dev = new PromocionTardes(tarifa,5);
        switch(tipo){
           case DOMINGOS:
               dev = new PromocionDomingos(tarifa);
       }
       return dev;
    }
}
