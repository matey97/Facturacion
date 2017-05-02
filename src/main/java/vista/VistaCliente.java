package vista;

import controlador.ControladorParaVista;
import modelo.ModeloClienteParaVista;

/**
 * Created by user on 28/04/17.
 */
public abstract class VistaCliente implements VistaParaModeloCliente {

    private ModeloClienteParaVista modeloCliente;


    public VistaCliente() {
        super();
    }

    public void setModeloCliente(ModeloClienteParaVista modeloCliente) {
        this.modeloCliente = modeloCliente;
    }

    @Override
    public void nuevoClienteAnyadido() {
        modeloCliente.getListadoClientes();
    }

    @Override
    public void clienteBorrado() {
        modeloCliente.getListadoClientes();
    }

    public void obtenDatosCliente(){
        modeloCliente.getDatosCliente("123");
    }

    public void obtenListadoClientes(){
        modeloCliente.getListadoClientes();
    }

}
