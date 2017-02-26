package facturacion.colecciones;

import facturacion.cliente.Cliente;

import java.util.Collection;

/**
 * Created by user on 26/02/17.
 */
public interface Clientes {
    public boolean existeCliente(Cliente cliente);
    public boolean añadirCliente(Cliente cliente);
    public boolean borrarCliente(Cliente cliente);
    public boolean cambiarTarifa(Cliente cliente, int precioMinuto);
    public Cliente getDatosCliente(String NIF);
    public Collection<Cliente> getListadoClientes();
}
