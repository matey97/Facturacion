package facturacion;

import facturacion.cliente.DireccionTest;
import facturacion.colecciones.ColeccionEmpresasTest;
import facturacion.colecciones.ColeccionFacturasTest;
import facturacion.colecciones.ColeccionLlamadasTest;
import facturacion.colecciones.ColeccionParticularesTest;
import facturacion.excepciones.DuracionNoValidaTest;
import facturacion.excepciones.ExcepcionClienteSinLlamadasTest;
import facturacion.excepciones.FechaInicialMayorQueFinalTest;
import facturacion.tarifa.TarifasTest;
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