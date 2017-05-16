package modelo;

import modelo.cliente.Cliente;
import modelo.excepciones.FechaInicialMayorQueFinal;
import modelo.factura.Factura;
import modelo.factura.PeriodoFacturacion;

import java.util.Collection;

/**
 * Created by sergiojimenez on 16/5/17.
 */
public interface ModeloParacontroladorFactura {
    public Factura emitirFactura(Cliente cliente, Collection llamadas, PeriodoFacturacion periodoFacturacion) throws FechaInicialMayorQueFinal;
}