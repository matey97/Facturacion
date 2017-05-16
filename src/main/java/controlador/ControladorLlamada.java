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
public class ControladorLlamada implements ControladorParaModeloLlamada {
    private VistaLlamadas vista;
    private ColeccionLlamadas modelo;


    public void darDeAltaLlamada() throws DuracionNoValida, ExcepcionClienteSinLlamadas {
        String nif = vista.getNIF();
        int duracion = Integer.parseInt(vista.getDuracion());
        int telefono = Integer.parseInt(vista.getTelefono());

        try {

          modelo.darDeAlta(nif, new Llamada(telefono,LocalDateTime.now(),duracion));
        }
        catch( DuracionNoValida  | ExcepcionClienteSinLlamadas sin){
           // que hacer con los errores?? vista.lanzaError(ex);
        }

    }

}
