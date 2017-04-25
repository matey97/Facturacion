package vista;

import modelo.ModeloParaVista;
import modelo.colecciones.ColeccionClientes;
import modelo.colecciones.ColeccionFacturas;

/**
 * Created by al341802 on 25/04/17.
 */
public class VistaImplementacion implements VistaParaModelo, VistaParaControlador {

    private ColeccionClientes clientes;
    private ColeccionFacturas facturas;

    private ModeloParaVista modelo;

    public void setModelo(ModeloParaVista modelo){
        this.modelo=modelo;
    }

    @Override
    public void nuevoClienteAnyadido() {
        clientes.getListadoClientes();
    }

    @Override
    public void clienteBorrado() {
        clientes.getListadoClientes();
    }

    @Override
    public void nuevaFacturaCreada() {
        facturas.recuperarFacturasCliente("123");
    }

}
