package vista;

import modelo.ModeloClienteParaVista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by al341802 on 2/05/17.
 */
public class VistaEmpresa implements VistaParaModeloCliente, VistaParaControladorEmpresa{

    private ModeloClienteParaVista modeloEmpresa;
    private JButton bAnyadir, bBorrar, bCambioTarifa, bDatosCliente, bListado, bListadoFechas;
    private JTextField jtfNIF, jtfNombre, jtfCodPos, jtfPobl, jtfProv, jtfEmail;

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
        bAnyadir=new JButton("Añadir cliente");
        botonesClientes.add(bAnyadir);
        bBorrar=new JButton("Borrar cliente");
        botonesClientes.add(bBorrar);
        bCambioTarifa=new JButton("Cambiar tarifa cliente");
        botonesClientes.add(bCambioTarifa);
        bDatosCliente=new JButton("Datos cliente");
        botonesClientes.add(bDatosCliente);
        bListado=new JButton("Listado clientes");
        botonesClientes.add(bListado);
        bListadoFechas=new JButton("Listado clientes entre fechas");
        botonesClientes.add(bListadoFechas);
        panelClientes.add(botonesClientes,BorderLayout.NORTH);  //añadimos botones al subpanes
        JPanel camposClientes=new JPanel();
        camposClientes.setLayout(new GridLayout(8,2));
        jtfNIF=new JTextField();
        camposClientes.add(jtfNIF,1);
        camposClientes.add(new JLabel("Nombre:"),2);
        jtfNombre=new JTextField();
        camposClientes.add(jtfNombre,3);
        camposClientes.add(new JLabel("Cod.Postal:"),4);
        jtfCodPos=new JTextField();
        camposClientes.add(jtfCodPos,5);
        camposClientes.add(new JLabel("Población:"),6);
        jtfPobl=new JTextField();
        camposClientes.add(jtfPobl,7);
        camposClientes.add(new JLabel("Provincia:"),8);
        jtfProv=new JTextField();
        camposClientes.add(jtfProv,9);
        camposClientes.add(new JLabel("E-mail:"),10);
        jtfEmail=new JTextField();
        camposClientes.add(jtfEmail,11);
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
}
