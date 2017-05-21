package controlador;

import modelo.excepciones.ExcepcionClienteSinLlamadas;

import java.util.Collection;

/**
 * Created by sergiojimenez on 20/5/17.
 */
public interface ModeloLlamadasParaControladorFactura {
    Collection listarLlamadas(String nif) throws ExcepcionClienteSinLlamadas;
}
