package vista;

import controlador.ControladorParaModeloLlamada;
import modelo.ModeloLlamadaParaVista;
import modelo.Utiles;
import modelo.colecciones.ColeccionLlamadas;
import modelo.excepciones.DuracionNoValida;
import modelo.excepciones.ExcepcionClienteSinLlamadas;
import modelo.factura.Llamada;
import sun.util.calendar.JulianCalendar;

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
public class VistaLlamadas implements VistaParaModeloLlamada, VistaParaControladorLlamada {

    private ModeloLlamadaParaVista modeloLlamada;
    private ControladorParaModeloLlamada controladorLlamada;
    private JButton bAlta, bLlamadasCliente, bLlamadasFechas;
    private JTextField jtfNIF, jtfNIF2, jtfTelefono, jtfDuracion;
    private JTextArea areaTexto;

    public VistaLlamadas() {
        super();
    }

    public void setModeloLlamada(ModeloLlamadaParaVista modeloLlamada) {
        this.modeloLlamada = modeloLlamada;
    }

    public void setControladorLlamada(ControladorParaModeloLlamada controladorLlamada){ this.controladorLlamada = controladorLlamada;}

    public JPanel cargaInterfaz(){
        JPanel panelLlamadas=new JPanel();
        panelLlamadas.setLayout(new BorderLayout());
        JPanel botonesLlamadas=new JPanel();
        bAlta=new JButton("Dar de alta llamada");
        bAlta.addActionListener(new EscuchadorBAlta());
        botonesLlamadas.add(bAlta);

        bLlamadasCliente=new JButton("Llamadas de cliente");
        bLlamadasCliente.addActionListener(new EscuchadorBLlamadasCliente());
        botonesLlamadas.add(bLlamadasCliente);

        bLlamadasFechas=new JButton("Llamadas de cliente entre fechas");
        bLlamadasFechas.addActionListener(new EscuchadorBLlamadasFechas());
        botonesLlamadas.add(bLlamadasFechas);

        panelLlamadas.add(botonesLlamadas, BorderLayout.NORTH);
        JPanel camposLlamadas=new JPanel();
        camposLlamadas.add(new JLabel("NIF:"));
        jtfNIF=new JTextField(15);
        camposLlamadas.add(jtfNIF);
        camposLlamadas.add(new JLabel("Telefono:"));
        jtfTelefono=new JTextField(15);
        camposLlamadas.add(jtfTelefono);
        camposLlamadas.add(new JLabel("Duración:"));
        jtfDuracion=new JTextField(15);
        camposLlamadas.add(jtfDuracion);
        areaTexto=new JTextArea(20,50);
        areaTexto.setEditable(false);
        JScrollPane scroll=new JScrollPane(areaTexto);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelLlamadas.add(scroll,BorderLayout.SOUTH);
        panelLlamadas.add(camposLlamadas);

        return panelLlamadas;
    }



    @Override
    public void llamadaDadaDeAlta() {
        System.out.println("Llegó");
        try{
            areaTexto.setText("");
            for(Llamada l : modeloLlamada.listarLlamadas(jtfNIF.getText())) {
                areaTexto.append(l.toString());
                areaTexto.append("\n");
                areaTexto.append("\n");
            }
        }catch(ExcepcionClienteSinLlamadas e){
            e.getMessage();
        }
        jtfTelefono.setText("");
        jtfDuracion.setText("");
    }

    @Override
    public String getNIF() {
        return jtfNIF.getText();
    }

    @Override
    public String getTelefono() {
        return jtfTelefono.getText();
    }

    @Override
    public String getDuracion() {
        return jtfDuracion.getText();
    }

    //Escuchadores
    private class EscuchadorBAlta implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                controladorLlamada.darDeAltaLlamada();
            }catch(DuracionNoValida d){
                areaTexto.append(d.getMessage());
            }catch(ExcepcionClienteSinLlamadas c){
                areaTexto.append(c.getMessage());
            }
        }
    }

    private class EscuchadorBLlamadasCliente implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog dialogoDatos=new JDialog();
            dialogoDatos.setLocationRelativeTo(bLlamadasCliente);
            JPanel panelDialogo=new JPanel();
            panelDialogo.add(new JLabel("NIF del cliente:"));
            jtfNIF2=new JTextField(20);
            panelDialogo.add(jtfNIF2);
            JButton aceptar=new JButton("Aceptar");
            aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        areaTexto.setText("");
                        for(Llamada l : modeloLlamada.listarLlamadas(jtfNIF2.getText())){
                            areaTexto.append(l.toString());
                            areaTexto.append("\n");
                            areaTexto.append("\n");
                        }
                    }catch (ExcepcionClienteSinLlamadas ex){
                        areaTexto.append(ex.getMessage());
                    }
                    dialogoDatos.setVisible(false);
                }
            });
            dialogoDatos.add(panelDialogo);
            dialogoDatos.add(aceptar,BorderLayout.SOUTH);
            dialogoDatos.pack();
            dialogoDatos.setVisible(true);
        }
    }

    private class EscuchadorBLlamadasFechas implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog dialogoDatos=new JDialog();
            dialogoDatos.setLocationRelativeTo(bLlamadasFechas);
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
                    try {
                        Collection<Llamada> colL = Utiles.entreDosFechas(modeloLlamada.listarLlamadas(jtfdni.getText()), LocalDateTime.of(anyoI, mesI, diaI, 0, 0), LocalDateTime.of(anyoF, mesF, diaF, 0, 0));
                        for (Llamada c : colL) {
                            areaTexto.append(c.toString());
                            areaTexto.append("");
                        }
                    }catch (ExcepcionClienteSinLlamadas exc){
                        System.out.println(exc.getMessage());
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
            FileInputStream fichLlamadas = new FileInputStream("llamadas.bin");
            ObjectInputStream objLlamadas = new ObjectInputStream(fichLlamadas);
            modeloLlamada = (ColeccionLlamadas) objLlamadas.readObject();
            objLlamadas.close();
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
            FileOutputStream fichLlamadas = new FileOutputStream("clientes.bin");
            ObjectOutputStream objLlamadas = new ObjectOutputStream(fichLlamadas);
            objLlamadas.writeObject(modeloLlamada);
            objLlamadas.close();
        }catch (FileNotFoundException e) {
            System.out.println("Error al intentar abrir el fichero.");
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Error en ObjectOutputStream");
            System.out.println(e);
        }
    }
}
