package controlador;

import modelo.excepciones.FechaInicialMayorQueFinal;

/**
 * Created by sergiojimenez on 25/4/17.
 */
public interface ControladorParaModeloFacturas {
    void emitiendoFactura() throws FechaInicialMayorQueFinal;
}
