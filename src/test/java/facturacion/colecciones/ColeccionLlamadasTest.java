package facturacion.colecciones;

import facturacion.Excepciones.ExcepcionClienteSinLlamadas;
import facturacion.factura.Llamada;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by user on 1/03/17.
 */
public class ColeccionLlamadasTest {

    private static ColeccionLlamadas llamadas;
    private static Llamada llamada1,llamada2,llamada3;

    @BeforeClass
    public static void init(){
        llamadas=new ColeccionLlamadas();
        llamada1=new Llamada(669318017, LocalDateTime.now(),13);
        llamada2=new Llamada(612317002, LocalDateTime.now(),5);
        llamada2=new Llamada(695968097, LocalDateTime.now(),24);
    }

    @AfterClass
    public static void end(){
        llamadas=null;
        llamada1=llamada2=llamada3=null;
    }

    @Test
    public void listarLlamadasTest() throws ExcepcionClienteSinLlamadas {
        llamadas.darDeAlta("100",llamada1);
        llamadas.darDeAlta("100",llamada2);
        llamadas.darDeAlta("200",llamada3);

        assertTrue(llamadas.listarLlamadas("100").contains(llamada1));
        assertTrue(llamadas.listarLlamadas("200").contains(llamada3));
        assertTrue(!llamadas.listarLlamadas("200").contains(llamada2));

    }
}
