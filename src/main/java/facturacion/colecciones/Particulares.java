package facturacion.colecciones;

import facturacion.cliente.Cliente;

import java.util.HashMap;

/**
 * Created by user on 26/02/17.
 */
public class Particulares implements Clientes{

    private HashMap<String,Cliente> particular;

    public Particulares() {
       HashMap<String, Cliente> particular = new HashMap<String,Cliente>();
    }

    @java.lang.Override
    public boolean existeCliente(Cliente cliente) {
        if(particular.containsKey(cliente.getNIF())){
            return true;
        }
        return false;
    }

    @java.lang.Override
    public boolean añadirCliente(Cliente cliente) {
        if (!existeCliente(cliente)){
            particular.put(cliente.getNIF(),cliente);//revisar implementación encontrar error.
            return true;
        }
        return false;
    }

    @java.lang.Override
    public boolean borrarCliente(Cliente cliente) {
        if( particular.containsKey(cliente.getNIF(),cliente)){
            particular.remove(cliente.getNIF());
            return true;
        }
        return false;
    }

    @java.lang.Override
    public boolean cambiarTarifa(Cliente cliente, int precioMinuto) {
        if(particular.containsKey(cliente.getNIF())){
            Cliente aux =particular.get(cliente.getNIF());
            aux.getTarifa().setPrecioMinuto(precioMinuto);
            return true;
        }
        return false;
    }

    @java.lang.Override
    public Cliente getDatosCliente(String NIF) {
        if(particular.containsKey(NIF)) {
            return particular.get(NIF);

        return null;
    }


    @java.lang.Override
    public Collection<Cliente> getListadoClientes() {
        return particular.values();
    }
}
