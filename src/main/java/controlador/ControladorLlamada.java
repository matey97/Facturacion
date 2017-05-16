package controlador;

import modelo.colecciones.ColeccionLlamadas;
import modelo.excepciones.DuracionNoValida;
import modelo.excepciones.ExcepcionClienteSinLlamadas;
import modelo.factura.Llamada;
import vista.VistaLlamadas;

import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 15/5/17.
 */
public class ControladorLlamada implements ControladorParaModeloLlamada, ControladorParaModeloFacturas {
    private VistaLlamadas vista;
    private ColeccionLlamadas modelo;


    public void darDeAltaLlamada() {
        String nif = vista.getNIF();
        int duracion = Integer.parseInt(vista.getDuracion());
        int telefono = Integer.parseInt(vista.getTelefono());

        try {

          modelo.darDeAlta(nif, new Llamada(telefono,LocalDateTime.now(),duracion));
        }
        catch( DuracionNoValida ex, ExcepcionClienteSinLlamadas sin){
           /// vista.lanzaError(ex);
        }


    }

    @Override
    public void darDeAlta(String nif, Llamada llamada) throws ExcepcionClienteSinLlamadas {

    }
}
