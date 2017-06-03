package modelo.cliente;

import modelo.Fecha;
import modelo.factorias.FactoriaTarifa;
import modelo.factorias.FactoriaTarifas;
import modelo.tarifa.Tarifa;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by al341802 on 21/02/17.
 */
public abstract class Cliente implements Fecha, Serializable{
    private String nombre;
    private String NIF;
    private Direccion direccion;
    private String email;
    private LocalDateTime fecha;
    private Tarifa tarifa;
    private FactoriaTarifa fabricaTarifa=new FactoriaTarifas();

    public Cliente(){
        super();
    }

    public Cliente(String nombre, String NIF, Direccion direccion, String email) {
        this.nombre = nombre;
        this.NIF = NIF;
        this.direccion = direccion;
        this.email = email;
        this.fecha = LocalDateTime.now();
        this.tarifa = fabricaTarifa.getTarifaBasica();
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
                "Tarifa: "+ getTarifa().toString();
    }
}
