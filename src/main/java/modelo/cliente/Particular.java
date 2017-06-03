package modelo.cliente;

import modelo.tarifa.Tarifa;

import java.time.LocalDateTime;

/**
 * Created by al341802 on 21/02/17.
 */
public class Particular extends Cliente{

    private String apellidos;

    public Particular(){
        super();
    }

    public Particular(String nombre,String apellidos, String NIF, Direccion direccion, String email) {
        super(nombre,NIF,direccion,email);
        this.apellidos=apellidos;
    }

    @Override
    public String getNombre() {
        return super.getNombre()+" "+apellidos;
    }
}
