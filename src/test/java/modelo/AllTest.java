package modelo;

import modelo.cliente.DireccionTest;
import modelo.colecciones.ColeccionFacturasTest;
import modelo.colecciones.ColeccionLlamadasTest;
import modelo.colecciones.ColeccionClientesTest;
import modelo.excepciones.DuracionNoValidaTest;
import modelo.excepciones.ExcepcionClienteSinLlamadasTest;
import modelo.excepciones.FechaInicialMayorQueFinalTest;
import modelo.tarifa.TarifasTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by user on 6/03/17.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ DireccionTest.class,  ColeccionFacturasTest.class,
        ColeccionLlamadasTest.class, ColeccionClientesTest.class, DuracionNoValidaTest.class,
        FechaInicialMayorQueFinalTest.class, ExcepcionClienteSinLlamadasTest.class, TarifasTest.class
})

public class AllTest {
}