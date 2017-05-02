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
        VistaCliente vistaParticular=new VistaParticular();
        VistaCliente vistaEmpresa=new VistaEmpresa();
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

        vistaParticular.setModeloCliente(particulares);  //Ponemos a cada vista su modelo
        vistaEmpresa.setModeloCliente(empresas);
        vistaFacturas.setModeloFactura(facturas);
        vistaLlamadas.setModeloLlamada(llamadas);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazGrafica().ejecuta();
            }
        });
    }

}
