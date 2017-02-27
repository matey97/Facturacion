package facturacion.colecciones;

import facturacion.cliente.Cliente;
import facturacion.factura.Factura;
import facturacion.factura.Llamada;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by user on 27/02/17.
 */
public class Facturas {

    private HashMap<String,HashMap<Integer,Factura>> facturas;
    private static int contador;

    public Facturas(){
        facturas=new HashMap<>();
        contador=1;
    }

    public Factura emitirFactura(Cliente cliente, Llamadas llamadas){
        int importe=0;
        for (Llamada llamada : llamadas.listarLlamadas(cliente)){
            importe=llamada.getDuración()*cliente.getTarifa().getPrecioMinuto();
        }
        Factura aux=new Factura(contador++,cliente.getTarifa(),LocalDateTime.now(),,importe); //Fecha facturacion?
        if (!facturas.containsKey(cliente.getNIF()))
            facturas.put(cliente.getNIF(),new HashMap<>());
        facturas.get(cliente.getNIF()).put(aux.getCodfac(),aux);
        return aux;
    }

    public Factura recuperarDatosFactura(int codigoFactura){
        for (HashMap<Integer,Factura> aux: facturas.values()){
            if (aux.containsKey(codigoFactura))
                return aux.get(codigoFactura);
        }
        return null;
    }

    public Collection<Factura> recuperarFacturasCliente(Cliente cliente){
        if (facturas.containsKey(cliente.getNIF()))
            return facturas.get(cliente.getNIF()).values();
        return null;
    }
}
