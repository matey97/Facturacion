package facturacion.factura;

import facturacion.Fecha;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 21/2/17.
 */
public class Factura implements Fecha, Serializable{

    private int codfac;
    private Tarifa tarifa;
    private LocalDateTime fechaDeEmision;
    private PeriodoFacturacion Periodofact;
    private int importe;

    public Factura(int codfac, Tarifa tarifa, LocalDateTime fechaDeEmision, PeriodoFacturacion periodofact, int importe) {
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

    public PeriodoFacturacion getPeriodofact() {
        return Periodofact;


    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }
    @Override
    public String toString(){
        return "Codigo factura: "+this.codfac+"\nTarifa : "+ this.tarifa+ "\nFecha emisión:"+
                this.fechaDeEmision+"\nFecha de facturación: "+ getPeriodofact()+"\nImporte total de : "+this.importe;

    }

}
