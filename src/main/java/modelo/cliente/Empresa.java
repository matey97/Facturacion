package modelo.cliente;

import modelo.tarifa.Tarifa;

import java.time.LocalDateTime;

/**
 * Created by al341802 on 21/02/17.
 */
public class Empresa extends Cliente{

    public Empresa(){
        super();
    }

    public Empresa(String nombre, String NIF, Direccion direccion, String email) {
        super(nombre,NIF,direccion,email);
    }

}
