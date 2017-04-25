package modelo;

import modelo.cliente.Cliente;

import java.util.Collection;

/**
 * Created by al341802 on 25/04/17.
 */
public interface ModeloParaVista {
    Cliente getDatosCliente(String NIF);
    Collection<Cliente> getListadoClientes();

}
