package modelo;


import modelo.excepciones.ExcepcionClienteSinLlamadas;
import modelo.factura.Llamada;

import java.util.Collection;

/**
 * Created by sergiojimenez on 16/5/17.
 */
public interface ModeloParaControladorLlamada {
    void darDeAlta(String nif, Llamada llamada) throws ExcepcionClienteSinLlamadas;
    Collection listarLlamadas(String nif)throws ExcepcionClienteSinLlamadas;

}
