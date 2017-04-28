package vista;

import modelo.excepciones.ExcepcionClienteSinLlamadas;

/**
 * Created by user on 28/04/17.
 */
public interface VistaParaModeloLlamada {
    void llamadaDadaDeAlta() throws ExcepcionClienteSinLlamadas;
}
