package modelo.factorias;

import modelo.cliente.Cliente;
import modelo.cliente.Direccion;
import modelo.tarifa.Tarifa;

import java.time.LocalDateTime;

/**
 * Created by al341802 on 11/04/17.
 */
public interface FactoriaCliente {

    public Cliente crearClienteParticular(String nombre, String apellidos, String NIF, Direccion direccion, String email, LocalDateTime fecha, Tarifa tarifa);
    public Cliente crearClienteEmpresa(String nombre, String NIF, Direccion direccion, String email, LocalDateTime fecha, Tarifa tarifa);

}
