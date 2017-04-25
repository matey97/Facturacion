package modelo;

import modelo.cliente.Cliente;
import modelo.factura.Factura;

import java.util.Collection;

/**
 * Created by al341802 on 25/04/17.
 */
public interface ModeloClienteParaVista {
    Cliente getDatosCliente(String NIF);
    Collection<Cliente> getListadoClientes();
}
