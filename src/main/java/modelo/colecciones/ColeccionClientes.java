package modelo.colecciones;

import controlador.ModeloClienteParaControladorFactura;
import modelo.ModeloClienteParaVista;
import modelo.ModeloParaControladorCliente;
import modelo.cliente.Cliente;
import modelo.excepciones.NoExisteCliente;
import modelo.factorias.TipoPromocion;
import modelo.tarifa.PromocionDomingos;
import modelo.tarifa.PromocionTardes;
import modelo.tarifa.Tarifa;
import vista.VistaParaModeloCliente;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by user on 26/02/17.
 */
public class ColeccionClientes implements Serializable, ModeloClienteParaVista, ModeloParaControladorCliente, ModeloClienteParaControladorFactura {

    private VistaParaModeloCliente vista;

    private HashMap<String,Cliente> clientes;

    public ColeccionClientes() {
        clientes = new HashMap<String,Cliente>();
    }

    public void setVista(VistaParaModeloCliente vista) {
        this.vista = vista;
    }

    @Override
    public boolean existeCliente(String NIF) {
        if(clientes.containsKey(NIF)){
            return true;
        }
        return false;
    }

    @Override
    public boolean anyadirCliente(Cliente cliente) {
        if (!existeCliente(cliente.getNIF())){
            clientes.put(cliente.getNIF(),cliente);
            vista.modeloModificado();
            return true;
        }
        return false;
    }

    @Override
    public boolean borrarCliente(String NIF) {
        System.out.println(NIF);
        if( clientes.containsKey(NIF)){
            clientes.remove(NIF);
            vista.modeloModificado();
            return true;
        }
        return false;
    }

    @Override
    public void cambiarTarifa(String NIF, TipoPromocion tipoPromocion) {
        if(existeCliente(NIF)){
            Cliente cliente = clientes.get(NIF);
            Tarifa tarifa=clientes.get(NIF).getTarifa();;
            switch(tipoPromocion){
                case TARDES:
                    cliente.setTarifa(new PromocionTardes(tarifa,5));
                    break;
                case DOMINGOS:
                    cliente.setTarifa(new PromocionDomingos(tarifa));
                    break;
            }

        }
        vista.tarifaCambiada();
    }

    @Override
    public Cliente getDatosCliente(String NIF) throws NoExisteCliente{
        if(clientes.containsKey(NIF))
            return clientes.get(NIF);
        else{
            throw new NoExisteCliente("El cliente no existe");
        }
    }

    @Override
    public Collection<Cliente> getListadoClientes() {
        return clientes.values();
    }
}
