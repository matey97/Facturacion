package facturacion.factura;

import facturacion.Fecha;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 21/2/17.
 */
public class Factura implements Fecha{

    private int codfac;
    private Tarifa tarifa;
    private LocalDateTime fechaDeEmision;
    private LocalDateTime Periodofact;
    private int importe;

    public Factura(int codfac, Tarifa tarifa, LocalDateTime fechaDeEmision, LocalDateTime periodofact,int importe) {
        this.codfac = codfac;
        this.tarifa = tarifa;
        this.fechaDeEmision = fechaDeEmision;
        Periodofact = periodofact;
        this.importe = importe;
    }

    public int getCodfac() {
        return codfac;
    }

    public Tarifa getTarifa() {

        return tarifa;
    }

    @Override
    public LocalDateTime getFecha() {
        return fechaDeEmision;
    }

    public LocalDateTime getPeriodofact() {
        return Periodofact;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

}
