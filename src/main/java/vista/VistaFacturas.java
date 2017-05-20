package vista;

import controlador.ControladorParaModeloFacturas;
import modelo.ModeloFacturaParaVista;
import modelo.Utiles;
import modelo.colecciones.ColeccionFacturas;
import modelo.excepciones.FechaInicialMayorQueFinal;
import modelo.factura.Factura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by user on 28/04/17.
 */
public class VistaFacturas implements VistaParaModeloFactura, VistaParaControladorFacturas {

    private ModeloFacturaParaVista modeloFactura;
    private ControladorParaModeloFacturas controladorFactura;
    private JButton bEmitir, bDatos, bFacCliente, bFacClienteFechas;
    private JTextField jtfCodigo, jtfdni, diaIni, diaFin, mesIni, mesFin, anyoIni, anyoFin;
    private JTextArea areaTexto;

    public VistaFacturas() {
        super();
    }

    public void setModeloFactura(ModeloFacturaParaVista modeloFactura) {
        this.modeloFactura = modeloFactura;
    }

    public void setControladorFactura(ControladorParaModeloFacturas controladorFactura) { this.controladorFactura = controladorFactura; }

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
        areaTexto=new JTextArea(20,50);
        areaTexto.setEditable(false);
        JScrollPane scroll=new JScrollPane(areaTexto);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelFacturas.add(scroll,BorderLayout.SOUTH);
        return panelFacturas;
    }

    @Override
    public void nuevaFacturaCreada(int codigo) {
        areaTexto.append(modeloFactura.recuperarDatosFactura(codigo).toString());
        areaTexto.append("");
    }

    @Override
    public String getCodigo(){
        return jtfCodigo.getText();
    }

    @Override
    public String getDNI() {
        return jtfdni.getText();
    }

    @Override
    public String getDiaIni() {
        return diaIni.getText();
    }

    @Override
    public String getDiaFin() {
        return diaFin.getText();
    }

    @Override
    public String getMesIni() {
        return mesIni.getText();
    }

    @Override
    public String getMesFin() {
        return mesFin.getText();
    }

    @Override
    public String getAnyoIni() {
        return anyoIni.getText();
    }

    @Override
    public String getAnyoFin() {
        return anyoFin.getText();
    }


    //Escuchadores
    private class EscuchadorBAlta implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog dialogoDatos=new JDialog();
            dialogoDatos.setLocationRelativeTo(bEmitir);
            dialogoDatos.add(new JLabel("Introduce dos fechas y en NIF del cliente: "),BorderLayout.NORTH);
            JPanel panel=new JPanel();
            panel.setLayout(new BorderLayout());

            JPanel dni = new JPanel();
            dni.add(new JLabel("Introduce NIF: "));
            jtfdni = new JTextField(10);
            dni.add(jtfdni);

            JPanel fechaINI=new JPanel();
            fechaINI.add(new JLabel("Fecha inicial: "));
            fechaINI.add(new JLabel("Dia: "));
            diaIni=new JTextField(2);
            fechaINI.add(diaIni);
            fechaINI.add(new JLabel("Mes: "));
            mesIni=new JTextField(2);
            fechaINI.add(mesIni);
            fechaINI.add(new JLabel("Anyo: "));
            anyoIni=new JTextField(4);
            fechaINI.add(anyoIni);

            JPanel fechaFIN=new JPanel();
            fechaFIN.add(new JLabel("Fecha final: "));
            fechaFIN.add(new JLabel("Dia: "));
            diaFin=new JTextField(2);
            fechaFIN.add(diaFin);
            fechaFIN.add(new JLabel("Mes: "));
            mesFin=new JTextField(2);
            fechaFIN.add(mesFin);
            fechaFIN.add(new JLabel("Anyo: "));
            anyoFin=new JTextField(4);
            fechaFIN.add(anyoFin);
            panel.add(dni,BorderLayout.NORTH);
            panel.add(fechaINI);
            panel.add(fechaFIN, BorderLayout.SOUTH);
            JButton aceptar=new JButton("Aceptar");

            aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        controladorFactura.emitiendoFactura();
                    } catch (FechaInicialMayorQueFinal fechaInicialMayorQueFinal) {
                        fechaInicialMayorQueFinal.printStackTrace();
                    }

                    //controladorFactura.emitiendoFactura();
                    dialogoDatos.setVisible(false);
                }
            });
            dialogoDatos.add(panel);
            dialogoDatos.add(aceptar,BorderLayout.SOUTH);
            dialogoDatos.pack();
            dialogoDatos.setVisible(true);
        }
    }

    private class EscuchadorBDatos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog dialogoDatos = new JDialog();
            dialogoDatos.setLocationRelativeTo(bDatos);
            JPanel panel = new JPanel();
            panel.add(new JLabel("Introduce codigo de factura: "));
            jtfCodigo = new JTextField(10);
            panel.add(jtfCodigo);

            JButton aceptar=new JButton("Aceptar");
            aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    modeloFactura.recuperarDatosFactura(Integer.parseInt(jtfCodigo.getText()));
                    dialogoDatos.setVisible(false);
                }
            });
            panel.add(aceptar);
            dialogoDatos.add(panel);
            dialogoDatos.pack();
            dialogoDatos.setVisible(true);
        }
    }

    private class EscuchadorBFacCliente implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog dialogoDatos = new JDialog();
            dialogoDatos.setLocationRelativeTo(bFacCliente);
            JPanel panel = new JPanel();
            panel.add(new JLabel("Introduce NIF de cliente: "));
            jtfdni = new JTextField(10);
            panel.add(jtfdni);

            JButton aceptar=new JButton("Aceptar");
            aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    areaTexto.setText("");
                    for(Factura f: modeloFactura.recuperarFacturasCliente(jtfdni.getText())){
                        areaTexto.append(f.toString());
                        areaTexto.append("");
                    }
                    dialogoDatos.setVisible(false);
                }
            });
            panel.add(aceptar);
            dialogoDatos.add(panel);
            dialogoDatos.pack();
            dialogoDatos.setVisible(true);
        }
    }

    private class EscuchadorBFacClienteFechas implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog dialogoDatos=new JDialog();
            dialogoDatos.setLocationRelativeTo(bFacClienteFechas);
            dialogoDatos.add(new JLabel("Introduce dos fechas y en NIF del cliente: "),BorderLayout.NORTH);
            JPanel panel=new JPanel();
            panel.setLayout(new BorderLayout());

            JPanel dni = new JPanel();
            dni.add(new JLabel("Introduce NIF: "));
            JTextField jtfdni = new JTextField(10);
            dni.add(jtfdni);

            JPanel fechaINI=new JPanel();
            fechaINI.add(new JLabel("Fecha inicial: "));
            fechaINI.add(new JLabel("Dia: "));
            JTextField diaIni=new JTextField(2);
            fechaINI.add(diaIni);
            fechaINI.add(new JLabel("Mes: "));
            JTextField mesIni=new JTextField(2);
            fechaINI.add(mesIni);
            fechaINI.add(new JLabel("Anyo: "));
            JTextField anyoIni=new JTextField(4);
            fechaINI.add(anyoIni);

            JPanel fechaFIN=new JPanel();
            fechaFIN.add(new JLabel("Fecha final: "));
            fechaFIN.add(new JLabel("Dia: "));
            JTextField diaFin=new JTextField(2);
            fechaFIN.add(diaFin);
            fechaFIN.add(new JLabel("Mes: "));
            JTextField mesFin=new JTextField(2);
            fechaFIN.add(mesFin);
            fechaFIN.add(new JLabel("Anyo: "));
            JTextField anyoFin=new JTextField(4);
            fechaFIN.add(anyoFin);
            panel.add(dni,BorderLayout.NORTH);
            panel.add(fechaINI);
            panel.add(fechaFIN, BorderLayout.SOUTH);
            JButton aceptar=new JButton("Aceptar");

            aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    areaTexto.setText("");
                    int dni=Integer.parseInt(jtfdni.getText());
                    int anyoI=Integer.parseInt(anyoIni.getText());
                    int mesI=Integer.parseInt(mesIni.getText());
                    int diaI=Integer.parseInt(diaIni.getText());
                    int anyoF=Integer.parseInt(anyoFin.getText());
                    int mesF=Integer.parseInt(mesFin.getText());
                    int diaF=Integer.parseInt(diaFin.getText());

                    Collection<Factura> colF = Utiles.entreDosFechas(modeloFactura.recuperarFacturasCliente(jtfdni.getText()), LocalDateTime.of(anyoI, mesI, diaI, 0, 0), LocalDateTime.of(anyoF, mesF, diaF, 0, 0));
                    for (Factura c : colF) {
                        areaTexto.append(c.toString());
                        areaTexto.append("");
                    }
                    dialogoDatos.setVisible(false);
                }
            });
            dialogoDatos.add(panel);
            dialogoDatos.add(aceptar,BorderLayout.SOUTH);
            dialogoDatos.pack();
            dialogoDatos.setVisible(true);
        }
    }

    public void cargaDatos(){
        try{
            FileInputStream fichFacturas = new FileInputStream("facturas.bin");
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
            FileOutputStream fichFacturas = new FileOutputStream("facturas.bin");
            ObjectOutputStream objFacturas = new ObjectOutputStream(fichFacturas);
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
