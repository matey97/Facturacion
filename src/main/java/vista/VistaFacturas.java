package vista;

import modelo.ModeloFacturaParaVista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 28/04/17.
 */
public class VistaFacturas implements VistaParaModeloFactura {

    private ModeloFacturaParaVista modeloFactura;
    private JButton bEmitir, bDatos, bFacCliente, bFacClienteFechas;

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

        bEmitir=new JButton("Emitir factura");
        bEmitir.addActionListener(new EscuchadorBAlta());
        botonesFacturas.add(bEmitir);

        bDatos=new JButton("Datos de factura");
        bDatos.addActionListener(new EscuchadorBDatos());
        botonesFacturas.add(bDatos);

        bFacCliente=new JButton("Factura de cliente");
        bFacCliente.addActionListener(new EscuchadorBFacCliente());
        botonesFacturas.add(bFacCliente);

        bFacClienteFechas=new JButton("Facturas de cliente entre fechas");
        bFacClienteFechas.addActionListener(new EscuchadorBFacClienteFechas());
        botonesFacturas.add(bFacClienteFechas);
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


    //Escuchadores
    private class EscuchadorBAlta implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class EscuchadorBDatos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class EscuchadorBFacCliente implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class EscuchadorBFacClienteFechas implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
