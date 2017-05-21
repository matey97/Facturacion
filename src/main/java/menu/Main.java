package menu;

import controlador.ControladorCliente;
import controlador.ControladorLlamada;
import controlador.ControladorFacturas;
import modelo.colecciones.*;
import vista.*;

import javax.swing.*;
import java.io.*;

/**
 * Created by al341802 on 21/02/17.
 */
public class Main {

    public static void main(String[] args) {

        VistaClientes vistaClientes=new VistaClientes();    //Creamos vistas
        VistaFacturas vistaFacturas=new VistaFacturas();
        VistaLlamadas vistaLlamadas=new VistaLlamadas();

        ColeccionClientes clientes=new ColeccionClientes();     //Creamos modelos y cargamos datos
        ColeccionFacturas facturas=new ColeccionFacturas();
        ColeccionLlamadas llamadas=new ColeccionLlamadas();

        try{
            FileInputStream fichClientes = new FileInputStream("clientes.bin");
            FileInputStream fichLlamadas = new FileInputStream("llamadas.bin");
            FileInputStream fichFacturas = new FileInputStream("facturas.bin");
            ObjectInputStream objClientes = new ObjectInputStream(fichClientes);
            ObjectInputStream objLlamadas = new ObjectInputStream(fichLlamadas);
            ObjectInputStream objFacturas = new ObjectInputStream(fichFacturas);
            clientes = (ColeccionClientes) objClientes.readObject();
            llamadas = (ColeccionLlamadas) objLlamadas.readObject();
            facturas = (ColeccionFacturas) objFacturas.readObject();
            objClientes.close();
            objLlamadas.close();
            objFacturas.close();
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

        ControladorCliente controladorCliente = new ControladorCliente();   //Creamos controladores
        ControladorLlamada controladorLlamada = new ControladorLlamada();
        ControladorFacturas controladorFactura = new ControladorFacturas();

        clientes.setVista(vistaClientes);   //Ponemos a cada modelo su vista
        facturas.setVista(vistaFacturas);
        llamadas.setVista(vistaLlamadas);

        vistaClientes.setModeloCliente(clientes);  //A cada vista, su modelo y controlador
        vistaClientes.setControladorCliente(controladorCliente);
        vistaFacturas.setModeloFactura(facturas);
        vistaFacturas.setControladorFactura(controladorFactura);
        vistaLlamadas.setModeloLlamada(llamadas);
        vistaLlamadas.setControladorLlamada(controladorLlamada);

        controladorCliente.setModelo(clientes);
        controladorCliente.setVista(vistaClientes);

        controladorFactura.setModeloFacturas(facturas);
        controladorFactura.setModeloClientes(clientes);
        controladorFactura.setModeloLlamadas(llamadas);
        controladorFactura.setVista(vistaFacturas);

        controladorLlamada.setModelo(llamadas);
        controladorLlamada.setVista(vistaLlamadas);


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InterfazGrafica ig = new InterfazGrafica();
                ig.setVistaClientes(vistaClientes);
                ig.setVistaLlamadas(vistaLlamadas);
                ig.setVistaFacturas(vistaFacturas);
                ig.ejecuta();
            }
        });
    }

}
