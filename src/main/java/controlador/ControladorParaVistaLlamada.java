package controlador;

import modelo.colecciones.ColeccionLlamadas;
import modelo.excepciones.DuracionNoValida;
import modelo.excepciones.ExcepcionClienteSinLlamadas;
import modelo.factura.Llamada;

/**
 * Created by sergiojimenez on 15/5/17.
 */
public interface ControladorParaVistaLlamada {

    public void darDeAltaLlamada() throws DuracionNoValida, ExcepcionClienteSinLlamadas;
}


