package controlador;

import modelo.cliente.Cliente;
import modelo.excepciones.NoExisteCliente;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by sergiojimenez on 20/5/17.
 */
public interface ModeloClienteParaControladorFactura {
    Cliente getDatosCliente(String nif) throws NoExisteCliente;
}
