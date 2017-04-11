package facturacion.factorias;

/**
 * Created by al341802 on 4/04/17.
 */
public enum TipoPromocion {
    TARDES("Tarifa reducida de tardes."),
    DOMINGOS("Tarifa domingos gratis");

    private String descrip;

    private TipoPromocion(String descrip){
        this.descrip=descrip;
    }

    public static String opciones(){
        StringBuilder sb = new StringBuilder();
        for(TipoPromocion tipo : values())
            sb.append(tipo.ordinal()+" --> "+tipo.descrip+"\n");
        return sb.toString();
    }

    public static TipoPromocion enteroATipo(int pos){
        return values()[pos];
    }

}
