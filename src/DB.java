import java.util.ArrayList;
import java.util.Collections;

public class DB {
    public ArrayList<Bodega> dbBodega;
    public ArrayList<TipoUva> dbTipoUva;
    public ArrayList<Varietal> dbVarietal;
    public ArrayList<Vino> dbVino;
    public ArrayList<Enofilo> dbEnofilo;
    public ArrayList<Siguiendo> dbSiguiendo;

    public DB() {
        // bodegas
        this.dbBodega = new ArrayList<Bodega>();
        Bodega bodega1 = new Bodega("Las Lilas", 2);
        Bodega bodega2 = new Bodega("La negrita", 6);
        Bodega bodega3 = new Bodega("El perro", 0);
        Bodega bodega4 = new Bodega("El sur", 0);
        Collections.addAll(dbBodega, bodega1, bodega2, bodega3, bodega4);

        // tipos de uva
        this.dbTipoUva = new ArrayList<TipoUva>();
        TipoUva tipoUva1 = new TipoUva("Cabernet");
        TipoUva tipoUva2 = new TipoUva("Mencia");
        TipoUva tipoUva3 = new TipoUva("Malbec");
        TipoUva tipoUva4 = new TipoUva("Syrah");
        Collections.addAll(dbTipoUva, tipoUva1, tipoUva2, tipoUva3, tipoUva4);

        // varietal
        this.dbVarietal = new ArrayList<Varietal>();
        Varietal varietal1 = new Varietal(tipoUva1);
        Varietal varietal2 = new Varietal(tipoUva1);
        Varietal varietal3 = new Varietal(tipoUva3);
        Varietal varietal4 = new Varietal(tipoUva4);
        Collections.addAll(dbVarietal, varietal1, varietal2, varietal3, varietal4);
        
        // Listas de varietales para cada vino
        ArrayList<Varietal> varietalsForVino1 = new ArrayList<>();
        Collections.addAll(varietalsForVino1, varietal1, varietal2);

        ArrayList<Varietal> varietalsForVino2 = new ArrayList<>();
        Collections.addAll(varietalsForVino2, varietal2);

        ArrayList<Varietal> varietalsForVino3 = new ArrayList<>();
        Collections.addAll(varietalsForVino3, varietal3, varietal4);

        ArrayList<Varietal> varietalsForVino4 = new ArrayList<>();
        Collections.addAll(varietalsForVino4, varietal4);
        
        // vinos
        this.dbVino = new ArrayList<Vino>();
        Vino vino1 = new Vino("2017", "10/03/2024", "imagen1", "Toro", 11200, bodega3, varietalsForVino1);
        Vino vino2 = new Vino("2023", "16/02/2024", "imagen2", "Guepardo", 3200, bodega3, varietalsForVino2);
        Vino vino3 = new Vino("2020", "05/03/2024", "imagen3", "Piel de cordero", 9800, bodega1, varietalsForVino3);
        Vino vino4 = new Vino("2022", "13/03/2024", "imagen4", "Berraco", 9900, bodega4, varietalsForVino4);
        Collections.addAll(dbVino, vino1, vino2, vino3, vino4);

        // enofilo
        this.dbEnofilo = new ArrayList<Enofilo>();
        Enofilo enofilo1 = new Enofilo("Lucas");
        Enofilo enofilo2 = new Enofilo("Francisco");
        Enofilo enofilo3 = new Enofilo("Valentino");
        Enofilo enofilo4 = new Enofilo("Marco");
        Collections.addAll(dbEnofilo, enofilo1, enofilo2, enofilo3, enofilo4);

        // siguiendo
        this.dbSiguiendo = new ArrayList<Siguiendo>();
        Siguiendo siguiendo1 = new Siguiendo(bodega3, enofilo1);
        Siguiendo siguiendo2 = new Siguiendo(bodega3, enofilo2);
        Siguiendo siguiendo3 = new Siguiendo(bodega1, enofilo3);
        Siguiendo siguiendo4 = new Siguiendo(bodega2, enofilo4);
        Collections.addAll(dbSiguiendo, siguiendo1, siguiendo2, siguiendo3, siguiendo4);
    }
    
    public void actualizarVino(String nombre, String nuevaFecha, String nuevaImagen, String nuevoNombre, int nuevoPrecio) {
        for (Vino vino : dbVino) {
            if (vino.getNombre().equals(nombre)) {
                vino.setFechaActualizacion(nuevaFecha);
                vino.setImagenEtiqueta(nuevaImagen);
                vino.setNombre(nuevoNombre);
                vino.setPrecioARS(nuevoPrecio);
                break;
            }
        }
    }

    public void agregarVino(Vino nuevoVino) {
        dbVino.add(nuevoVino);
    }
}
