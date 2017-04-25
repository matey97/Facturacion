package vista;

import modelo.colecciones.ColeccionClientes;
import modelo.colecciones.ColeccionFacturas;

/**
 * Created by al341802 on 25/04/17.
 */
public class VistaImplementacion implements VistaParaModelo, VistaParaControlador {

    private ColeccionClientes clientes;
    private ColeccionFacturas facturas;

    @Override
    public void nuevoClienteAnyadido() {
        clientes.getListadoClientes();
    }

    @Override
    public void clienteBorrado() {
        clientes.getListadoClientes();
    }

    @Override
    public void datosCliente() {
        clientes.getDatosCliente("123");
    }

    @Override
    public void listadoClientes() {
        clientes.getListadoClientes();
    }

    @Override
    public void nuevaFacturaCreada() {
        facturas.recuperarFacturasCliente("123");
    }

}
