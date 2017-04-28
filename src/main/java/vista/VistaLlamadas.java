package vista;

import modelo.ModeloLlamadaParaVista;
import modelo.excepciones.ExcepcionClienteSinLlamadas;

/**
 * Created by user on 28/04/17.
 */
public class VistaLlamadas implements VistaParaModeloLlamada {

    private ModeloLlamadaParaVista modeloLlamada;

    public void setModeloLlamada(ModeloLlamadaParaVista modeloLlamada) {
        this.modeloLlamada = modeloLlamada;
    }

    @Override
    public void llamadaDadaDeAlta() throws ExcepcionClienteSinLlamadas {
        modeloLlamada.listarLlamadas("123");
    }

    public void obtenLlamadasCliente() throws ExcepcionClienteSinLlamadas {
        modeloLlamada.listarLlamadas("123");
    }
}
