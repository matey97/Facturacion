package facturacion.colecciones;

import facturacion.cliente.Cliente;


import java.util.Collection;
import java.util.HashMap;
import java.util.StringJoiner;

/**
 * Created by user on 26/02/17.
 */
public class ColeccionEmpresas implements ColeccionClientes {

    private HashMap<String,Cliente> empresas;

    public ColeccionEmpresas(){
        empresas=new HashMap<>();
    }

    @Override
    public boolean existeCliente(String NIF) {
        if (empresas.containsKey(NIF))
            return true;
        return false;
    }

    @Override
    public boolean añadirCliente(Cliente cliente) {
        if (existeCliente(cliente.getNIF()))
            return false;
        empresas.put(cliente.getNIF(),cliente);
        return true;
    }

    @Override
    public boolean borrarCliente(String NIF) {
        if (!existeCliente(NIF))
            return false;
        empresas.remove(NIF);
        return true;
    }

    @Override
    public boolean cambiarTarifa(String NIF, int precioMinuto) {
        if (existeCliente(NIF)){
            empresas.get(NIF).getTarifa().setPrecioMinuto(precioMinuto);
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
