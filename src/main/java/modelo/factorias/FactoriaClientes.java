package modelo.factorias;

import modelo.cliente.Cliente;
import modelo.cliente.Direccion;
import modelo.cliente.Empresa;
import modelo.cliente.Particular;
import modelo.tarifa.Tarifa;

import java.time.LocalDateTime;

/**
 * Created by al341802 on 11/04/17.
 */
public class FactoriaClientes implements FactoriaCliente {

    @Override
    public Cliente crearClienteParticular(String nombre, String apellidos, String NIF, Direccion direccion, String email,  Tarifa tarifa) {
        Cliente nuevoCliente = new Particular(nombre, apellidos, NIF, direccion, email,  tarifa);
        return nuevoCliente;
    }

    @Override
    public Cliente crearClienteEmpresa(String nombre, String NIF, Direccion direccion, String email, Tarifa tarifa) {
        Cliente nuevoCliente = new Empresa(nombre, NIF, direccion, email, tarifa);
        return nuevoCliente;
    }
}
