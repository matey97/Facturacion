package facturacion.factorias;

import facturacion.cliente.Cliente;
import facturacion.cliente.Direccion;
import facturacion.tarifa.Tarifa;

import java.time.LocalDateTime;

/**
 * Created by al341802 on 11/04/17.
 */
public interface FactoriaCliente {

    public Cliente crearClienteParticular(String nombre, String apellidos, String NIF, Direccion direccion, String email, LocalDateTime fecha, Tarifa tarifa);
    public Cliente crearClienteEmpresa(String nombre, String NIF, Direccion direccion, String email, LocalDateTime fecha, Tarifa tarifa);

}
