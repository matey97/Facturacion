package facturacion;

import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 21/2/17.
 */
public class Llamada {

    private int telefono;
    private LocalDateTime fecha;
    private int duracion;



    public Llamada(int telefon, LocalDateTime fecha, int duracion) {
        this.telefono = telefono;
        this.fecha = fecha;
        this.duracion=duracion;

    }

    public int getTelefono() {
        return telefono;
    }

    public LocalDateTime getFecha() {

        return fecha;
    }

    public int getDuración() {
        return duracion;
    }
}
