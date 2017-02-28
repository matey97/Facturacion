package facturacion.colecciones;

import facturacion.cliente.Cliente;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by user on 26/02/17.
 */
public class ColeccionParticulares implements ColeccionClientes {

    private HashMap<String,Cliente> particulares;

    public ColeccionParticulares() {
       particulares = new HashMap<String,Cliente>();
    }

    @java.lang.Override
    public boolean existeCliente(String NIF) {
        if(particulares.containsKey(NIF)){
            return true;
        }
        return false;
    }

    @java.lang.Override
    public boolean añadirCliente(Cliente cliente) {
        if (!existeCliente(cliente.getNIF())){
            particulares.put(cliente.getNIF(),cliente);
            return true;
        }
        return false;
    }

    @java.lang.Override
    public boolean borrarCliente(String NIF) {
        if( particulares.containsKey(NIF)){
            particulares.remove(NIF);
            return true;
        }
        return false;
    }

    @java.lang.Override
    public boolean cambiarTarifa(String NIF, int precioMinuto) {
        if(particulares.containsKey(NIF)){
            Cliente aux = particulares.get(NIF);
            aux.getTarifa().setPrecioMinuto(precioMinuto);
            return true;
        }
        return false;
    }

    @java.lang.Override
    public Cliente getDatosCliente(String NIF) {
        if(particulares.containsKey(NIF))
            return particulares.get(NIF);
        return null;
    }


    @java.lang.Override
    public Collection<Cliente> getListadoClientes() {
        return particulares.values();
    }
}
