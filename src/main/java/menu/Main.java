package menu;

import controlador.ControladorCliente;
import controlador.ControladorLlamada;
import controlador.ControladorParaFacturas;
import controlador.ControladorParaModeloCliente;
import modelo.colecciones.*;
import vista.*;

import javax.swing.*;

/**
 * Created by al341802 on 21/02/17.
 */
public class Main {

    public static void main(String[] args) {
 /*       GestionDatos datos = new GestionDatos();
       MenuConsola MenuConsola = new MenuConsola();
       MenuConsola.muestraMenu();

*/
        VistaClientes vistaClientes=new VistaClientes();    //Creamos vistas
        VistaFacturas vistaFacturas=new VistaFacturas();
        VistaLlamadas vistaLlamadas=new VistaLlamadas();

        ColeccionClientes clientes=new ColeccionClientes();     //Creamos modelos
        ColeccionFacturas facturas=new ColeccionFacturas();
        ColeccionLlamadas llamadas=new ColeccionLlamadas();

        ControladorCliente controladorCliente = new ControladorCliente();   //Creamos controladores
        ControladorLlamada controladorLlamada = new ControladorLlamada();
        ControladorParaFacturas controladorFactura = new ControladorParaFacturas();

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
