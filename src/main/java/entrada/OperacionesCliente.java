package entrada;

import facturacion.cliente.Cliente;
import facturacion.cliente.Direccion;
import facturacion.cliente.Empresa;
import facturacion.cliente.Particular;
import facturacion.colecciones.ColeccionClientes;
import facturacion.factura.Tarifa;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Created by al341802 on 28/02/17.
 */
public class OperacionesCliente {

    private String nombre;
    private String apellidos;
    private String NIF;
    private int codPostal;
    private String provincia;
    private String poblacion;
    private Direccion direccion;
    private String email;
    private Tarifa tarifa;
    private Scanner sc;

    public OperacionesCliente() {
        this.sc = new Scanner(System.in);
    }

    public void nuevoCliente(ColeccionClientes clientes, int n){
        System.out.println("Introduce nombre del cliente: ");
        nombre=sc.next();

        if (n==1){
        System.out.println("Introduce apellidos del cliente: ");
        apellidos=sc.next();
        }

        System.out.println("Introduce NIF del cliente: ");
        NIF=sc.next();

        System.out.println("Introduce el codigo postal: ");
        codPostal=sc.nextInt();

        System.out.println("Introduce la población: ");
        poblacion=sc.next();

        System.out.println("Introduce la provincia: ");
        provincia=sc.next();

        direccion=new Direccion(codPostal,provincia,poblacion);

        System.out.println("Introduce E-mail del cliente: ");
        email=sc.next();

        System.out.println("Introduce la tarifa del cliente: ");
        tarifa=new Tarifa(sc.nextInt());

        Cliente cliente;

        if (n==1) {
            cliente = new Particular(nombre, apellidos, NIF, direccion, email, LocalDateTime.now(), tarifa);
        }else{
            cliente = new Empresa(nombre,NIF,direccion,email,LocalDateTime.now(),tarifa);
        }

        if (clientes.añadirCliente(cliente))
            System.out.println("Añadido con exito.");

    }

    public void borrarCliente(ColeccionClientes clientes){
        System.out.println("Introduce NIF del cliente a borrar: ");
        NIF=sc.next();

        if(clientes.borrarCliente(NIF))
            System.out.println("Borrado con exito.");

    }

    public void cambiarTarifa(ColeccionClientes clientes){
        System.out.println("Introduce NIF del cliente para cambiar la tarifa: ");
        NIF=sc.next();
        System.out.println("Introduce la nueva tarifa: ");
        int precio=sc.nextInt();

        if(clientes.cambiarTarifa(NIF,precio))
            System.out.println("Tarifa cambiada con exito.");
    }

    public void obtenerDatos(ColeccionClientes clientes){
        System.out.println("Introduce NIF del cliente: ");
        NIF=sc.next();
        System.out.println(clientes.getDatosCliente(NIF));
    }

    public void obtenerListado(ColeccionClientes clientes){
        for (Cliente cliente : clientes.getListadoClientes()){
            System.out.println(cliente);
            System.out.println("");
        }
    }
}
