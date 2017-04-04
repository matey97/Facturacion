package facturacion.tarifa;

import facturacion.excepciones.DuracionNoValida;
import facturacion.factura.Llamada;
import org.junit.Before;
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
    private static Llamada llamadaNormal;
    private static Llamada llamadaTarde;
    private static Llamada llamadaDomingo;

    @BeforeClass
    public static void init() throws DuracionNoValida{
        llamadaNormal = new Llamada(695968097, LocalDateTime.of(2017,4,3,12,20),5);
        llamadaTarde = new Llamada(695968097, LocalDateTime.of(2017,4,3,18,30),8);
        llamadaDomingo = new Llamada(695968097, LocalDateTime.of(2017,4,2,12,46),4);
    }

    @Before
    public void antesDeTest(){
        tarifa=new TarifaBasica();
    }

    @Test
    public void costeTarifaNormalTest(){
        assertThat(tarifa.costeLlamada(llamadaNormal),is(75.0f));
        assertThat(tarifa.costeLlamada(llamadaTarde),is(120.0f));
        assertThat(tarifa.costeLlamada(llamadaDomingo),is(60.0f));
    }

    @Test
    public void costeTarifaTardesTest(){
        tarifa=new PromocionTardes(tarifa,5);

        assertThat(tarifa.costeLlamada(llamadaNormal),is(75.0f));
        assertThat(tarifa.costeLlamada(llamadaTarde),is(40.0f));
        assertThat(tarifa.costeLlamada(llamadaDomingo),is(60.0f));
    }

    @Test
    public void costeTarifaDomingosTest(){
        tarifa=new PromocionDomingos(tarifa);

        assertThat(tarifa.costeLlamada(llamadaNormal),is(75.0f));
        assertThat(tarifa.costeLlamada(llamadaTarde),is(120.0f));
        assertThat(tarifa.costeLlamada(llamadaDomingo),is(0.0f));
    }

    @Test
    public void costeTarifaTardesDomingosTest(){
        tarifa=new PromocionTardes(tarifa,5);
        tarifa=new PromocionDomingos(tarifa);

        assertThat(tarifa.costeLlamada(llamadaNormal),is(75.0f));
        assertThat(tarifa.costeLlamada(llamadaTarde),is(40.0f));
        assertThat(tarifa.costeLlamada(llamadaDomingo),is(0.0f));
    }

    @Test
    public void costeTarifaDomingosTardesTest(){
        tarifa=new PromocionDomingos(tarifa);
        tarifa=new PromocionTardes(tarifa,5);

        assertThat(tarifa.costeLlamada(llamadaNormal),is(75.0f));
        assertThat(tarifa.costeLlamada(llamadaTarde),is(40.0f));
        assertThat(tarifa.costeLlamada(llamadaDomingo),is(0.0f));
    }
}
