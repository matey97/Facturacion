package modelo;

import modelo.factura.Factura;

import java.util.Collection;

/**
 * Created by al341802 on 25/04/17.
 */
public interface ModeloFacturaParaVista {
    Factura recuperarDatosFactura(int codigoFactura);
    Collection<Factura> recuperarFacturasCliente(String nif);
}
