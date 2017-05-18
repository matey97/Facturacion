package modelo.colecciones;

import controlador.ControladorParaModeloCliente;
import modelo.ModeloClienteParaVista;
import modelo.ModeloParaControladorCliente;
import modelo.cliente.Cliente;
import vista.VistaParaModeloCliente;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by user on 26/02/17.
 */
public class ColeccionClientes implements Serializable, ModeloClienteParaVista, ModeloParaControladorCliente{

    private VistaParaModeloCliente vista;

    private HashMap<String,Cliente> clientes;

    public ColeccionClientes() {
        clientes = new HashMap<String,Cliente>();
    }

    public void setVista(VistaParaModeloCliente vista) {
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
            vista.modeloModificado();
            return true;
        }
        return false;
    }

    public boolean borrarCliente(String NIF) {
        System.out.println(clientes.size());
        System.out.println(NIF);
        if( clientes.containsKey(NIF)){
            System.out.println("Pasaaaa");
            clientes.remove(NIF);
            vista.modeloModificado();
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
