package facturacion.colecciones;

import facturacion.cliente.Cliente;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by user on 26/02/17.
 */
public abstract class ColeccionClientes{

    private HashMap<String,Cliente> clientes;

    public ColeccionClientes() {
        clientes = new HashMap<String,Cliente>();
    }

    public boolean existeCliente(String NIF) {
        if(clientes.containsKey(NIF)){
            return true;
        }
        return false;
    }

    public boolean añadirCliente(Cliente cliente) {
        if (!existeCliente(cliente.getNIF())){
            clientes.put(cliente.getNIF(),cliente);
            return true;
        }
        return false;
    }

    public boolean borrarCliente(String NIF) {
        if( clientes.containsKey(NIF)){
            clientes.remove(NIF);
            return true;
        }
        return false;
    }

    public boolean cambiarTarifa(String NIF, int precioMinuto) {
        if(clientes.containsKey(NIF)){
            Cliente aux = clientes.get(NIF);
            aux.getTarifa().setPrecioMinuto(precioMinuto);
            return true;
        }
        return false;
    }

    public Cliente getDatosCliente(String NIF) {
        if(clientes.containsKey(NIF))
            return clientes.get(NIF);
        return null;
    }

    public Collection<Cliente> getListadoClientes() {
        return clientes.values();
    }
}
