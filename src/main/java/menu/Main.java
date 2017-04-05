package menu;

import enums.*;

import java.util.Scanner;

/**
 * Created by sergiojimenez on 4/4/17.
 */
public class Main {
    private GestionDatos datos = new GestionDatos();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().arranque();


    }

    private Main() {

    }

    private void arranque() {

        cargar();
        System.out.println(MenuEnumPrincipal.mostrarMenu());
        MenuEnumPrincipal n = MenuEnumPrincipal.getOpcion(sc.nextInt());
        switchOpciones(n);


        // guardar();

    }

    private void cargar() {
        datos.cargarDatos();
    }

    private void guardar() {
        datos.guardarDatos();
    }

    //______________________________________________________
    private void arranqueClientes() {
        System.out.println(MenuEnumClientes.mostrarMenu());
        MenuEnumClientes n = MenuEnumClientes.getOpcion(sc.nextInt());
        switchOpcionesClientes(n);

    }

    /* private void arranqueLlamadas(){
         System.out.println(MenuEnumLlamadas.mostrarMenu());
         MenuEnumPrincipal n = MenuEnumPrincipal.getOpcion(sc.nextInt());
         switchOpciones(n);

     }
     private void arranqueTarifas(){
         System.out.println(MenuEnumFacturas.mostrarMenu());
         MenuEnumPrincipal n = MenuEnumPrincipal.getOpcion(sc.nextInt());
         switchOpciones(n);

     }*/
    //_____________________________________________________________
    //metodo muestra sub menu clientes empresa particular al añadi
    private void arranqueClientesPE() {
        System.out.println(MenuEnumClientesPE.mostrarMenu());
        MenuEnumPrincipal n = MenuEnumPrincipal.getOpcion(sc.nextInt());
        //switchOpciones(n);

    }

    private void switchOpciones(MenuEnumPrincipal opcion) {
        switch (opcion) {
            case GESTION_CLIENTES:
                arranqueClientes();


            case GESTION_FACTURAS:
                System.out.println(MenuEnumFacturas.mostrarMenu());

            case GESTION_LLAMADAS:
                System.out.println(MenuEnumLlamadas.mostrarMenu());
        }


    }

    private void switchOpcionesClientes(MenuEnumClientes opcion) {
        switch (opcion) {
            case DAR_DE_ALTA_UN_CLIENTE:
                arranqueClientesPE();


            case BORRAR_UN_CLIENTE:

                //LLamada a borrar Cliente

            case CAMBIAR_TARIFA_CLIENTE:
                //llamada a cambiar tarifa

            case OBTENER_DATOS_CLIENTE:
                //obtener datos cliente

            case LISTADO_CLIENTES:
                //listado cliente
            case LISTADO_CLIENTES_DADOS_DEALTA_ENTRE_DOS_FECHAS:
                //clientes entre fechas

        }

    }

    private void switchOpcionesClientesPE(MenuEnumClientesPE opcion) {
        switch (opcion) {
            case PARTICULAR:
                // LLAMADA para Crear un cliente particular
            case EMPRESA:
                //llamada a crear empresa
        }
    }

    private void switchOpcionesLlamadas(MenuEnumLlamadas opcion) {
        switch (opcion) {
            case ALTA_LLAMADA:
                //alta Llamada


            case LISTADO_LLAMADAS_CLIENTE:

                //Listado llamadas

            case LISTADO_LLAMADAS_CLIENTE_ENTRE_FECHAS:
                //llistado llamadas fechas


        }
    }

    private void switchOpcionesFacturas(MenuEnumFacturas opcion) {
        switch (opcion) {
            case EMITIR_FACTURA_CLIENTE:
                arranqueClientesPE();


            case OBTENER_DATOS_FACTURA_DESDE_CODIGO:

                //LLamada a factura desdecodigo

            case OBTENER_FACTURAS_CLIENTE:
                //facturas cliente

            case OBTENER_FACTURAS_CLIENTE_EMITIDAS_ENTRE_DOS_FECHAS:

                //obtener facturas entredos fechas


        }


    }
}