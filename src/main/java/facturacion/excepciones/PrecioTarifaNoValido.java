package facturacion.excepciones;

/**
 * Created by sergiojimenez on 14/3/17.
 */
public class PrecioTarifaNoValido extends Exception {
    public PrecioTarifaNoValido(String message) {
        super(message);
    }
}
