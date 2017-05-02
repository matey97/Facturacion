package menu;

import modelo.excepciones.*;
import modelo.Utiles;
import modelo.cliente.Cliente;
import modelo.cliente.Direccion;
import modelo.factorias.*;
import modelo.factura.Factura;
import modelo.factura.Llamada;
import modelo.factura.PeriodoFacturacion;
import modelo.tarifa.Tarifa;
import vista.InterfazGrafica;

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
*/      SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazGrafica().ejecuta();
            }
        });
    }

}
