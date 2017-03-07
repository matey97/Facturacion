package facturacion.colecciones;

import facturacion.cliente.Cliente;
import facturacion.factura.Factura;
import facturacion.factura.Llamada;
import facturacion.factura.PeriodoFacturacion;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by user on 27/02/17.
 */
public class ColeccionFacturas {

    private HashMap<String,HashMap<Integer,Factura>> facturas;
    private static int contador;

    public ColeccionFacturas(){
        facturas=new HashMap<>();
        contador=1;
    }


    public Factura emitirFactura(Cliente cliente, LinkedList llamadas, PeriodoFacturacion periodoFacturacion){
        //Cliente cliente = ColeccionParticulares.getDatosCliente(nif);
        int importe=0;


        Iterator<Llamada> it = llamadas.iterator();
        Llamada llamada;
        while(it.hasNext()){
            llamada=it.next();
            if (periodoFacturacion.getFechaInicial().isAfter(llamada.getFecha()) &&
                    periodoFacturacion.getFechaFinal().isBefore(llamada.getFecha())){

                importe+=llamada.getDuración()*cliente.getTarifa().getPrecioMinuto();
            }
        }
        Factura aux=new Factura(contador++,cliente.getTarifa(),LocalDateTime.now(),periodoFacturacion,importe); //Fecha facturacion?
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

    public Collection<Factura> recuperarFacturasCliente(String nif){
        if (facturas.containsKey(nif))
            return facturas.get(nif).values();
        return null;
    }
}
