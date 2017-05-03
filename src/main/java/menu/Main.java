package menu;

import modelo.colecciones.*;
import modelo.excepciones.*;
import modelo.Utiles;
import modelo.cliente.Cliente;
import modelo.cliente.Direccion;
import modelo.factorias.*;
import modelo.factura.Factura;
import modelo.factura.Llamada;
import modelo.factura.PeriodoFacturacion;
import modelo.tarifa.Tarifa;
import vista.*;

import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by al341802 on 21/02/17.
 */
public class Main {

    public static void main(String[] args) {
 /*       GestionDatos datos = new GestionDatos();
       MenuConsola MenuConsola = new MenuConsola();
       MenuConsola.muestraMenu();

*/
        VistaParticular vistaParticular=new VistaParticular();
        VistaEmpresa vistaEmpresa=new VistaEmpresa();
        VistaFacturas vistaFacturas=new VistaFacturas();
        VistaLlamadas vistaLlamadas=new VistaLlamadas();

        ColeccionClientes particulares=new ColeccionParticulares();
        ColeccionClientes empresas=new ColeccionEmpresas();
        ColeccionFacturas facturas=new ColeccionFacturas();
        ColeccionLlamadas llamadas=new ColeccionLlamadas();


        particulares.setVista(vistaParticular);   //Ponemos a cada modelo su vista
        empresas.setVista(vistaEmpresa);
        facturas.setVista(vistaFacturas);
        llamadas.setVista(vistaLlamadas);

        vistaParticular.setModeloParticular(particulares);  //Ponemos a cada vista su modelo
        vistaEmpresa.setModeloEmpresa(empresas);
        vistaFacturas.setModeloFactura(facturas);
        vistaLlamadas.setModeloLlamada(llamadas);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InterfazGrafica ig = new InterfazGrafica();
                ig.setVistaParticular(vistaParticular);
                ig.setVistaEmpresa(vistaEmpresa);
                ig.setVistaLlamadas(vistaLlamadas);
                ig.setVistaFacturas(vistaFacturas);
                ig.ejecuta();
            }
        });
    }

}
