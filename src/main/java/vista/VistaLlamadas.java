package vista;

import modelo.ModeloLlamadaParaVista;
import modelo.colecciones.ColeccionLlamadas;
import modelo.excepciones.ExcepcionClienteSinLlamadas;
import sun.util.calendar.JulianCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by user on 28/04/17.
 */
public class VistaLlamadas implements VistaParaModeloLlamada, VistaParaControladorLlamada {

    private ModeloLlamadaParaVista modeloLlamada;
    private JButton bAlta, bLlamadasCliente, bLlamadasFechas;
    private JTextField jtfNIF, jtfNIF2, jtfTelefono, jtfDuracion;

    public VistaLlamadas() {
        super();
    }

    public void setModeloLlamada(ModeloLlamadaParaVista modeloLlamada) {
        this.modeloLlamada = modeloLlamada;
    }

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
        JTextArea areaTexto=new JTextArea(20,50);
        areaTexto.setEditable(false);
        JScrollPane scroll=new JScrollPane(areaTexto);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelLlamadas.add(scroll,BorderLayout.SOUTH);
        panelLlamadas.add(camposLlamadas);

        return panelLlamadas;
    }



    @Override
    public void llamadaDadaDeAlta() throws ExcepcionClienteSinLlamadas {
        modeloLlamada.listarLlamadas("123");
    }

    public void obtenLlamadasCliente() throws ExcepcionClienteSinLlamadas {
        modeloLlamada.listarLlamadas("123");
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

        }
    }

    private class EscuchadorBLlamadasCliente implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog dialogoDatos=new JDialog();
            JPanel panelDialogo=new JPanel();
            panelDialogo.add(new JLabel("NIF del cliente:"));
            jtfNIF2=new JTextField(20);
            panelDialogo.add(jtfNIF2);
            JButton aceptar=new JButton("Aceptar");
            aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Llamada controlador
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
