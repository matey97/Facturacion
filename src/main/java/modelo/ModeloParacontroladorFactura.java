package modelo;

import modelo.cliente.Cliente;
import modelo.excepciones.FechaInicialMayorQueFinal;
import modelo.factura.Factura;
import modelo.factura.Llamada;
import modelo.factura.PeriodoFacturacion;

import java.util.Collection;

/**
 * Created by sergiojimenez on 16/5/17.
 */
public interface ModeloParacontroladorFactura {
    public Factura emitirFactura(Cliente cliente, Collection llamadas, PeriodoFacturacion periodoFacturacion) throws FechaInicialMayorQueFinal;
    public Cliente getDatoscliente(String nif);
    public Collection<Llamada> listarLlamadas(String nif);
    /*public void mostrarDatosfactura();
    public Factura recuperarDatosFactura(int codigoFactura);
    public Collection<Factura> recuperarFacturasCliente(String nif);*/



}