package facturacion.excepciones;

import facturacion.excepciones.FechaInicialMayorQueFinal;
import facturacion.factura.PeriodoFacturacion;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.fail;

/**
 * Created by user on 26/03/17.
 */
public class FechaInicialMayorQueFinalTest {

    public static PeriodoFacturacion periodo;
    public static boolean lanzada;

    @Before
    public void antesDeTest(){
        periodo=null;
        lanzada=false;
    }

    @Test
    public void fechaInicialMayorQueFinalTest(){
        System.out.println("Se debería lanzar una excepción:");
        try{
            periodo=new PeriodoFacturacion(LocalDateTime.of(2017,4,2,0,0),LocalDateTime.of(2017,3,1,0,0));
        }catch(FechaInicialMayorQueFinal e){
            lanzada=true;
            System.out.println(e);
        }
        if (!lanzada)
            fail();
    }

    @Test
    public void fechaInicialNoMayorQueFinalTest(){
        try{
            periodo=new PeriodoFacturacion(LocalDateTime.of(2017,4,2,0,0),LocalDateTime.of(2017,4,2,0,0));
        }catch(FechaInicialMayorQueFinal e){
            lanzada=true;
            System.out.println(e);
        }
        if (lanzada)
            fail();
    }
}
