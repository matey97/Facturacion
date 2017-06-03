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

        Gestion gestion=new Gestion();

        gestion.iniciaMVC();
        gestion.cargaDatos();
        gestion.enlazaEstructuras();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gestion.cargaInterfaz();
            }
        });
    }

}
