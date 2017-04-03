package facturacion.tarifa;

import facturacion.excepciones.DuracionNoValida;
import facturacion.factura.Llamada;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by user on 3/04/17.
 */
public class TarifasTest {

    private static Tarifa tarifa;

    @BeforeClass
    public static void init(){
        tarifa=new TarifaBasica();
    }

    @Test
    public void costeLLamadaTest() throws DuracionNoValida{
        Llamada llamadaNormal = new Llamada(695968097, LocalDateTime.of(2017,4,3,12,20),5);
        Llamada llamadaTarde = new Llamada(695968097, LocalDateTime.of(2017,4,3,18,30),8);
        Llamada llamadaDomingo = new Llamada(695968097, LocalDateTime.of(2017,4,2,12,46),4);

        assertThat(tarifa.costeLlamada(llamadaNormal),is(75.0f));
        assertThat(tarifa.costeLlamada(llamadaTarde),is(120.0f));
        assertThat(tarifa.costeLlamada(llamadaDomingo),is(60.0f));

        tarifa=new PromocionTardes(tarifa,5);

        assertThat(tarifa.costeLlamada(llamadaNormal),is(75.0f));
        assertThat(tarifa.costeLlamada(llamadaTarde),is(40.0f));
        assertThat(tarifa.costeLlamada(llamadaDomingo),is(60.0f));

        tarifa=new PromocionDomingos(tarifa);

        assertThat(tarifa.costeLlamada(llamadaNormal),is(75.0f));
        assertThat(tarifa.costeLlamada(llamadaTarde),is(40.0f));
        assertThat(tarifa.costeLlamada(llamadaDomingo),is(0.0f));
    }
}
