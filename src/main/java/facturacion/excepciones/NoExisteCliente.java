package facturacion.excepciones;

/**
 * Created by sergiojimenez on 14/3/17.
 */
public class NoExisteCliente extends Exception{
    public NoExisteCliente(String message) {
        super(message);
    }
}

