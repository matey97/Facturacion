package vista;

import modelo.ModeloFacturaParaVista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 28/04/17.
 */
public class VistaFacturas implements VistaParaModeloFactura {

    private ModeloFacturaParaVista modeloFactura;

    public VistaFacturas() {
        super();
    }

    public void setModeloFactura(ModeloFacturaParaVista modeloFactura) {
        this.modeloFactura = modeloFactura;
    }

    public JPanel cargaInterfaz(){
        JPanel panelFacturas=new JPanel();
        panelFacturas.setLayout(new BorderLayout());
        JPanel botonesFacturas=new JPanel();
        botonesFacturas.add(new JButton("Emitir factura"));
        botonesFacturas.add(new JButton("Datos de factura"));
        botonesFacturas.add(new JButton("Factura de cliente"));
        botonesFacturas.add(new JButton("Facturas de cliente entre fechas"));
        panelFacturas.add(botonesFacturas,BorderLayout.NORTH);
        panelFacturas.add(new JTextArea(30,50));
        return panelFacturas;
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
