package vista;

import modelo.ModeloClienteParaVista;

import modelo.ModeloFacturaParaVista;
import modelo.ModeloLlamadaParaVista;
import modelo.colecciones.ColeccionClientes;
import modelo.colecciones.ColeccionFacturas;
import modelo.colecciones.ColeccionLlamadas;
import modelo.excepciones.ExcepcionClienteSinLlamadas;

/**
 * Created by al341802 on 25/04/17.
 */
public class VistaImplementacion implements VistaParaModelo, VistaParaControlador {

    private ModeloClienteParaVista modeloCliente;
    private ModeloFacturaParaVista modeloFactura;
    private ModeloLlamadaParaVista modeloLlamada;

    public void setModeloCliente(ModeloClienteParaVista modelo){
        this.modeloCliente=modelo;
    }

    public void setModeloFactura(ModeloFacturaParaVista modelo){
        this.modeloFactura=modelo;
    }

    public void setModeloLlamada(ModeloLlamadaParaVista modelo){
        this.modeloLlamada=modelo;
    }

    @Override
    public void nuevoClienteAnyadido() {
        modeloCliente.getListadoClientes();
    }

    @Override
    public void clienteBorrado() {
        modeloCliente.getListadoClientes();
    }

    @Override
    public void nuevaFacturaCreada() {
        modeloFactura.recuperarFacturasCliente("123");
    }

    @Override
    public void llamadaDadaDeAlta() throws ExcepcionClienteSinLlamadas {
        modeloLlamada.listarLlamadas("123");
    }

    public void obtenDatosCliente(){
        modeloCliente.getDatosCliente("123");
    }

    public void obtenListadoClientes(){
        modeloCliente.getListadoClientes();
    }

    public void obtenDatosDeFactura(){
        modeloFactura.recuperarDatosFactura(123);
    }

    public void obtenFacturasCliente(){
        modeloFactura.recuperarFacturasCliente("123");
    }

    public void obtenLlamadasCliente() throws ExcepcionClienteSinLlamadas {
        modeloLlamada.listarLlamadas("123");
    }
}
