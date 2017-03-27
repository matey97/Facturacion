package facturacion.colecciones;

import facturacion.excepciones.FechaInicialMayorQueFinal;
import facturacion.Utiles;
import facturacion.cliente.Cliente;
import facturacion.factura.Factura;
import facturacion.factura.Llamada;
import facturacion.factura.PeriodoFacturacion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by user on 27/02/17.
 */
public class ColeccionFacturas implements Serializable{

    private HashMap<String,HashMap<Integer,Factura>> facturas;
    private static int contador;

    public ColeccionFacturas(){
        facturas=new HashMap<>();
        contador=1;
    }


    public Factura emitirFactura(Cliente cliente, Collection llamadas, PeriodoFacturacion periodoFacturacion) throws FechaInicialMayorQueFinal{

        int importe=0;

        Collection<Llamada> col=Utiles.entreDosFechas(llamadas,periodoFacturacion.getFechaInicial(),periodoFacturacion.getFechaFinal());
        Iterator<Llamada> it=col.iterator();
        Llamada llamada;
        while(it.hasNext()) {
            llamada=it.next();
            importe += llamada.getDuración() * cliente.getTarifa().getPrecioMinuto();
        }

        Factura aux=new Factura(contador++,cliente.getTarifa(),LocalDateTime.now(),periodoFacturacion,importe);
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
