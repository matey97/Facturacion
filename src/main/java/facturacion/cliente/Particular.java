package facturacion.cliente;

import facturacion.tarifa.Tarifa;

import java.time.LocalDateTime;

/**
 * Created by al341802 on 21/02/17.
 */
public class Particular extends Cliente{

    private String apellidos;

    public Particular(){
        super();
    }

    public Particular(String nombre,String apellidos, String NIF, Direccion direccion, String email, LocalDateTime fecha, Tarifa tarifa) {
        super(nombre,NIF,direccion,email,fecha,tarifa);
        this.apellidos=apellidos;
    }

    @Override
    public String getNombre() {
        return super.getNombre()+" "+apellidos;
    }
}
