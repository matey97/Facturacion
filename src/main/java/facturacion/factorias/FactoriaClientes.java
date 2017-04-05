package facturacion.factorias;

import facturacion.cliente.Cliente;
import facturacion.cliente.Direccion;
import facturacion.tarifa.Tarifa;
import nombres.NIF;

import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 4/4/17.
 */
public interface FactoriaClientes {
    public Cliente crearClienteParticular(String nombre, String apellidos, String NIF, Direccion direccion, String email, LocalDateTime fecha, Tarifa tarifa);
    public Cliente crearClienteEmpresa(String nombre, String NIF, Direccion direccion, String email, LocalDateTime fecha, Tarifa tarifa);

}
