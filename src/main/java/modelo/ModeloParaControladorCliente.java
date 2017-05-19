package modelo;

import modelo.cliente.Cliente;

import java.util.Collection;

/**
 * Created by sergiojimenez on 2/5/17.
 */
public interface ModeloParaControladorCliente {

        public boolean anyadirCliente(Cliente cliente);
        public boolean borrarCliente(String nif);
        public Cliente getDatosCliente (String nif);
        public boolean existeCliente(String NIF);



}
