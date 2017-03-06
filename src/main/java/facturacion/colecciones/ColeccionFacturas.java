package facturacion.colecciones;

import facturacion.cliente.Cliente;
import facturacion.factura.Factura;
import facturacion.factura.Llamada;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;

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

    public Factura emitirFactura(Cliente cliente, ColeccionLlamadas llamadas, LocalDateTime periodoFacturacion){
        int importe=0;

        for (Llamada llamada : llamadas.listarLlamadas(cliente.getNIF())){
            importe=llamada.getDuración()*cliente.getTarifa().getPrecioMinuto();
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
