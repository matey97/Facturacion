package vista;

import modelo.excepciones.ExcepcionClienteSinLlamadas;

/**
 * Created by al341802 on 25/04/17.
 */
public interface VistaParaModelo {
    void nuevoClienteAnyadido();
    void clienteBorrado();

    void nuevaFacturaCreada();

    void llamadaDadaDeAlta() throws ExcepcionClienteSinLlamadas;
}
