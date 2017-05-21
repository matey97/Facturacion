package controlador;

import modelo.cliente.Cliente;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by sergiojimenez on 20/5/17.
 */
public interface ModeloClienteParaControladorFactura {
    Cliente getDatosCliente(String nif);
}
