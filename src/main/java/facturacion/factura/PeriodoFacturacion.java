package facturacion.factura;

import facturacion.Excepciones.FechaInicialMayorQueFinal;

import java.time.LocalDateTime;
import java.time.Period;

/**
 * Created by sergiojimenez on 6/3/17.
 */
public class PeriodoFacturacion {
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;

    public PeriodoFacturacion(LocalDateTime fechaInicial, LocalDateTime fechaFinal) throws FechaInicialMayorQueFinal {
        if(fechaInicial.isAfter(fechaFinal)){
            throw new FechaInicialMayorQueFinal("la fecha inicial no puede ser posterior a la fecha final");

        }
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public LocalDateTime getFechaInicial() {
        return fechaInicial;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaInicial(LocalDateTime fechaInicial) throws FechaInicialMayorQueFinal {
        if(fechaInicial.isAfter(this.fechaFinal)){
            throw new FechaInicialMayorQueFinal("la fecha inicial no puede ser posterior a la fecha final");

        }

        this.fechaInicial = fechaInicial;
    }

    public void setFechaFinal(LocalDateTime fechaFinal)throws FechaInicialMayorQueFinal {
        if(fechaInicial.isBefore(fechaInicial)){
            throw new FechaInicialMayorQueFinal("la fecha inicial no puede ser posterior a la fecha final");

        }
        this.fechaFinal = fechaFinal;
    }

    public String diasTranscurridos(){
        return "Desde "+fechaInicial.toString()+" hasta "+fechaFinal.toString();
    }

    public String toString (){
        return (this.diasTranscurridos());

    }


}
