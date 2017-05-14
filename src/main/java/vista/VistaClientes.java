package vista;

import controlador.ControladorParaVista;
import modelo.ModeloClienteParaVista;
import modelo.Utiles;
import modelo.cliente.Cliente;
import modelo.colecciones.ColeccionClientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by User on 03/05/2017.
 */
public class VistaClientes implements VistaParaModeloCliente, VistaParaControladorClientes{
    private ModeloClienteParaVista modeloCliente;
    private ControladorParaVista controladorCliente;
    private JButton bAnyadir, bBorrar, bCambioTarifa, bDatosCliente, bListado, bListadoFechas;
    private JTextField jtfNIF,jtfNIFBorra,jtfNIFTarifa , jtfNIFConsulta, jtfNombre, jtfApellidos, jtfCodPos, jtfPobl, jtfProv, jtfEmail;
    private JTextArea areaTexto;
    private JRadioButton particular, empresa, tardes, domingos;

    public VistaClientes() {
        super();
    }

    public void setModeloCliente(ModeloClienteParaVista modeloCliente) {
        this.modeloCliente = modeloCliente;
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
        areaTexto=new JTextArea(20,50);
        areaTexto.setEditable(false);
        JScrollPane scroll=new JScrollPane(areaTexto);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelClientes.add(scroll,BorderLayout.SOUTH);
        panelClientes.add(camposClientes);
        return panelClientes;
    }

    @Override
    public void modeloModificado(){
        areaTexto.setText("");
        for (Cliente c : modeloCliente.getListadoClientes()){
            areaTexto.append(c.toString());
        }
        jtfNIF.setText("");
        jtfNombre.setText("");
        jtfApellidos.setText("");
        jtfCodPos.setText("");
        jtfPobl.setText("");
        jtfProv.setText("");
        jtfEmail.setText("");
    }

    @Override
    public String getNIF() {
        return jtfNIF.getText();
    }

    @Override
    public String getNIFBorrar() {
        return jtfNIFBorra.getText();
    }

    @Override
    public String getNIFTarifa() {
        return jtfNIFTarifa.getText();
    }

    @Override
    public String getNIFDatos() {
        return jtfNIFConsulta.getText();
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

    @Override
    public boolean esParticular() {
        return particular.isSelected();
    }

    @Override
    public boolean esEmpresa() {
        return empresa.isSelected();
    }

    @Override
    public boolean tarifaTardes() {
        return tardes.isSelected();
    }

    @Override
    public boolean tarifaDomingos() {
        return domingos.isSelected();
    }

    //Escuchadores
    private class EscuchadorBAnyadir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog dialogoAnyadir = new JDialog();
            dialogoAnyadir.setLocationRelativeTo(bAnyadir);
            JPanel panel = new JPanel();
            particular = new JRadioButton("Particular");
            empresa =new JRadioButton("Empresa");
            ButtonGroup grupo = new ButtonGroup();
            grupo.add(particular);
            grupo.add(empresa);
            panel.add(particular);
            panel.add(empresa);
            dialogoAnyadir.add(new JLabel(" Que tipo de cliente quieres añadir? \n"),BorderLayout.NORTH);
            dialogoAnyadir.add(panel);
            JButton aceptar=new JButton("Aceptar");
            aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Por implementar
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
            JDialog dialogoBorrar = new JDialog();
            dialogoBorrar.setLocationRelativeTo(bBorrar);
            JPanel panel = new JPanel();
            panel.add(new JLabel("NIF: "));
            jtfNIFBorra=new JTextField(20);
            panel.add(jtfNIFBorra);
            dialogoBorrar.add(new JLabel(" NIF del cliente a borrar \n"),BorderLayout.NORTH);
            dialogoBorrar.add(panel);
            JButton aceptar=new JButton("Aceptar");
            aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Por implementar
                    dialogoBorrar.setVisible(false);
                }
            });
            dialogoBorrar.add(aceptar, BorderLayout.SOUTH);
            dialogoBorrar.pack();
            dialogoBorrar.setVisible(true);
        }
    }

    private class EscuchadorBCambioTarifa implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog dialogoDatos=new JDialog();
            dialogoDatos.setLocationRelativeTo(bCambioTarifa);
            JPanel panelDialogo=new JPanel();
            tardes = new JRadioButton("Tarifa tardes");
            domingos =new JRadioButton("Tarifa domingos gratis");
            JPanel panelB = new JPanel();
            panelB.add(tardes);
            panelB.add(domingos);
            dialogoDatos.add(panelB, BorderLayout.NORTH);
            panelDialogo.add(new JLabel("NIF del cliente:"));
            jtfNIFTarifa =new JTextField(20);
            panelDialogo.add(jtfNIFTarifa);
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

    private class EscuchadorBDatosCliente implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog dialogoDatos=new JDialog();
            dialogoDatos.setLocationRelativeTo(bDatosCliente);
            JPanel panelDialogo=new JPanel();

            panelDialogo.add(new JLabel("NIF del cliente:"));
            jtfNIFConsulta =new JTextField(20);
            panelDialogo.add(jtfNIFConsulta);
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
            modeloModificado();
        }
    }

    private class EscuchadorBListadoFechas implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog dialogoDatos=new JDialog();
            dialogoDatos.setLocationRelativeTo(bListadoFechas);
            dialogoDatos.add(new JLabel("Introduce dos fechas: "),BorderLayout.NORTH);
            JPanel panel=new JPanel();
            panel.setLayout(new BorderLayout());
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
            panel.add(fechaINI, BorderLayout.NORTH);
            panel.add(fechaFIN);
            JButton aceptar=new JButton("Aceptar");

            aceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    areaTexto.setText("");
                    int anyoI=Integer.parseInt(anyoIni.getText());
                    int mesI=Integer.parseInt(mesIni.getText());
                    int diaI=Integer.parseInt(diaIni.getText());
                    int anyoF=Integer.parseInt(anyoFin.getText());
                    int mesF=Integer.parseInt(mesFin.getText());
                    int diaF=Integer.parseInt(diaFin.getText());
                    Collection<Cliente> colC = Utiles.entreDosFechas(modeloCliente.getListadoClientes(), LocalDateTime.of(anyoI,mesI,diaI,0,0),LocalDateTime.of(anyoF,mesF,diaF,0,0));
                    areaTexto.append("\nParticulares:\n");
                    for(Cliente c : colC){
                        areaTexto.append(c.toString());
                        areaTexto.append("");
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
            FileInputStream fichClientes = new FileInputStream("clientes.bin");
            ObjectInputStream objClientes = new ObjectInputStream(fichClientes);
            modeloCliente = (ColeccionClientes) objClientes.readObject();
            objClientes.close();
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
            FileOutputStream fichClientes = new FileOutputStream("clientes.bin");
            ObjectOutputStream objClientes = new ObjectOutputStream(fichClientes);
            objClientes.writeObject(modeloCliente);
            objClientes.close();
        }catch (FileNotFoundException e) {
            System.out.println("Error al intentar abrir el fichero.");
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Error en ObjectOutputStream");
            System.out.println(e);
        }
    }
}

