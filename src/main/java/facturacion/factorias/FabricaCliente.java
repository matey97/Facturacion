package facturacion.factorias;

import facturacion.cliente.Cliente;
import facturacion.cliente.Direccion;
import facturacion.cliente.Empresa;
import facturacion.cliente.Particular;
import facturacion.tarifa.Tarifa;

import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 4/4/17.
 */
public class FabricaCliente implements FactoriaClientes  {


    @Override
    public Cliente crearClienteParticular(String nombre, String apellidos, String NIF, Direccion direccion, String email, LocalDateTime fecha, Tarifa tarifa) {
        Cliente nuevoCliente = new Particular(nombre, apellidos, NIF, direccion, email, fecha, tarifa);
        return nuevoCliente;
    }


    @Override
    public Cliente crearClienteEmpresa(String nombre, String NIF, Direccion direccion, String email, LocalDateTime fecha, Tarifa tarifa) {
        Cliente nuevoCliente = new Empresa(nombre, NIF, direccion, email, fecha, tarifa);
        return nuevoCliente;
    }
}

