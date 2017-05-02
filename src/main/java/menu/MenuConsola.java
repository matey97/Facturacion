package menu;

import modelo.Utiles;
import modelo.cliente.Cliente;
import modelo.cliente.Direccion;
import modelo.excepciones.DuracionNoValida;
import modelo.excepciones.ExcepcionClienteSinLlamadas;
import modelo.excepciones.FechaInicialMayorQueFinal;
import modelo.factorias.*;
import modelo.factura.Factura;
import modelo.factura.Llamada;
import modelo.factura.PeriodoFacturacion;
import modelo.tarifa.Tarifa;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by sergiojimenez on 28/4/17.
 */
public class MenuConsola {
    EntradaDatosConsola datosconsola = new EntradaDatosConsola();
    GestionDatos datos = new GestionDatos();
    Scanner sc = new Scanner(System.in);
    int n;

    public void muestraMenu() {
        do

        {


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
                            System.out.print("Introduce 1 si quieres dar de alta a un particular, o 2 si a una empresa: ");
                            m = sc.nextInt();
                            switch (m) {
                                case 1:
                                    if (datos.particulares.anyadirCliente(datosconsola.entradaDatosCliente(m)))
                                        System.out.println("Cliente añadido con exito.");
                                    else
                                        System.out.println("No se ha añadido el cliente.");
                                    break;
                                case 2:
                                    if (datos.empresas.anyadirCliente(datosconsola.entradaDatosCliente(m)))
                                        System.out.println("Cliente añadido con exito.");
                                    else
                                        System.out.println("No se ha añadido el cliente.");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.print("Introduce 1 si quieres borrar a un particular, o 2 si a una empresa: ");
                            m = sc.nextInt();
                            switch (m) {
                                case 1:
                                    if (datos.particulares.borrarCliente(datosconsola.entradaDatosNIF()))
                                        System.out.println("Cliente borrado con exito.");
                                    else
                                        System.out.println("No se pudo borrar el cliente.");
                                    break;
                                case 2:
                                    if (datos.particulares.borrarCliente(datosconsola.entradaDatosNIF()))
                                        System.out.println("Cliente borrado con exito.");
                                    else
                                        System.out.println("No se pudo borrar el cliente.");
                                    break;
                            }
                            break;
                        case 3:
                            System.out.print("Introduce 1 si quieres cambiar la tarifa a un particular, o 2 si a una empresa: ");
                            m = sc.nextInt();
                            switch (m) {
                                case 1:
                                    datosconsola.cambioTarifa(datos.particulares.getDatosCliente(datosconsola.entradaDatosNIF()));
                                    break;
                                case 2:
                                    datosconsola.cambioTarifa(datos.empresas.getDatosCliente(datosconsola.entradaDatosNIF()));
                                    break;
                            }
                            break;
                        case 4:
                            System.out.print("Introduce 1 si quieres obtener los datos de  un particular, o 2 si a una empresa: ");
                            m = sc.nextInt();
                            switch (m) {
                                case 1:
                                    System.out.println(datos.particulares.getDatosCliente(datosconsola.entradaDatosNIF()));
                                    break;
                                case 2:
                                    System.out.println(datos.empresas.getDatosCliente(datosconsola.entradaDatosNIF()));
                                    break;
                            }
                            break;
                        case 5:
                            System.out.println("Listado de particulares:");
                            System.out.println("");
                            for (Cliente cliente : datos.particulares.getListadoClientes()) {
                                System.out.println(cliente);
                                System.out.println("");
                            }
                            System.out.println("Listado de empresas:");
                            System.out.println("");
                            for (Cliente cliente : datos.empresas.getListadoClientes()) {
                                System.out.println(cliente);
                                System.out.println("");
                            }
                            break;
                        case 6:


                            System.out.println("Listado de particulares:");
                            System.out.println("");
                            datosconsola.imprimirLista(Utiles.entreDosFechas(datos.particulares.getListadoClientes(), datosconsola.pedirFechaInical(), datosconsola.pedirFechaFinal()));
                            System.out.println("Listado de empresas:");
                            System.out.println("");
                            datosconsola.imprimirLista(Utiles.entreDosFechas(datos.empresas.getListadoClientes(), datosconsola.pedirFechaInical(), datosconsola.pedirFechaFinal()));

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
                            try {
                                datos.llamadas.darDeAlta(datosconsola.entradaDatosNIF(), datosconsola.pedirDatosLlamada());
                            } catch (ExcepcionClienteSinLlamadas excepcionClienteSinLlamadas) {
                                excepcionClienteSinLlamadas.printStackTrace();
                            }
                            break;
                        case 2:
                            try {
                                datosconsola.imprimirLista(datos.llamadas.listarLlamadas(datosconsola.entradaDatosNIF()));
                            } catch (ExcepcionClienteSinLlamadas e) {
                                e.getMessage();
                            }
                            break;
                        case 3:
                            try {
                                datosconsola.imprimirLista(Utiles.entreDosFechas(datos.llamadas.listarLlamadas(datosconsola.entradaDatosNIF()), datosconsola.pedirFechaInical(), datosconsola.pedirFechaFinal()));
                            } catch (ExcepcionClienteSinLlamadas e) {
                                e.getMessage();
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
                            String nif = datosconsola.entradaDatosNIF();
                            if (datos.empresas.existeCliente(nif)) {
                                Cliente cliente = datos.empresas.getDatosCliente(nif);
                                try {
                                    System.out.println(datos.facturas.emitirFactura(cliente, datos.llamadas.listarLlamadas(nif), new PeriodoFacturacion(datosconsola.pedirFechaInical(), datosconsola.pedirFechaFinal())));
                                } catch (ExcepcionClienteSinLlamadas e) {
                                    e.getMessage();
                                } catch (FechaInicialMayorQueFinal fechaInicialMayorQueFinal) {
                                    fechaInicialMayorQueFinal.getMessage();
                                }
                            } else if (datos.particulares.existeCliente(nif)) {
                                Cliente cliente = datos.particulares.getDatosCliente(nif);
                                try {
                                    System.out.println(datos.facturas.emitirFactura(cliente, datos.llamadas.listarLlamadas(nif), new PeriodoFacturacion(datosconsola.pedirFechaInical(), datosconsola.pedirFechaFinal())));
                                } catch (ExcepcionClienteSinLlamadas e) {
                                    e.getMessage();
                                } catch (FechaInicialMayorQueFinal fechaInicialMayorQueFinal) {
                                    fechaInicialMayorQueFinal.getMessage();
                                }
                            } else {
                                System.out.println("No se ha emitido la factura.");
                            }
                            break;
                        case 2:
                            System.out.println(datos.facturas.recuperarDatosFactura(datosconsola.pedirCodFac()));
                            break;
                        case 3:
                            System.out.println("");
                            for (Factura factura : datos.facturas.recuperarFacturasCliente(datosconsola.entradaDatosNIF())) {
                                System.out.println(factura);
                                System.out.println("");
                            }
                            break;
                        case 4:


                            datosconsola.imprimirLista(Utiles.entreDosFechas(datos.facturas.recuperarFacturasCliente(datosconsola.entradaDatosNIF()), datosconsola.pedirFechaInical(), datosconsola.pedirFechaFinal()));
                            break;
                    }
                    break;
            }
        }
        while (n != 0);
    }
}
/*
    private Cliente entradaDatosCliente(int n) {
        FactoriaCliente factoriaCliente = new FactoriaClientes();
        FactoriaTarifa factoriaTarifa = new FactoriaTarifas();
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce nombre del cliente: ");
        String nombre = sc.nextLine();
        String apellidos = null;
        if (n == 1) {
            System.out.print("Introduce apellidos del cliente: ");
            apellidos = sc.nextLine();
        }

        String NIF = datosconsola.entradaDatosNIF();

        System.out.print("Introduce el codigo postal: ");
        int codPostal = sc.nextInt();

        System.out.print("Introduce la población: ");
        sc.nextLine();
        String poblacion = sc.nextLine();

        System.out.print("Introduce la provincia: ");
        String provincia = sc.nextLine();

        Direccion direccion = new Direccion(codPostal, provincia, poblacion);

        System.out.print("Introduce E-mail del cliente: ");
        String email = sc.nextLine();

        Tarifa tarifa = factoriaTarifa.getTarifaBasica();

        Cliente cliente;

        if (n == 1) {
            cliente = factoriaCliente.crearClienteParticular(nombre, apellidos, NIF, direccion, email, LocalDateTime.now(), tarifa);
        } else {
            cliente = factoriaCliente.crearClienteEmpresa(nombre, NIF, direccion, email, LocalDateTime.now(), tarifa);
        }

        return cliente;
    }


    private  String entradaDatosNIF() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce NIF del cliente: ");
        return sc.next();
    }

    private boolean cambioTarifa(Cliente cliente) {
        FactoriaTarifa factoriaTarifa = new FactoriaTarifas();
        Scanner sc = new Scanner(System.in);
        System.out.println(TipoPromocion.opciones());
        int n = sc.nextInt();
        switch (TipoPromocion.enteroATipo(n)) {
            case TARDES:
                cliente.setTarifa(factoriaTarifa.getTarifaPromocion(cliente.getTarifa(), TipoPromocion.TARDES));
                return true;
            case DOMINGOS:
                cliente.setTarifa(factoriaTarifa.getTarifaPromocion(cliente.getTarifa(), TipoPromocion.DOMINGOS));
                return true;
        }
        return false;
    }


    private Llamada pedirDatosLlamada() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el telefono: ");
        int telefono = sc.nextInt();
        System.out.print("Introduce la duración: ");
        int duracion = sc.nextInt();
        LocalDateTime fecha = LocalDateTime.now();
        Llamada llamada = null;
        try {
            llamada = new Llamada(telefono, fecha, duracion);
        } catch (DuracionNoValida duracionNoValida) {
            duracionNoValida.getMessage();
        }
        return llamada;

    }

    private void imprimirLista(Collection col) {
        Iterator lista = col.iterator();
        while (lista.hasNext()) {
            System.out.println(lista.next().toString());
            System.out.println("");
        }

    }

    private LocalDateTime pedirFechaInical() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce año en numero de la fecha de inicio: ");
        int año = sc.nextInt();

        System.out.print("Introduce mes en numero de la fecha de inicio: ");
        int mes = sc.nextInt();

        System.out.print("Introduce dia en numero de la fecha de inicio: ");
        int dia = sc.nextInt();
        return LocalDateTime.of(año, mes, dia, 0, 0);
    }

    private LocalDateTime pedirFechaFinal() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce año en numero de la fecha final: ");
        int año2 = sc.nextInt();

        System.out.print("Introduce mes en numero de la fecha final: ");
        int mes2 = sc.nextInt();

        System.out.print("Introduce dia en numero de la fecha final: ");
        int dia2 = sc.nextInt();
        return LocalDateTime.of(año2, mes2, dia2, 0, 0);
    }


    private int pedirCodFac() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el codigo de factura:");
        return sc.nextInt();
    }*/
