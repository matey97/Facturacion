package vista;

import modelo.ModeloClienteParaVista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by al341802 on 2/05/17.
 */
public class VistaEmpresa implements VistaParaModeloCliente{

    private ModeloClienteParaVista modeloEmpresa;

    public VistaEmpresa() {
        super();
    }

    public void setModeloEmpresa(ModeloClienteParaVista modeloEmpresa) {
        this.modeloEmpresa = modeloEmpresa;
    }

    public JPanel cargaInterfaz(){
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
        JPanel camposClientes=new JPanel();
        camposClientes.setLayout(new GridLayout(8,2));
        camposClientes.add(new JLabel("DNI:"),0);
        camposClientes.add(new JTextField(),1);
        camposClientes.add(new JLabel("Nombre:"),2);
        camposClientes.add(new JTextField(),3);
        camposClientes.add(new JLabel("Cod.Postal:"),4);
        camposClientes.add(new JTextField(),5);
        camposClientes.add(new JLabel("Población:"),6);
        camposClientes.add(new JTextField(),7);
        camposClientes.add(new JLabel("Provincia:"),8);
        camposClientes.add(new JTextField(),9);
        camposClientes.add(new JLabel("E-mail:"),10);
        camposClientes.add(new JTextField(),11);
        panelClientes.add(new JTextArea(20,50),BorderLayout.SOUTH);
        panelClientes.add(camposClientes);
        return panelClientes;
    }

    @Override
    public void nuevoClienteAnyadido() {

    }

    @Override
    public void clienteBorrado() {

    }
}
