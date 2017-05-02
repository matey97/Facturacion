package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by al341802 on 2/05/17.
 */
public class InterfazGrafica {

    public InterfazGrafica() {
        super();
    }

    public void ejecuta(){
        JFrame ventana=new JFrame("Facturación");       //Ventana principal
        Container contenedor = ventana.getContentPane();

        JTabbedPane pestanyas=new JTabbedPane();        //Panel con pestañas
        JPanel panelClientes=new JPanel();          //Subpanel de clientes
        panelClientes.setLayout(new BorderLayout());
        JPanel botonesClientes=new JPanel();        //Sub-Subpanel para botones
        botonesClientes.add(new JButton("Añadir cliente"));
        botonesClientes.add(new JButton("Borrar cliente"));
        botonesClientes.add(new JButton("Cambiar tarifa cliente"));
        botonesClientes.add(new JButton("Datos cliente"));
        botonesClientes.add(new JButton("Listado clientes"));
        botonesClientes.add(new JButton("Listado clientes entre fechas"));
        panelClientes.add(botonesClientes,BorderLayout.NORTH);  //añadimos botones al subpanes
        JTextField nombre=new JTextField(10);
        panelClientes.add(nombre);
        pestanyas.add("Clientes",panelClientes);        //Añadimos subpanel al panel

        JPanel panelLlamadas=new JPanel();
        panelLlamadas.setLayout(new BorderLayout());
        JPanel botonesLlamadas=new JPanel();
        botonesLlamadas.add(new JButton("Dar de alta llamada"));
        botonesLlamadas.add(new JButton("Llamadas de cliente"));
        botonesLlamadas.add(new JButton("Llamadas de cliente entre fechas"));
        panelLlamadas.add(botonesLlamadas, BorderLayout.NORTH);
        pestanyas.add("Llamadas",panelLlamadas);

        JPanel panelFacturas=new JPanel();
        panelFacturas.setLayout(new BorderLayout());
        JPanel botonesFacturas=new JPanel();
        botonesFacturas.add(new JButton("Emitir factura"));
        botonesFacturas.add(new JButton("Datos de factura"));
        botonesFacturas.add(new JButton("Factura de cliente"));
        botonesFacturas.add(new JButton("Facturas de cliente entre fechas"));
        panelFacturas.add(botonesFacturas,BorderLayout.NORTH);
        pestanyas.add("Facturas",panelFacturas);


        JPanel panelBotones=new JPanel();
        JButton boton=new JButton("Cargar datos");
        panelBotones.add(boton);
        boton=new JButton("Guardar datos");
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
