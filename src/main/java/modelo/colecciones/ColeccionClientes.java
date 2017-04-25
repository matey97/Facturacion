package modelo.colecciones;

import modelo.cliente.Cliente;
import vista.VistaImplementacion;
import vista.VistaParaModelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by user on 26/02/17.
 */
public abstract class ColeccionClientes implements Serializable{
    private VistaParaModelo vista;

    private HashMap<String,Cliente> clientes;

    public ColeccionClientes() {
        clientes = new HashMap<String,Cliente>();
    }

    public void setVista(VistaParaModelo vista) {
        this.vista = vista;
    }

    public boolean existeCliente(String NIF) {
        if(clientes.containsKey(NIF)){
            return true;
        }
        return false;
    }

    public boolean anyadirCliente(Cliente cliente) {
        if (!existeCliente(cliente.getNIF())){
            clientes.put(cliente.getNIF(),cliente);
            vista.nuevoClienteAnyadido();
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

/*    public boolean cambiarTarifa(String NIF, int precioMinuto) {
        if(clientes.containsKey(NIF)){
            Cliente aux = clientes.get(NIF);
            aux.getTarifa().setPrecioMinuto(precioMinuto);
            return true;
        }
        return false;
    }*/

    public Cliente getDatosCliente(String NIF) {
        if(clientes.containsKey(NIF))
            return clientes.get(NIF);
        return null;
    }

    public Collection<Cliente> getListadoClientes() {
        return clientes.values();
    }
}
