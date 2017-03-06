package facturacion.factura;

import facturacion.Fecha;

import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 21/2/17.
 */
public class Factura implements Fecha{

    private int codfac;
    private Tarifa tarifa;
    //private PeriodoFacturacion;
    private LocalDateTime fechaDeEmision;// periodo facturación
    private PeriodoFacturacion Periodofact;// periodo facturación
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
        return "El codigo: "+this.codfac+"\nTarifa : "+ this.tarifa+ "\n Inicio:"+
                this.fechaDeEmision+"\nFecha de fin: "+ getPeriodofact()+"\nImporte total de : "+this.importe;

    }

}
