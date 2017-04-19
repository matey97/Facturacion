package menu;

import facturacion.cliente.Cliente;
import facturacion.cliente.Direccion;
import facturacion.cliente.Empresa;
import facturacion.cliente.Particular;
import facturacion.excepciones.DuracionNoValida;
import facturacion.factura.Llamada;
import facturacion.tarifa.PromocionDomingos;
import facturacion.tarifa.PromocionTardes;
import facturacion.tarifa.Tarifa;
import facturacion.tarifa.TarifaBasica;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by sergiojimenez on 15/4/17.
 */
public class EntradaDatosConsola {


    public Cliente entradaDatosCliente(int n){
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

        Tarifa tarifa = new TarifaBasica();

        Cliente cliente;

        if (n==1) {
            cliente = new Particular(nombre, apellidos, NIF, direccion, email, LocalDateTime.now(), tarifa);
        }else{
            cliente = new Empresa(nombre,NIF,direccion,email,LocalDateTime.now(),tarifa);
        }

        return cliente;
    }


    public String entradaDatosNIF(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce NIF del cliente: ");
        return sc.nextLine();
    }

    public boolean cambioTarifa(Cliente cliente){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce 1 para --> Tarifa reducida de tardes.");
        System.out.println("Introduce 2 para --> Tarifa domingos gratis.");
        int n=sc.nextInt();
        if(n==1) {
            cliente.setTarifa(new PromocionTardes(cliente.getTarifa(), 5));
            return true;
        }else if(n==2){
            cliente.setTarifa(new PromocionDomingos(cliente.getTarifa()));
            return true;
        }
        return false;
    }


    public Llamada pedirDatosLlamada() {

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
            duracionNoValida.getMessage();
        }
        return llamada;

    }

    public void imprimirLista( Collection col){
        Iterator lista = col.iterator();
        while(lista.hasNext()){
            System.out.println(lista.next().toString());
            System.out.println("");
        }

    }

    public LocalDateTime pedirFechaInical(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce año en numero de la fecha de inicio: ");
        int año = sc.nextInt();

        System.out.println("Introduce mes en numero de la fecha de inicio: ");
        int mes = sc.nextInt();

        System.out.println("Introduce dia en numero de la fecha de inicio: ");
        int dia = sc.nextInt();
        return LocalDateTime.of(año,mes,dia,0,0);
    }

    public LocalDateTime pedirFechaFinal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce año en numero de la fecha final: ");
        int año2 = sc.nextInt();

        System.out.println("Introduce mes en numero de la fecha final: ");
        int mes2 = sc.nextInt();

        System.out.println("Introduce dia en numero de la fecha final: ");
        int dia2 = sc.nextInt();
        return LocalDateTime.of(año2,mes2,dia2,0,0);
    }


    public int pedirCodFac(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el codigo de factura:");
        return sc.nextInt();
    }
}

