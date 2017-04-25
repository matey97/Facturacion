package modelo.excepciones;

/**
 * Created by sergiojimenez on 7/3/17.
 */
public class ExcepcionClienteSinLlamadas extends Exception{
    public ExcepcionClienteSinLlamadas(String message) {
        super(message);
    }
}
