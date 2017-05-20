package modelo;

import modelo.cliente.Cliente;
import modelo.factorias.TipoPromocion;

import java.util.Collection;

/**
 * Created by sergiojimenez on 2/5/17.
 */
public interface ModeloParaControladorCliente {
        public boolean anyadirCliente(Cliente cliente);
        public boolean borrarCliente(String nif);
        public boolean existeCliente(String NIF);
        public void cambiarTarifa(String NIF, TipoPromocion tipoPromocion);
}
