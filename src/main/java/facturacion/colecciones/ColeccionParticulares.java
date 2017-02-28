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
    public boolean existeCliente(Cliente cliente) {
        if(particulares.containsKey(cliente.getNIF())){
            return true;
        }
        return false;
    }

    @java.lang.Override
    public boolean añadirCliente(Cliente cliente) {
        if (!existeCliente(cliente)){
            particulares.put(cliente.getNIF(),cliente);//revisar implementación encontrar error.
            return true;
        }
        return false;
    }

    @java.lang.Override
    public boolean borrarCliente(Cliente cliente) {
        if( particulares.containsKey(cliente.getNIF())){
            particulares.remove(cliente.getNIF());
            return true;
        }
        return false;
    }

    @java.lang.Override
    public boolean cambiarTarifa(Cliente cliente, int precioMinuto) {
        if(particulares.containsKey(cliente.getNIF())){
            Cliente aux = particulares.get(cliente.getNIF());
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
