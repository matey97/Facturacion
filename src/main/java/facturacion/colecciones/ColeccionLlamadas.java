package facturacion.colecciones;

import facturacion.Excepciones.ExcepcionClienteSinLlamadas;
import facturacion.cliente.Cliente;
import facturacion.factura.Llamada;

import java.util.Collection;
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

    public void darDeAlta(String nif, Llamada llamada){
        if (!llamadas.containsKey(nif)) {
            llamadas.put(nif, new LinkedList<>());
        }
        llamadas.get(nif).add(llamada);
    }

    public Collection<Llamada> listarLlamadas(String nif)throws ExcepcionClienteSinLlamadas{
        Collection<Llamada> llamadasNif =llamadas.get(nif);
        if (llamadasNif!=null){
            return llamadasNif;
        }else{
            throw new ExcepcionClienteSinLlamadas("no hay llamadas");
        }
    }
}
