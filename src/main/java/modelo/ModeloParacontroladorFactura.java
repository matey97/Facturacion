package modelo;

import modelo.cliente.Cliente;
import modelo.excepciones.ExcepcionClienteSinLlamadas;
import modelo.excepciones.FechaInicialMayorQueFinal;
import modelo.factura.Factura;
import modelo.factura.Llamada;
import modelo.factura.PeriodoFacturacion;

import java.util.Collection;

/**
 * Created by sergiojimenez on 16/5/17.
 */
public interface ModeloParacontroladorFactura {
    Factura emitirFactura(Cliente cliente, Collection llamadas, PeriodoFacturacion periodoFacturacion) throws FechaInicialMayorQueFinal,ExcepcionClienteSinLlamadas;




}