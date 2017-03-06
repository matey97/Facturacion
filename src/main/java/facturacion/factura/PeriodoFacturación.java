package facturacion.factura;

import java.time.LocalDateTime;
import java.time.Period;

/**
 * Created by sergiojimenez on 6/3/17.
 */
public class PeriodoFacturación  {   // por implementar
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;

    public PeriodoFacturación(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public LocalDateTime getFechaInicial() {
        return fechaInicial;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaInicial(LocalDateTime fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public void setFechaFinal(LocalDateTime fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int diasTranscurridos(PeriodoFacturación periodo){
        return (LocalDateTime.from(getFechaFinal()).compareTo(periodo.fechaInicial));

    }
    public void toString (Period periodo ){
        System.out.println(periodo.getDays()+' ');


    }

}
