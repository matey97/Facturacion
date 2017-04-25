package vista;

import modelo.colecciones.ColeccionClientes;
import modelo.colecciones.ColeccionFacturas;

/**
 * Created by al341802 on 25/04/17.
 */
public class VistaImplementacion implements VistaParaModelo, VistaParaControlador {

    private ColeccionClientes clientes;
    private ColeccionFacturas facturas;

    public void nuevoClienteAnyadido() {
        clientes.getListadoClientes();
    }

    public void nuevaFacturaCreada() {
        facturas.recuperarFacturasCliente("123");
    }
}
