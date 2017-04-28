package modelo;

import modelo.excepciones.ExcepcionClienteSinLlamadas;
import modelo.factura.Llamada;

import java.util.Collection;

/**
 * Created by al341802 on 25/04/17.
 */
public interface ModeloLlamadaParaVista {
    Collection<Llamada> listarLlamadas(String nif)throws ExcepcionClienteSinLlamadas;
}
