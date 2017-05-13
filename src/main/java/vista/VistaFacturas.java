package vista;

import modelo.ModeloFacturaParaVista;
import modelo.colecciones.ColeccionFacturas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
        JTextArea areaTexto=new JTextArea(20,50);
        areaTexto.setEditable(false);
        JScrollPane scroll=new JScrollPane(areaTexto);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelFacturas.add(scroll,BorderLayout.SOUTH);
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

    public void cargaDatos(){
        try{
            FileInputStream fichFacturas = new FileInputStream("clientes.bin");
            ObjectInputStream objFacturas = new ObjectInputStream(fichFacturas);
            modeloFactura = (ColeccionFacturas) objFacturas.readObject();
            objFacturas.close();
        } catch(FileNotFoundException e){
            System.out.println("Error del fichero.");
            System.out.println(e);
        } catch(IOException e){
            System.out.println("Error en ObjectInputStream.");
            System.out.println(e);
        } catch(ClassNotFoundException e){
            System.out.println("Error al recuperar datos del fichero.");
            System.out.println(e);
        }
    }

    public void guardaDatos(){
        try {
            FileOutputStream fichClientes = new FileOutputStream("clientes.bin");
            ObjectOutputStream objFacturas = new ObjectOutputStream(fichClientes);
            objFacturas.writeObject(modeloFactura);
            objFacturas.close();
        }catch (FileNotFoundException e) {
            System.out.println("Error al intentar abrir el fichero.");
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Error en ObjectOutputStream");
            System.out.println(e);
        }
    }
}
