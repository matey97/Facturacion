package facturacion;

import java.time.LocalDateTime;

/**
 * Created by al341802 on 21/02/17.
 */
public abstract class Cliente {
    private String nombre;
    private String NIF;
    private Direccion direccion;
    private String email;
    private LocalDateTime fecha;
    private Tarifa tarifa;

    public Cliente(){
    }

    public Cliente(String nombre, String NIF, Direccion direccion, String email, LocalDateTime fecha, Tarifa tarifa) {
        this.nombre = nombre;
        this.NIF = NIF;
        this.direccion = direccion;
        this.email = email;
        this.fecha = fecha;
        this.tarifa = tarifa;
    }

    public String getNombre(){
        return nombre;
    }

    public String getNIF(){
        return NIF;
    }

    public Direccion getDireccion(){
        return direccion;
    }

    public String email(){
        return email;
    }

    public LocalDateTime getFecha(){
        return fecha;
    }

    public Tarifa getTarifa(){
        return tarifa;
    }
}
