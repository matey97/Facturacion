package modelo;

import modelo.cliente.Cliente;

import java.util.Collection;

/**
 * Created by sergiojimenez on 2/5/17.
 */
public interface MetodosModeloParaControlador {

       public boolean anyadirCliente(Cliente cliente);
       public boolean borrarClinte(String nif);
       Collection<Cliente> getListadoClientes();

}
