package menu;



        import facturacion.excepciones.*;
        import facturacion.Utiles;
        import facturacion.cliente.Cliente;
        import facturacion.cliente.Direccion;
        import facturacion.cliente.Empresa;
        import facturacion.cliente.Particular;
        import facturacion.colecciones.*;
        import facturacion.factorias.FabricaCliente;
        import facturacion.factorias.FactoriaTarifas;
        import facturacion.factura.Factura;
        import facturacion.factura.Llamada;
        import facturacion.factura.PeriodoFacturacion;
        import facturacion.tarifa.PromocionDomingos;
        import facturacion.tarifa.PromocionTardes;
        import facturacion.tarifa.Tarifa;
        import facturacion.tarifa.TarifaBasica;

        import java.io.*;
        import java.time.LocalDateTime;
        import java.util.*;

/**
 * Created by al341802 on 21/02/17.
 */


        import java.util.Scanner;

/**
 * Created by sergiojimenez on 4/4/17.
 */



import enums.*;
import facturacion.cliente.Cliente;

import java.util.Scanner;

import static enums.MenuEnumClientesPE.EMPRESA;
import static enums.MenuEnumClientesPE.PARTICULAR;
import static enums.MenuEnumPrincipal.GESTION_CLIENTES;
import static enums.MenuEnumPrincipal.GESTION_FACTURAS;
import static enums.MenuEnumPrincipal.GESTION_LLAMADAS;

/**
 * Created by sergiojimenez on 5/4/17.
 */


// Nos falta opción salir y guardar.
public class MenuEnum {

//GestionDatos datos= new GestionDatos();

    Scanner sc = new Scanner(System.in);
    EntradaDatosConsola consola = new EntradaDatosConsola();
    GestionDatos datos = new GestionDatos();
    FabricaCliente fabricaclientes = new FabricaCliente();
    FactoriaTarifas tarifa = new FactoriaTarifas();



    public void arranque() {


        //cargar();
        System.out.println(MenuEnumPrincipal.mostrarMenu());
        MenuEnumPrincipal n = MenuEnumPrincipal.getOpcion(sc.nextInt());
        switchOpciones(n);


        // guardar();

    }

  /* Innecesario, desacople de menu del sistema de
  gestion de estructuras de datos.
    public void cargar() {
        datos.cargarDatos();
    }

     public void guardar() {
        datos.guardarDatos();
    }*/

    //______________________________________________________
    private void arranqueClientes() {
        System.out.println(MenuEnumClientes.mostrarMenu());
        MenuEnumClientes n = MenuEnumClientes.getOpcion(sc.nextInt());
        switchOpcionesClientes(n);

    }


 private void arranqueLlamadas(){
         System.out.println(MenuEnumLlamadas.mostrarMenu());
         MenuEnumLlamadas n = MenuEnumLlamadas.getOpcion(sc.nextInt());
         switchOpcionesLlamadas(n);

     }
     private void arranqueFacturas(){
         System.out.println(MenuEnumFacturas.mostrarMenu());
         MenuEnumFacturas n = MenuEnumFacturas.getOpcion(sc.nextInt());
         switchOpcionesFacturas(n);

     }

    //_____________________________________________________________
    //metodo muestra sub menu clientes empresa particular al añadi
    private String arranqueClientesPE() {
        System.out.println(MenuEnumClientesPE.mostrarMenu());
        MenuEnumClientesPE n = MenuEnumClientesPE.getOpcion(sc.nextInt());
        return switchOpcionesClientesPE(n);

    }

    private void switchOpciones(MenuEnumPrincipal opcion) {
        switch (opcion) {
            case GESTION_CLIENTES:
                arranqueClientes();
                break;


            case GESTION_FACTURAS:
                System.out.println(MenuEnumFacturas.mostrarMenu());
                break;

            case GESTION_LLAMADAS:
                System.out.println(MenuEnumLlamadas.mostrarMenu());
                break;
        }


    }

    private void switchOpcionesClientes(MenuEnumClientes opcion) {
        switch (opcion) {
            case DAR_DE_ALTA_UN_CLIENTE:
                String tipo = arranqueClientesPE();
                if (tipo.equals("particular") &&
                    datos.particulares.anyadirCliente(consola.entradaDatosCliente(1))){
                    System.out.println("Cliente añadido con exito.");
                    break;
                }
                else if (tipo.equals("empresa") &&
                    datos.empresas.anyadirCliente(consola.entradaDatosCliente(0))){
                    System.out.println("Cliente añadido con exito.");
                    break;
                }
                else
                    System.out.println("No se ha añadido el cliente.");

                break;


            case BORRAR_UN_CLIENTE:
                String pe = arranqueClientesPE();
                if(pe.equals("particular")&&
                        datos.particulares.borrarCliente(consola.entradaDatosNIF())) {
                    System.out.println("Cliente Particular borrado con exito.");
                }
                else if (pe.equals("empresa") && datos.empresas.borrarCliente(consola.entradaDatosNIF())){
                    System.out.println("Cliente Empresa borrada con exito.");
                }
                else
                    System.out.println("No se ha Borado el cliente.");

                break;



                //LLamada a borrar Cliente


            case CAMBIAR_TARIFA_CLIENTE:
                arranqueClientesPE();
                //llamada a cambiar tarifa
                //Cliente cliente = new Cliente();
                //consola.cambioTarifa(cliente.getdnif);
                break;

            case OBTENER_DATOS_CLIENTE:
                arranqueClientesPE();
                //obtener datos cliente
                break;


            case LISTADO_CLIENTES:
                //listado cliente
            case LISTADO_CLIENTES_DADOS_DEALTA_ENTRE_DOS_FECHAS:
                //clientes entre fechas

        }

    }

    private String switchOpcionesClientesPE(MenuEnumClientesPE opcion) {
        switch (opcion) {
            case PARTICULAR:
                // LLAMADA para Crear un cliente particular

                String p= "particular";
                return p ;
                
            case EMPRESA:
                //llamada a crear empresa
                String e = "empresa";
                return e ;
        }
        return null;
    }

    private void switchOpcionesLlamadas(MenuEnumLlamadas opcion) {
        switch (opcion) {
            case ALTA_LLAMADA:
                //alta Llamada
                break;


            case LISTADO_LLAMADAS_CLIENTE:

                //Listado llamadas
                break;

            case LISTADO_LLAMADAS_CLIENTE_ENTRE_FECHAS:
                //llistado llamadas fechas
                break;


        }
    }

    private void switchOpcionesFacturas(MenuEnumFacturas opcion) {
        switch (opcion) {
            case EMITIR_FACTURA_CLIENTE:
                arranqueClientesPE();
                break;


            case OBTENER_DATOS_FACTURA_DESDE_CODIGO:

                //LLamada a factura desdecodigo
                break;

            case OBTENER_FACTURAS_CLIENTE:
                //facturas cliente
                break;

            case OBTENER_FACTURAS_CLIENTE_EMITIDAS_ENTRE_DOS_FECHAS:

                //obtener facturas entredos fechas
                break;


        }


    }

}

