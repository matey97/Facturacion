package modelo.cliente;

import java.io.Serializable;

/**
 * Created by al341802 on 21/02/17.
 */
public class Direccion implements Serializable{
    private int codPostal;
    private String provincia;
    private String poblacion;

    public Direccion(){
        super();
    }

    public Direccion(int codPostal, String provincia, String poblacion) {
        this.codPostal = codPostal;
        this.provincia = provincia;
        this.poblacion = poblacion;
    }

    public String getDireccion(){
        return codPostal+", "+poblacion+", "+provincia;
    }

    @Override
    public String toString(){
        return codPostal+", "+poblacion+", "+provincia;
    }
}
