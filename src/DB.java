import java.util.ArrayList;
import java.util.Collections;

public class DB {
    // agregar atributos
    public ArrayList<Bodega> dbBodega;

    public DB() {
        // bodegas
        this.dbBodega = new ArrayList<Bodega>();
        Bodega bodega1 = new Bodega("Las Lilas", 2);
        Bodega bodega2 = new Bodega("La negrita", 6);
        Bodega bodega3 = new Bodega("El perro", 0);
        Bodega bodega4 = new Bodega("El sur", 0);
        Collections.addAll(dbBodega, bodega1, bodega2, bodega3, bodega4);

        // vinos

        // tipos de uva

        // varietal

        // maridaje

        // enofilo

        // siguiendo



    }
}