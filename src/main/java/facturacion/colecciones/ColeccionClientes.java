package facturacion.colecciones;

import facturacion.cliente.Cliente;

import java.util.Collection;

/**
 * Created by user on 26/02/17.
 */
public interface ColeccionClientes {
    public boolean existeCliente(String NIF);
    public boolean añadirCliente(Cliente cliente);
    public boolean borrarCliente(String NIF);
    public boolean cambiarTarifa(String NIF, int precioMinuto);
    public Cliente getDatosCliente(String NIF);
    public Collection<Cliente> getListadoClientes();
}
