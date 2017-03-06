package facturacion.factura;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by sergiojimenez on 6/3/17.
 */
public class PeriodoFacturación {   // por implementar
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;

    public PeriodoFacturación(LocalDate fechaInicial, LocalDate fechaFinal) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Period diasTranscurridos(PeriodoFacturación periodo){
        return Period.between(periodo.getFechaFinal(),periodo.fechaInicial);

    }

}
