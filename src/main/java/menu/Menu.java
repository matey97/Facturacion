package menu;

import facturacion.Excepciones.DuracionNoValida;
import facturacion.Excepciones.ExcepcionClienteSinLlamadas;
import facturacion.Excepciones.FechaInicialMayorQueFinal;
import facturacion.Excepciones.PrecioTarifaNoValido;
import facturacion.Utiles;
import facturacion.cliente.Cliente;
import facturacion.cliente.Direccion;
import facturacion.cliente.Empresa;
import facturacion.cliente.Particular;
import facturacion.colecciones.*;
import facturacion.factura.Factura;
import facturacion.factura.Llamada;
import facturacion.factura.PeriodoFacturacion;
import facturacion.factura.Tarifa;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by al341802 on 21/02/17.
 */
public class Menu {

    public static void main(String[] args) {
        ColeccionClientes particulares = new ColeccionParticulares();
        ColeccionClientes empresas= new ColeccionEmpresas();
        ColeccionLlamadas llamadas = new ColeccionLlamadas();
        ColeccionFacturas facturas= new ColeccionFacturas();
        try{
            FileInputStream fichParticulares = new FileInputStream("particulares.bin");
            FileInputStream fichEmpresas = new FileInputStream("empresas.bin");
            FileInputStream fichLlamadas = new FileInputStream("llamadas.bin");
            FileInputStream fichFacturas = new FileInputStream("facturas.bin");
            ObjectInputStream objParticulares = new ObjectInputStream(fichParticulares);
            ObjectInputStream objEmpresas = new ObjectInputStream(fichEmpresas);
            ObjectInputStream objLlamadas = new ObjectInputStream(fichLlamadas);
            ObjectInputStream objFacturas = new ObjectInputStream(fichFacturas);
            particulares = (ColeccionClientes) objParticulares.readObject();
            empresas = (ColeccionClientes) objEmpresas.readObject();
            llamadas = (ColeccionLlamadas) objLlamadas.readObject();
            facturas = (ColeccionFacturas) objFacturas.readObject();
            objParticulares.close();
            objEmpresas.close();
            objLlamadas.close();
            objFacturas.close();
        } catch(FileNotFoundException e){
            System.out.println("Error del fichero.");
            System.out.println(e);
        } catch(IOException e){
            System.out.println("Error en ObjectInputStream.");
            System.out.println(e);
        } catch(ClassNotFoundException e){
            System.out.println("Error al recuperar datos del fichero.");
            System.out.println(e);
        }
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("");
            System.out.println("¿Que tipo de gestión quieres realizar?");
            System.out.println("Introduce 0 para --> Salir");
            System.out.println("Introduce 1 para --> Gestión clientes");
            System.out.println("Introduce 2 para --> Gestión llamadas");
            System.out.println("Introduce 3 para --> Gestión facturas");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("");
                    System.out.println("Introduce 1 para --> Dar de alta un cliente");
                    System.out.println("Introduce 2 para --> Borrar un cliente");
                    System.out.println("Introduce 3 para --> Cambiar tarifa de cliente");
                    System.out.println("Introduce 4 para --> Obtener datos de cliente a partir de DNI");
                    System.out.println("Introduce 5 para --> Listado de clientes");
                    System.out.println("Introduce 6 para --> Listado de clientes dados de alta entre dos fechas");
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
                        case 6:
                            System.out.println("Listado de particulares:");
                            System.out.println("");
                            imprimirLista(Utiles.entreDosFechas(particulares.getListadoClientes(),pedirFechaInical(),pedirFechaFinal()));
                            System.out.println("Listado de empresas:");
                            System.out.println("");
                            imprimirLista(Utiles.entreDosFechas(empresas.getListadoClientes(),pedirFechaInical(),pedirFechaFinal()));
                            break;
                    }
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Introduce 1 para --> Dar de alta una llamada");
                    System.out.println("Introduce 2 para --> Listado de llamadas de un cliente");
                    System.out.println("Introduce 3 para --> Listado de llamadas de un cliente realizadas entre dos fechas");
                    n = sc.nextInt();
                    switch (n) {
                        case 1:
                            llamadas.darDeAlta(entradaDatosNIF(),pedirDatosLlamada());
                            break;
                        case 2:
                            try{
                            imprimirLista(llamadas.listarLlamadas(entradaDatosNIF()));
                            }catch(ExcepcionClienteSinLlamadas e) {
                                e.printStackTrace();

                            }
                            break;
                        case 3:
                            try{
                            imprimirLista(Utiles.entreDosFechas(llamadas.listarLlamadas(entradaDatosNIF()),pedirFechaInical(),pedirFechaFinal()));
                            } catch (ExcepcionClienteSinLlamadas e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Introduce 1 para --> Emitir factura para un cliente");
                    System.out.println("Introduce 2 para --> Obtener datos de factura a partir de su codigo");
                    System.out.println("Introduce 3 para --> Obtener facturas de un cliente");
                    System.out.println("Introduce 4 para --> Obtener facturas de un cliente emitidas entre dos fechas");
                    n = sc.nextInt();
                    switch (n) {
                        case 1:
                            String nif = entradaDatosNIF();
                            if (empresas.existeCliente(nif)){
                                Cliente cliente = empresas.getDatosCliente(nif);
                                try {
                                    System.out.println(facturas.emitirFactura(cliente, llamadas.listarLlamadas(nif), new PeriodoFacturacion(pedirFechaInical(),pedirFechaFinal())));
                                }catch(ExcepcionClienteSinLlamadas e) {
                                    e.printStackTrace();
                                }catch (FechaInicialMayorQueFinal fechaInicialMayorQueFinal) {
                                    fechaInicialMayorQueFinal.printStackTrace();
                                }
                            }else
                                if (particulares.existeCliente(nif)) {
                                    Cliente cliente = particulares.getDatosCliente(nif);
                                    try {
                                        System.out.println(facturas.emitirFactura(cliente, llamadas.listarLlamadas(nif), new PeriodoFacturacion(pedirFechaInical(),pedirFechaFinal())));
                                    }catch (ExcepcionClienteSinLlamadas e) {
                                        e.printStackTrace();
                                    }catch (FechaInicialMayorQueFinal fechaInicialMayorQueFinal) {
                                        fechaInicialMayorQueFinal.printStackTrace();
                                    }
                                }else{
                                    System.out.println("No se ha emitido la factura.");
                            }
                            break;
                        case 2:
                            System.out.println(facturas.recuperarDatosFactura(pedirCodFac()));
                            break;
                        case 3:
                            System.out.println("");
                            for (Factura factura : facturas.recuperarFacturasCliente(entradaDatosNIF())){
                                System.out.println(factura);
                                System.out.println("");
                            }
                            break;
                        case 4:
                            imprimirLista(Utiles.entreDosFechas(facturas.recuperarFacturasCliente(entradaDatosNIF()),pedirFechaInical(),pedirFechaFinal()));
                            break;
                    }
                    break;
            }
        }while(n!=0);
        try{
            FileOutputStream fichParticulares = new FileOutputStream("particulares.bin");
            FileOutputStream fichEmpresas = new FileOutputStream("empresas.bin");
            FileOutputStream fichLlamadas = new FileOutputStream("llamadas.bin");
            FileOutputStream fichFacturas = new FileOutputStream("facturas.bin");
            ObjectOutputStream objParticulares = new ObjectOutputStream(fichParticulares);
            ObjectOutputStream objEmpresas = new ObjectOutputStream(fichEmpresas);
            ObjectOutputStream objLlamadas = new ObjectOutputStream(fichLlamadas);
            ObjectOutputStream objFacturas = new ObjectOutputStream(fichFacturas);
            objParticulares.writeObject(particulares);
            objEmpresas.writeObject(empresas);
            objLlamadas.writeObject(llamadas);
            objFacturas.writeObject(facturas);
            objParticulares.close();
            objEmpresas.close();
            objLlamadas.close();
            objFacturas.close();
        }catch (FileNotFoundException e){
            System.out.println("Error al intentar abrir el fichero.");
            System.out.println(e);
        }catch (IOException e){
            System.out.println("Error en ObjectOutputStream");
            System.out.println(e);
        }
    }

    private static Cliente entradaDatosCliente(int n){
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
        Tarifa tarifa =null;
        try{
            tarifa=new Tarifa(sc.nextInt());
        } catch (PrecioTarifaNoValido precioTarifaNoValido) {
            precioTarifaNoValido.printStackTrace();
        }

        sc.nextLine();


        Cliente cliente;

        if (n==1) {
            cliente = new Particular(nombre, apellidos, NIF, direccion, email, LocalDateTime.now(), tarifa);
        }else{
            cliente = new Empresa(nombre,NIF,direccion,email,LocalDateTime.now(),tarifa);
        }

        return cliente;
    }

    private static String entradaDatosNIF(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce NIF del cliente: ");
        return sc.nextLine();
    }

    private static int entradaDatosPrecioMinuto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la nueva tarifa: ");
        return sc.nextInt();
    }

    private static Llamada pedirDatosLlamada() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el telefono: ");
        int telefono = sc.nextInt();
        System.out.println("Introduce la duración: ");
        int duracion = sc.nextInt();
        LocalDateTime fecha = LocalDateTime.now();
        Llamada llamada= null;
        try {
            llamada= new Llamada(telefono, fecha, duracion);
        } catch (DuracionNoValida duracionNoValida) {
            duracionNoValida.printStackTrace();
        }
        return llamada;

    }

    private static void imprimirLista( Collection col){
        Iterator lista = col.iterator();
        while(lista.hasNext()){
            System.out.println(lista.next().toString());
            System.out.println("");
        }

    }

    private static LocalDateTime pedirFechaInical(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce año en numero de la fecha de inicio: ");
        int año = sc.nextInt();

        System.out.println("Introduce mes en numero de la fecha de inicio: ");
        int mes = sc.nextInt();

        System.out.println("Introduce dia en numero de la fecha de inicio: ");
        int dia = sc.nextInt();
        return LocalDateTime.of(año,mes,dia,0,0);
    }

    private static LocalDateTime pedirFechaFinal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce año en numero de la fecha final: ");
        int año2 = sc.nextInt();

        System.out.println("Introduce mes en numero de la fecha final: ");
        int mes2 = sc.nextInt();

        System.out.println("Introduce dia en numero de la fecha final: ");
        int dia2 = sc.nextInt();
        return LocalDateTime.of(año2,mes2,dia2,0,0);
    }


    private static int pedirCodFac(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el codigo de factura:");
        return sc.nextInt();
    }
}
