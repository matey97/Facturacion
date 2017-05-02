package vista;

import modelo.ModeloFacturaParaVista;

/**
 * Created by user on 28/04/17.
 */
public class VistaFacturas implements VistaParaModeloFactura {

    private ModeloFacturaParaVista modeloFactura;

    public void setModeloFactura(ModeloFacturaParaVista modeloFactura) {
        this.modeloFactura = modeloFactura;
    }

    @Override
    public void nuevaFacturaCreada() {
        modeloFactura.recuperarDatosFactura(123);
    }

    public void obtenDatosDeFactura(){
        modeloFactura.recuperarDatosFactura(123);
    }

    public void obtenFacturasCliente(){
        modeloFactura.recuperarFacturasCliente("123");
    }
}
