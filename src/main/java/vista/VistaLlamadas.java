package vista;

import modelo.ModeloLlamadaParaVista;
import modelo.excepciones.ExcepcionClienteSinLlamadas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 28/04/17.
 */
public class VistaLlamadas implements VistaParaModeloLlamada, VistaParaControladorLlamada {

    private ModeloLlamadaParaVista modeloLlamada;
    private JButton bAlta, bLlamadasCliente, bLlamadasFechas;
    private JTextField jtfNIF, jtfTelefono, jtfDuracion;

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

        panelLlamadas.add(camposLlamadas);
        panelLlamadas.add(new JTextArea(25,50),BorderLayout.SOUTH);
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

        }
    }

    private class EscuchadorBLlamadasFechas implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
