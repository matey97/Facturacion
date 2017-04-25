package modelo;

import modelo.cliente.DireccionTest;
import modelo.colecciones.ColeccionEmpresasTest;
import modelo.colecciones.ColeccionFacturasTest;
import modelo.colecciones.ColeccionLlamadasTest;
import modelo.colecciones.ColeccionParticularesTest;
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
@Suite.SuiteClasses({ DireccionTest.class, ColeccionEmpresasTest.class, ColeccionFacturasTest.class,
        ColeccionLlamadasTest.class, ColeccionParticularesTest.class, DuracionNoValidaTest.class,
        FechaInicialMayorQueFinalTest.class, ExcepcionClienteSinLlamadasTest.class, TarifasTest.class
})

public class AllTest {
}