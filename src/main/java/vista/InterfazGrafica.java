package vista;

import com.sun.jmx.remote.security.JMXPluggableAuthenticator;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by al341802 on 2/05/17.
 */
public class InterfazGrafica {

    private VistaClientes vistaClientes;
    private VistaLlamadas vistaLlamadas;
    private VistaFacturas vistaFacturas;

    public InterfazGrafica() {
        super();
    }

    public void setVistaClientes(VistaClientes v){
        this.vistaClientes=v;
    }

    public void setVistaLlamadas(VistaLlamadas vistaLlamadas) {
        this.vistaLlamadas = vistaLlamadas;
    }

    public void setVistaFacturas(VistaFacturas vistaFacturas) {
        this.vistaFacturas = vistaFacturas;
    }

    public void ejecuta(){
        JFrame ventana=new JFrame("Facturación");
        Container contenedor = ventana.getContentPane();

        JTabbedPane pestanyas=new JTabbedPane();
        pestanyas.add("Clientes",vistaClientes.cargaInterfaz());
        pestanyas.add("Llamadas",vistaLlamadas.cargaInterfaz());
        pestanyas.add("Facturas",vistaFacturas.cargaInterfaz());

        JPanel panelBotones=new JPanel();
        JButton boton=new JButton("Cargar datos");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaClientes.cargaDatos();
                vistaLlamadas.cargaDatos();
                vistaFacturas.cargaDatos();
            }
        });
        panelBotones.add(boton);
        boton=new JButton("Guardar datos");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaClientes.guardaDatos();
                vistaLlamadas.guardaDatos();
                vistaFacturas.guardaDatos();
            }
        });
        panelBotones.add(boton);
        boton=new JButton("Salir");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelBotones.add(boton);

        contenedor.add(pestanyas,BorderLayout.CENTER);
        contenedor.add(panelBotones,BorderLayout.SOUTH);
        ventana.pack();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);




    }
}
