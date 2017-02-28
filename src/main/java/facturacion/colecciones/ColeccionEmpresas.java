package facturacion.colecciones;

import facturacion.cliente.Cliente;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by user on 26/02/17.
 */
public class ColeccionEmpresas implements ColeccionClientes {

    private HashMap<String,Cliente> empresas;

    public ColeccionEmpresas(){
        empresas=new HashMap<>();
    }

    @Override
    public boolean existeCliente(Cliente cliente) {
        if (empresas.containsKey(cliente.getNIF()))
            return true;
        return false;
    }

    @Override
    public boolean añadirCliente(Cliente cliente) {
        if (existeCliente(cliente))
            return false;
        empresas.put(cliente.getNIF(),cliente);
        return true;
    }

    @Override
    public boolean borrarCliente(Cliente cliente) {
        if (!existeCliente(cliente))
            return false;
        empresas.remove(cliente.getNIF());
        return true;
    }

    @Override
    public boolean cambiarTarifa(Cliente cliente, int precioMinuto) {
        if (existeCliente(cliente)){
            empresas.get(cliente.getNIF()).getTarifa().setPrecioMinuto(precioMinuto);
            return true;
        }
        return false;
    }

    @Override
    public Cliente getDatosCliente(String NIF) {
        if (empresas.containsKey(NIF))
            return empresas.get(NIF);
        return null;
    }

    @Override
    public Collection<Cliente> getListadoClientes() {
        return empresas.values();
    }
}
