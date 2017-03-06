package facturacion.colecciones;

import facturacion.cliente.Cliente;
import facturacion.cliente.Direccion;
import facturacion.cliente.Particular;
import facturacion.factura.Factura;
import facturacion.factura.Llamada;
import facturacion.factura.PeriodoFacturacion;
import facturacion.factura.Tarifa;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * Created by user on 1/03/17.
 */
public class ColeccionFacturasTest {

    private static ColeccionFacturas facturas;
    private static ColeccionLlamadas llamadas;
    private static Llamada llamada1,llamada2,llamada3;
    private static Tarifa tarifa;
    private static Cliente cliente;
    private static PeriodoFacturacion pfact;

    @BeforeClass
    public static void init(){
        facturas=new ColeccionFacturas();
        llamadas=new ColeccionLlamadas();
        tarifa=new Tarifa(5);
        cliente=new Particular("Miguel","Matey Sanz","73402320M",new Direccion(12600,"Castellon","La Vall d'Uixó"),"al341802@uji.es", LocalDateTime.now(),new Tarifa(5));
        llamada1=new Llamada(669318017, LocalDateTime.now(),13);
        llamada2=new Llamada(612317002, LocalDateTime.now(),5);
        llamada2=new Llamada(695968097, LocalDateTime.now(),24);
        llamadas.darDeAlta("73402320M",llamada1);
        llamadas.darDeAlta("73402320M",llamada2);
        llamadas.darDeAlta("73402320M",llamada3);
        pfact=new PeriodoFacturacion(LocalDateTime.MIN,LocalDateTime.MAX);
    }

    @AfterClass
    public static void end(){
        facturas=null;
        llamadas=null;
        llamada1=llamada2=llamada3=null;
    }

    @Test
    public void emitirFacturaTest(){
        Factura factura=facturas.emitirFactura(cliente,llamadas.listarLlamadas("73402320M"),pfact);
        System.out.println(factura);
    }

    @Test
    public void recuperarDatosFacturaTest(){

    }

    @Test
    public void recuperarFacturasCliente(){
    }
}
