package vista;

import modelo.ModeloClienteParaVista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by al341802 on 2/05/17.
 */
public class VistaParticular implements VistaParaModeloCliente, VistaParaControladorParticular{

    private ModeloClienteParaVista modeloParticular;
    private JButton bAnyadir, bBorrar, bCambioTarifa, bDatosCliente, bListado, bListadoFechas;
    private JTextField jtfNIF, jtfNombre, jtfApellidos, jtfCodPos, jtfPobl, jtfProv, jtfEmail;

    public VistaParticular() {
        super();
    }

    public void setModeloParticular(ModeloClienteParaVista modeloParticular) {
        this.modeloParticular = modeloParticular;
    }

    public JPanel cargaInterfaz(){
        JPanel panelClientes=new JPanel();          //Subpanel de clientes
        panelClientes.setLayout(new BorderLayout());
        JPanel botonesClientes=new JPanel();        //Sub-Subpanel para botones
        bAnyadir=new JButton("Añadir cliente");
        bAnyadir.addActionListener(new EscuchadorBAnyadir());
        botonesClientes.add(bAnyadir);

        bBorrar=new JButton("Borrar cliente");
        bBorrar.addActionListener(new EscuchadorBBorrar());
        botonesClientes.add(bBorrar);

        bCambioTarifa=new JButton("Cambiar tarifa cliente");
        bCambioTarifa.addActionListener(new EscuchadorBCambioTarifa());
        botonesClientes.add(bCambioTarifa);

        bDatosCliente=new JButton("Datos cliente");
        bDatosCliente.addActionListener(new EscuchadorBDatosCliente());
        botonesClientes.add(bDatosCliente);

        bListado=new JButton("Listado clientes");
        bListado.addActionListener(new EscuchadorBListado());
        botonesClientes.add(bListado);

        bListadoFechas=new JButton("Listado clientes entre fechas");
        bListadoFechas.addActionListener(new EscuchadorBListadoFechas());
        botonesClientes.add(bListadoFechas);

        panelClientes.add(botonesClientes,BorderLayout.NORTH);  //añadimos botones al subpanes
        JPanel camposClientes=new JPanel();
        camposClientes.setLayout(new GridLayout(8,2));
        camposClientes.add(new JLabel("DNI:"),0);
        jtfNIF=new JTextField();
        camposClientes.add(jtfNIF,1);
        camposClientes.add(new JLabel("Nombre:"),2);
        jtfNombre=new JTextField();
        camposClientes.add(jtfNombre,3);
        camposClientes.add(new JLabel("Apellidos:"),4);
        jtfApellidos=new JTextField();
        camposClientes.add(jtfApellidos,5);
        camposClientes.add(new JLabel("Cod.Postal:"),6);
        jtfCodPos=new JTextField();
        camposClientes.add(jtfCodPos,7);
        camposClientes.add(new JLabel("Población:"),8);
        jtfPobl=new JTextField();
        camposClientes.add(jtfPobl,9);
        camposClientes.add(new JLabel("Provincia:"),10);
        jtfProv=new JTextField();
        camposClientes.add(jtfProv,11);
        camposClientes.add(new JLabel("E-mail:"),12);
        jtfEmail=new JTextField();
        camposClientes.add(jtfEmail,13);
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

    @Override
    public String getNIF() {
        return jtfNIF.getText();
    }

    @Override
    public String getNombre() {
        return jtfNombre.getText();
    }

    @Override
    public String getApellido() {
        return jtfApellidos.getText();
    }

    @Override
    public String getCodPos() {
        return jtfCodPos.getText();
    }

    @Override
    public String getPoblacion() {
        return jtfPobl.getText();
    }

    @Override
    public String getProv() {
        return jtfProv.getText();
    }

    @Override
    public String getEmail() {
        return jtfEmail.getText();
    }

    //Escuchadores
    private class EscuchadorBAnyadir implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class EscuchadorBBorrar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class EscuchadorBCambioTarifa implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class EscuchadorBDatosCliente implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class EscuchadorBListado implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class EscuchadorBListadoFechas implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
