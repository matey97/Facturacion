package modelo.factorias;

import modelo.tarifa.Tarifa;

/**
 * Created by al341802 on 4/04/17.
 */
public interface FactoriaTarifa {
    Tarifa getTarifaBasica();
    Tarifa getTarifaPromocion(Tarifa tarifa, TipoPromocion tipo);
}
