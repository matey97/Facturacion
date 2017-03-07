package facturacion.factura;

import java.time.LocalDateTime;
import java.time.Period;

/**
 * Created by sergiojimenez on 6/3/17.
 */
public class PeriodoFacturacion {
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;

    public PeriodoFacturacion(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
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

    public int diasTranscurridos(){
        return (LocalDateTime.from(getFechaFinal()).compareTo(this.fechaInicial));

    }

    public String toString (){
        return (this.diasTranscurridos()+"");

    }


}
