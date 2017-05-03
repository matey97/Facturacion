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

        ColeccionClientes particulares=new ColeccionParticulares();
        ColeccionClientes empresas=new ColeccionEmpresas();
        ColeccionFacturas facturas=new ColeccionFacturas();
        ColeccionLlamadas llamadas=new ColeccionLlamadas();


        particulares.setVista(vistaClientes);   //Ponemos a cada modelo su vista
        empresas.setVista(vistaClientes);
        facturas.setVista(vistaFacturas);
        llamadas.setVista(vistaLlamadas);

        vistaClientes.setModeloParticular(particulares);  //Ponemos a cada vista su modelo
        vistaClientes.setModeloEmpresa(empresas);
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
