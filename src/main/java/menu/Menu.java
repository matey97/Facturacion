package menu;

import facturacion.cliente.Cliente;
import facturacion.cliente.Direccion;
import facturacion.cliente.Empresa;
import facturacion.cliente.Particular;
import facturacion.colecciones.ColeccionClientes;
import facturacion.colecciones.ColeccionEmpresas;
import facturacion.colecciones.ColeccionLlamadas;
import facturacion.colecciones.ColeccionParticulares;
import facturacion.factura.Llamada;
import facturacion.factura.Tarifa;

import java.time.LocalDateTime;
import java.util.ListIterator;
import java.util.Scanner;
/**
 * Created by al341802 on 21/02/17.
 */
public class Menu {

    public static void main(String[] args) {
        ColeccionClientes particulares = new ColeccionParticulares();
        ColeccionClientes empresas= new ColeccionEmpresas();
        ColeccionLlamadas llamadas = new ColeccionLlamadas();
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("¿Que tipo de gestión quieres realizar?");
            System.out.println("Introduce 0 para --> Salir");
            System.out.println("Introduce 1 para --> Gestión clientes");
            System.out.println("Introduce 2 para --> Gestión llamadas");
            System.out.println("Introduce 3 para --> Gestión facturas");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Introduce 1 para --> Dar de alta un cliente");
                    System.out.println("Introduce 2 para --> Borrar un cliente");
                    System.out.println("Introduce 3 para --> Cambiar tarifa de cliente");
                    System.out.println("Introduce 4 para --> Obtener datos de cliente a partir de DNI");
                    System.out.println("Introduce 5 para --> Listado de clientes");
                    n = sc.nextInt();
                    int m;
                    switch (n) {
                        case 1:
                            System.out.println("Introduce 1 si quieres dar de alta a un particular, o 2 si a una empresa");
                            m = sc.nextInt();
                            switch (m) {
                                case 1:
                                    if(particulares.añadirCliente(entradaDatosCliente(m)))
                                        System.out.println("Cliente añadido con exito.");
                                    else
                                        System.out.println("No se ha añadido el cliente.");
                                    break;
                                case 2:
                                    if(empresas.añadirCliente(entradaDatosCliente(m)))
                                        System.out.println("Cliente añadido con exito.");
                                    else
                                        System.out.println("No se ha añadido el cliente.");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Introduce 1 si quieres borrar a un particular, o 2 si a una empresa");
                            m = sc.nextInt();
                            switch (m) {
                                case 1:
                                    if(particulares.borrarCliente(entradaDatosNIF()))
                                        System.out.println("Cliente borrado con exito.");
                                    else
                                        System.out.println("No se pudo borrar el cliente.");
                                    break;
                                case 2:
                                    if(particulares.borrarCliente(entradaDatosNIF()))
                                        System.out.println("Cliente borrado con exito.");
                                    else
                                        System.out.println("No se pudo borrar el cliente.");
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("Introduce 1 si quieres cambiar la tarifa a un particular, o 2 si a una empresa");
                            m = sc.nextInt();
                            switch (m) {
                                case 1:
                                    if(particulares.cambiarTarifa(entradaDatosNIF(),entradaDatosPrecioMinuto()))
                                        System.out.println("Tarifa actualizada con exito.");
                                    else
                                        System.out.println("No se pudo acutalizar la tarifa.");
                                    break;
                                case 2:
                                    if(empresas.cambiarTarifa(entradaDatosNIF(),entradaDatosPrecioMinuto()))
                                        System.out.println("Tarifa actualizada con exito.");
                                    else
                                        System.out.println("No se pudo acutalizar la tarifa.");
                                    break;
                            }
                            break;
                        case 4:
                            System.out.println("Introduce 1 si quieres obtener los datos de  un particular, o 2 si a una empresa");
                            m = sc.nextInt();
                            switch (m) {
                                case 1:
                                    System.out.println(particulares.getDatosCliente(entradaDatosNIF()));
                                    break;
                                case 2:
                                    System.out.println(empresas.getDatosCliente(entradaDatosNIF()));
                                    break;
                            }
                            break;
                        case 5:
                            System.out.println("Listado de particulares:");
                            System.out.println("");
                            for (Cliente cliente : particulares.getListadoClientes()){
                                System.out.println(cliente);
                                System.out.println("");
                            }
                            System.out.println("Listado de empresas:");
                            System.out.println("");
                            for (Cliente cliente : empresas.getListadoClientes()){
                                System.out.println(cliente);
                                System.out.println("");
                            }
                            break;
                    }
                    break;
                case 2:
                    //OperacionesLlamadas opLlamada = new OperacionesLlamadas();
                    System.out.println("Introduce 1 para --> Dar de alta una llamada");
                    System.out.println("Introduce 2 para --> Listado de llamadas de un cliente");
                    n = sc.nextInt();
                    switch (n) {
                        case 1:
                            pedirDatosLlamada();
                            break;
                        case 2:
                            listadoLlamadascliente();
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Introduce 1 para --> Emitir factura para un cliente");
                    System.out.println("Introduce 2 para --> Obtener datos de factura a partir de su codigo");
                    System.out.println("Introduce 3 para --> Obtener facturas de un cliente");
                    n = sc.nextInt();
                    switch (n) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;


            }
        }while(n!=0);

    }

    private static Cliente entradaDatosCliente(int n){  //Pide por teclado los datos de un Cliente
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre del cliente: ");
        String nombre=sc.nextLine();
        String apellidos=null;
        if (n==1){
            System.out.println("Introduce apellidos del cliente: ");
            apellidos=sc.nextLine();
        }

        String NIF=entradaDatosNIF();

        System.out.println("Introduce el codigo postal: ");
        int codPostal=sc.nextInt();

        System.out.println("Introduce la población: ");
        sc.nextLine();
        String poblacion=sc.nextLine();

        System.out.println("Introduce la provincia: ");
        String provincia=sc.nextLine();

        Direccion direccion=new Direccion(codPostal,provincia,poblacion);

        System.out.println("Introduce E-mail del cliente: ");
        String email=sc.nextLine();

        System.out.println("Introduce la tarifa del cliente: ");
        Tarifa tarifa=new Tarifa(sc.nextInt());

        sc.nextLine();


        Cliente cliente;

        if (n==1) {
            cliente = new Particular(nombre, apellidos, NIF, direccion, email, LocalDateTime.now(), tarifa);
        }else{
            cliente = new Empresa(nombre,NIF,direccion,email,LocalDateTime.now(),tarifa);
        }

        return cliente;
    }

    private static String entradaDatosNIF(){ //Pide por teclado un NIF
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce NIF del cliente: ");
        return sc.nextLine();
    }

    private static int entradaDatosPrecioMinuto(){ //Pide por teclado un precioPorMinuto
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la nueva tarifa: ");
        return sc.nextInt();
    }

    private static void pedirDatosLlamada() {
        /*Scanner sc = new Scanner(System.in);
        System.out.println("introduce NIF del cliente:  ");
        String nif = sc.next();*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el telefono: ");
        int telefono = sc.nextInt();
        System.out.println("Introduce la duración: ");
        int duracion = sc.nextInt();
        LocalDateTime fecha = LocalDateTime.now();
        Llamada nuevaLlamada = new Llamada(telefono, fecha, duracion);
        llamadas.darDeAlta(entradaDatosNIF(),nuevaLlamada);// por que no me deja utilizar llamadas.darDeAlta(nif,llamada)
                                                    //si la coleccion esta declarada e inicializada.

    }


    private static  void listadoLlamadascliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el NIF del cliente:  ");
        String nif = sc.next();
        ColeccionLlamadas llamadasCliente = new ColeccionLlamadas();
        ListIterator lista= llamadas.listarLlamadas(nif).listIterator();
        while (lista.hasNext()) {
            System.out.println(lista.next().toString());
        }

    }

}
