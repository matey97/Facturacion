package controlador;

import modelo.ModeloParaControladorLlamada;
import modelo.excepciones.DuracionNoValida;
import modelo.excepciones.ExcepcionClienteSinLlamadas;
import modelo.factura.Llamada;
import vista.VistaParaControladorLlamada;

import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 15/5/17.
 */
public class ControladorLlamada implements ControladorParaVistaLlamada {
    private VistaParaControladorLlamada vista;
    private ModeloParaControladorLlamada modelo;

    public void setVista(VistaParaControladorLlamada vista) {
        this.vista = vista;
    }

    public void setModelo(ModeloParaControladorLlamada modelo) {
        this.modelo = modelo;
    }

    @Override
    public void darDeAltaLlamada() throws DuracionNoValida, ExcepcionClienteSinLlamadas{
        String nif = vista.getNIF();
        int duracion = Integer.parseInt(vista.getDuracion());
        int telefono = Integer.parseInt(vista.getTelefono());

        if (duracion<=0)
            throw new DuracionNoValida("Duración de llamada no valida.");
        modelo.darDeAlta(nif, new Llamada(telefono,LocalDateTime.now(),duracion));


    }
}
