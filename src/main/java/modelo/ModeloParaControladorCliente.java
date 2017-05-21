package modelo;

import modelo.cliente.Cliente;
import modelo.factorias.TipoPromocion;

import java.util.Collection;

/**
 * Created by sergiojimenez on 2/5/17.
 */
public interface ModeloParaControladorCliente {
        boolean anyadirCliente(Cliente cliente);
        boolean borrarCliente(String nif);
        boolean existeCliente(String NIF);
        void cambiarTarifa(String NIF, TipoPromocion tipoPromocion);
}
