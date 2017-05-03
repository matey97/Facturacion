package vista;

import modelo.ModeloLlamadaParaVista;
import modelo.excepciones.ExcepcionClienteSinLlamadas;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 28/04/17.
 */
public class VistaLlamadas implements VistaParaModeloLlamada {

    private ModeloLlamadaParaVista modeloLlamada;

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
        botonesLlamadas.add(new JButton("Dar de alta llamada"));
        botonesLlamadas.add(new JButton("Llamadas de cliente"));
        botonesLlamadas.add(new JButton("Llamadas de cliente entre fechas"));
        panelLlamadas.add(botonesLlamadas, BorderLayout.NORTH);
        JPanel camposLlamadas=new JPanel();
        camposLlamadas.add(new JLabel("NIF:"));
        camposLlamadas.add(new JTextField(15));
        camposLlamadas.add(new JLabel("Telefono:"));
        camposLlamadas.add(new JTextField(15));
        camposLlamadas.add(new JLabel("Duración:"));
        camposLlamadas.add(new JTextField(15));

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
}
