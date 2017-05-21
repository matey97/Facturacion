package modelo.colecciones;

import modelo.Fecha;
import modelo.ModeloFacturaParaVista;
import modelo.ModeloParacontroladorFactura;
import modelo.excepciones.FechaInicialMayorQueFinal;
import modelo.Utiles;
import modelo.cliente.Cliente;
import modelo.factura.Factura;
import modelo.factura.Llamada;
import modelo.factura.PeriodoFacturacion;
import vista.VistaParaModeloFactura;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by user on 27/02/17.
 */
public class ColeccionFacturas implements Serializable, ModeloFacturaParaVista, ModeloParacontroladorFactura{


    private VistaParaModeloFactura vista;
    private HashMap<String,HashMap<Integer,Factura>> facturas;
    private static int contador;
    private boolean primera=true;

    public ColeccionFacturas(){
        facturas=new HashMap<>();
        contador=1;
    }

    public void setVista(VistaParaModeloFactura vista) {
        this.vista = vista;
    }

    @Override
    public Factura emitirFactura(Cliente cliente, Collection llamadas, PeriodoFacturacion periodoFacturacion) throws FechaInicialMayorQueFinal{
        if (contador != 1 && primera==true)
            contador=calculaCodigo();
        int importe=0;
        Collection<Llamada> col=Utiles.entreDosFechas(llamadas,periodoFacturacion.getFechaInicial(),periodoFacturacion.getFechaFinal());
        Iterator<Llamada> it=col.iterator();
        Llamada llamada;
        while(it.hasNext()) {
            llamada=it.next();
            importe += cliente.getTarifa().costeLlamada(llamada);
        }

        Factura aux=new Factura(contador++,cliente.getTarifa(),LocalDateTime.now(),periodoFacturacion,importe);
        if (!facturas.containsKey(cliente.getNIF()))
            facturas.put(cliente.getNIF(),new HashMap<>());
        facturas.get(cliente.getNIF()).put(aux.getCodfac(),aux);
        vista.nuevaFacturaCreada(contador-1);
        primera=false;
        return aux;
    }

    private int calculaCodigo(){
        int max=1;
        for(String dni : facturas.keySet()){
            Set<Integer> cod = facturas.get(dni).keySet();
            for(Integer c : cod){
                if (c>max)
                    max=c;
            }
        }
        return max;
    }

    @Override
    public Factura recuperarDatosFactura(int codigoFactura){
        for (HashMap<Integer,Factura> aux: facturas.values()){
            if (aux.containsKey(codigoFactura))
                return aux.get(codigoFactura);
        }
        return null;
    }

    @Override
    public Collection<Factura> recuperarFacturasCliente(String nif){
        if (facturas.containsKey(nif))
            return facturas.get(nif).values();
        return null;
    }


}
