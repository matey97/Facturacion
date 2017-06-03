package menu;

import controlador.ControladorCliente;
import controlador.ControladorFacturas;
import controlador.ControladorLlamada;
import modelo.colecciones.ColeccionClientes;
import modelo.colecciones.ColeccionFacturas;
import modelo.colecciones.ColeccionLlamadas;
import vista.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by Miguel on 03/06/2017.
 */
public class Gestion {
    private VistaClientes vistaClientes;
    private VistaLlamadas vistaLlamadas;
    private VistaFacturas vistaFacturas;

    private ColeccionClientes clientes;
    private ColeccionFacturas facturas;
    private ColeccionLlamadas llamadas;

    private ControladorCliente controladorCliente;
    private ControladorLlamada controladorLlamada;
    private ControladorFacturas controladorFactura;

    public Gestion(){
        super();
    }

    public void iniciaMVC(){
        vistaClientes=new VistaClientes();
        vistaLlamadas=new VistaLlamadas();
        vistaFacturas=new VistaFacturas();

        clientes=new ColeccionClientes();
        facturas=new ColeccionFacturas();
        llamadas=new ColeccionLlamadas();

        controladorCliente=new ControladorCliente();
        controladorFactura=new ControladorFacturas();
        controladorLlamada=new ControladorLlamada();

        cargaDatos();
        enlazaEstructuras();
    }

    private void cargaDatos(){
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
    }

    private void enlazaEstructuras(){
        clientes.setVista(vistaClientes);
        facturas.setVista(vistaFacturas);
        llamadas.setVista(vistaLlamadas);

        vistaClientes.setModeloCliente(clientes);
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
    }

    public void cargaInterfaz(){
        InterfazGrafica ig = new InterfazGrafica();
        ig.setVistaClientes(vistaClientes);
        ig.setVistaLlamadas(vistaLlamadas);
        ig.setVistaFacturas(vistaFacturas);
        ig.ejecuta();
    }
}
