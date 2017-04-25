package controlador;

import modelo.cliente.Cliente;

/**
 * Created by sergiojimenez on 25/4/17.
 */
public class ControladorImplementacion {
    private modelo modelo;
    private vista vista;

     public void borrandoCliente(){
         String nif = vista.getnif();
         modelo.borraCliente(nif);
     }
     public void añadirCliente(){
         Cliente cliente = vista.anyadirCliente();

     }
     public void
}
