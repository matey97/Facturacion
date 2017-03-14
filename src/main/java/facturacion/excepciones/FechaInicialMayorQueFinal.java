package facturacion.excepciones;

/**
 * Created by sergiojimenez on 14/3/17.
 */
public class FechaInicialMayorQueFinal extends Exception{
    public FechaInicialMayorQueFinal(String message){
        super(message);
    }
}
