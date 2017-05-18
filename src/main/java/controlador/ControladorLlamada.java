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

    public void setVista(VistaLlamadas vista) {
        this.vista = vista;
    }

    public void setModelo(ColeccionLlamadas modelo) {
        this.modelo = modelo;
    }

    public void darDeAltaLlamada() throws DuracionNoValida, ExcepcionClienteSinLlamadas{
        String nif = vista.getNIF();
        int duracion = Integer.parseInt(vista.getDuracion());
        int telefono = Integer.parseInt(vista.getTelefono());

        if (duracion<=0)
            throw new DuracionNoValida("Duración de llamada no valida.");
        modelo.darDeAlta(nif, new Llamada(telefono,LocalDateTime.now(),duracion));
    }
}
