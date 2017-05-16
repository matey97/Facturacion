package controlador;

import modelo.colecciones.ColeccionLlamadas;
import modelo.excepciones.DuracionNoValida;
import modelo.factura.Llamada;
import vista.VistaLlamadas;

import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 15/5/17.
 */
public class ControladorLlamada implements ControladorParaModeloLlamada, ControladorParaModeloFacturas {
    private ControladorParaModeloLlamada modelo;
    private VistaLlamadas vista;
    private ColeccionLlamadas llamadas;


    public void darDeAltaLlamada() {
        String nif = vista.getNIF();
        int duracion = Integer.parseInt(vista.getDuracion());
        int telefono = Integer.parseInt(vista.getTelefono());
        /*try {
            modelo.(nif, new Llamada(telefono, LocalDateTime.now(), duracion));
        }
        catch( DuracionNoValida ex){
           /// vista.lanzaError(ex);
        }
*/


    }

}
