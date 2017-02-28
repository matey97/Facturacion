package facturacion.colecciones;

import facturacion.cliente.Cliente;
import facturacion.factura.Llamada;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by user on 27/02/17.
 */
public class ColeccionLlamadas {

    private HashMap<String,LinkedList<Llamada>> llamadas;

    public ColeccionLlamadas(){
        llamadas=new HashMap<>();
    }

    public void darDeAlta(Cliente cliente, Llamada llamada){
        if (!llamadas.containsKey(cliente.getNIF()))
            llamadas.put(cliente.getNIF(),new LinkedList<>());
        llamadas.get(cliente.getNIF()).add(llamada);
    }

    public LinkedList<Llamada> listarLlamadas(Cliente cliente){
        return llamadas.get(cliente.getNIF());
    }
}
