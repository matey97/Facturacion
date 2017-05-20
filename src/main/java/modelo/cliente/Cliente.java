package modelo.cliente;

import modelo.Fecha;
import modelo.tarifa.Tarifa;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by al341802 on 21/02/17.
 */
public abstract class Cliente implements Fecha, Serializable{
    private String nombre;
    private String apellidos = null;
    private String NIF;
    private Direccion direccion;
    private String email;
    private LocalDateTime fecha;
    private Tarifa tarifa;

    public Cliente(){

    }

    public Cliente(String nombre, String apellidos, String NIF, Direccion direccion, String email,Tarifa tarifa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.direccion = direccion;
        this.email = email;
        this.fecha = LocalDateTime.now();
        this.tarifa = tarifa;
    }
//añadido constructor a posteriori para empresa.
    public Cliente(String nombre, String nif, Direccion direccion, String email, Tarifa tarifa) {
        this.nombre = nombre;
        this.NIF = nif;
        this.direccion = direccion;
        this.email = email;
        this.fecha = LocalDateTime.now();
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

    public String getEmail(){
        return email;
    }

    @Override
    public LocalDateTime getFecha(){
        return fecha;
    }

    public Tarifa getTarifa(){
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa=tarifa;
    }

    @Override
    public String toString() {
        return  "Nombre: "+ getNombre()+"\n" +
                "NIF: "+ getNIF()+"\n"+
                "Dirección: "+getDireccion()+"\n"+
                "Email: "+ getEmail()+"\n"+
                "Fecha: "+ getFecha()+"\n"+
                "Tarifa: "+ getTarifa();
    }
}
