package menu;

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
        VistaClientes vistaClientes=new VistaClientes();
        VistaFacturas vistaFacturas=new VistaFacturas();
        VistaLlamadas vistaLlamadas=new VistaLlamadas();

        ColeccionClientes clientes=new ColeccionClientes();
        ColeccionFacturas facturas=new ColeccionFacturas();
        ColeccionLlamadas llamadas=new ColeccionLlamadas();

        clientes.setVista(vistaClientes);   //Ponemos a cada modelo su vista
        facturas.setVista(vistaFacturas);
        llamadas.setVista(vistaLlamadas);

        vistaClientes.setModeloCliente(clientes);  //Ponemos a cada vista su modelo
        vistaFacturas.setModeloFactura(facturas);
        vistaLlamadas.setModeloLlamada(llamadas);

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
