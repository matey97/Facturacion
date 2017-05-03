package vista;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;
import modelo.ModeloClienteParaVista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 03/05/2017.
 */
public class VistaClientes implements VistaParaModeloCliente, VistaParaControladorClientes{
    private ModeloClienteParaVista modeloParticular;
    private ModeloClienteParaVista modeloEmpresa;
    private JButton bAnyadir, bBorrar, bCambioTarifa, bDatosCliente, bListado, bListadoFechas;
    private JTextField jtfNIF,jtfNIF2, jtfNombre, jtfApellidos, jtfCodPos, jtfPobl, jtfProv, jtfEmail;

    public VistaClientes() {
        super();
    }

    public void setModeloParticular(ModeloClienteParaVista modeloParticular) {
        this.modeloParticular = modeloParticular;
    }
    public void setModeloEmpresa(ModeloClienteParaVista modeloEmpresa) {
        this.modeloEmpresa = modeloEmpresa;
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
        camposClientes.add(new JLabel("Apellidos (solo particulares):"),4);
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
    private class EscuchadorBAnyadir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog dialogoAnyadir = new JDialog();
            JPanel panel = new JPanel();
            JRadioButton particular = new JRadioButton("Particular");
            JRadioButton empresa =new JRadioButton("Empresa");
            ButtonGroup grupo = new ButtonGroup();
            grupo.add(particular);
            grupo.add(empresa);
            panel.add(particular);
            panel.add(empresa);
            dialogoAnyadir.add(new JLabel("Que tipo de cliente quieres añadir?"),BorderLayout.NORTH);
            dialogoAnyadir.add(panel);
            JButton aceptar=new JButton("Aceptar");
            aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (particular.isSelected()){
                        //Por implementar
                    }else if (empresa.isSelected()){
                        //Por implementar
                    }
                    dialogoAnyadir.setVisible(false);
                }
            });
            dialogoAnyadir.add(aceptar, BorderLayout.SOUTH);
            dialogoAnyadir.pack();
            dialogoAnyadir.setVisible(true);



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

