package facturacion.colecciones;

import facturacion.excepciones.*;
import facturacion.cliente.Cliente;
import facturacion.cliente.Direccion;
import facturacion.cliente.Particular;
import facturacion.factura.Factura;
import facturacion.factura.Llamada;
import facturacion.factura.PeriodoFacturacion;
import facturacion.tarifa.Tarifa;
import facturacion.tarifa.TarifaBasica;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by user on 1/03/17.
 */
public class ColeccionFacturasTest {

    private static ColeccionFacturas facturas;
    private static ColeccionLlamadas llamadas;
    private static Llamada llamada1,llamada2,llamada3, llamada4;
    private static Tarifa tarifa;
    private static Cliente cliente;
    private static PeriodoFacturacion pfact;

    @BeforeClass
    public static void init() throws DuracionNoValida, FechaInicialMayorQueFinal{
        llamadas=new ColeccionLlamadas();
        tarifa=new TarifaBasica();
        cliente=new Particular("Miguel","Matey Sanz","73402320M",new Direccion(12600,"Castellon","La Vall d'Uixó"),"al341802@uji.es", LocalDateTime.now(),tarifa);
        llamada1=new Llamada(669318017, LocalDateTime.now(),13);
        llamada2=new Llamada(612317002, LocalDateTime.now(),5);
        llamada3=new Llamada(695968097, LocalDateTime.now(),10);
        llamada4=new Llamada(695968097, LocalDateTime.of(2021,1,1,0,0),20);
        llamadas.darDeAlta("73402320M",llamada1);
        llamadas.darDeAlta("73402320M",llamada2);
        llamadas.darDeAlta("73402320M",llamada3);
        pfact=new PeriodoFacturacion(LocalDateTime.of(2000,1,1,0,0),LocalDateTime.of(2020,1,1,0,0));
    }

    @AfterClass
    public static void end(){
        facturas=null;
        llamadas=null;
        llamada1=llamada2=llamada3=null;
        pfact=null;
        cliente=null;
        tarifa=null;
    }

    @Before
    public void antesDeTest(){
        facturas=new ColeccionFacturas();
    }

    @Test
    public void emitirFacturaTest() throws ExcepcionClienteSinLlamadas, FechaInicialMayorQueFinal{
        Factura factura = facturas.emitirFactura(cliente, llamadas.listarLlamadas("73402320M"), pfact);
        assertEquals(factura.getImporte(), 420);
        System.out.println(factura);
        llamadas.darDeAlta("73402320M", llamada4);
        factura = facturas.emitirFactura(cliente, llamadas.listarLlamadas("73402320M"), pfact);
        assertEquals(factura.getImporte(), 420);
        pfact = new PeriodoFacturacion(LocalDateTime.of(2000, 1, 1, 0, 0), LocalDateTime.of(2022, 1, 1, 0, 0));
        factura = facturas.emitirFactura(cliente, llamadas.listarLlamadas("73402320M"), pfact);
        assertEquals(factura.getImporte(), 720);
        System.out.println(factura);
    }


}
