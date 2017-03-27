package facturacion.excepciones;

import facturacion.Excepciones.DuracionNoValida;
import facturacion.factura.Llamada;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.fail;

/**
 * Created by user on 26/03/17.
 */
public class DuracionNoValidaTest {

    public static Llamada llamada;
    public static boolean lanzada;

    @Before
    public void antesDeTest(){
        llamada=null;
        lanzada=false;
    }

    @Test
    public void duracionNoValidaTest(){
        System.out.println("Se debería lanzar una excepción:");
        try{
            llamada=new Llamada(695968097, LocalDateTime.now(),-5);
        }catch(DuracionNoValida e){
            lanzada=true;
            System.out.println(e);
        }
        if (!lanzada)
            fail();
    }

    @Test
    public void duracionValidaTest(){
        try{
            llamada=new Llamada(695968097, LocalDateTime.now(),5);
        }catch(DuracionNoValida e){
            lanzada=true;
            System.out.println(e);
        }
        if(lanzada)
            fail();
    }
}
