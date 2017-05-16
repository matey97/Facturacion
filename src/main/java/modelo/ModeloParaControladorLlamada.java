package modelo;


import modelo.excepciones.ExcepcionClienteSinLlamadas;
import modelo.factura.Llamada;

/**
 * Created by sergiojimenez on 16/5/17.
 */
public interface ModeloParaControladorLlamada {
    public void darDeAlta(String nif, Llamada llamada) throws ExcepcionClienteSinLlamadas;

}
