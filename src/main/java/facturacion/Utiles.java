package facturacion;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by al341802 on 7/03/17.
 */
public class Utiles {

    public static <T extends Fecha> Collection<T> entreDosFechas(Collection<T> col, LocalDateTime inicio, LocalDateTime fin){
        Collection<T> res=new LinkedList<T>();
        for(T obj:col){
            if (obj.getFecha().isAfter(inicio) && obj.getFecha().isBefore(fin))
                res.add(obj);
        }
        return res;
    }
}
