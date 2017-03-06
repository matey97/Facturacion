package facturacion.colecciones;

import facturacion.factura.Factura;
import facturacion.factura.Llamada;
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

    @BeforeClass
    public static void init(){
        facturas=new ColeccionFacturas();
        tarifa=new Tarifa(5);
        llamada1=new Llamada(669318017, LocalDateTime.now(),13);
        llamada2=new Llamada(612317002, LocalDateTime.now(),5);
        llamada2=new Llamada(695968097, LocalDateTime.now(),24);
        llamadas.darDeAlta("100",llamada1);
        llamadas.darDeAlta("100",llamada2);
        llamadas.darDeAlta("200",llamada3);
    }

    @AfterClass
    public static void end(){
        facturas=null;
        llamadas=null;
        llamada1=llamada2=llamada3=null;
    }

    @Test
    public void emitirFacturaTest(){
    }

    @Test
    public void recuperarDatosFacturaTest(){
    }

    @Test
    public void recuperarFacturasCliente(){
    }
}
