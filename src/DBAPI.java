import java.util.ArrayList;
import java.util.Collections;

public class DBAPI {
    public ArrayList<Vino> dbVino;

    public DBAPI() {
        this.dbVino = new ArrayList<Vino>();
        Bodega bodega3 = new Bodega("El perro", 0);
        Vino vino1 = new Vino("2017", "10/03/2024", "imagen1", "Toro", 11200, bodega3, new ArrayList<>());
        Vino vino2 = new Vino("2023", "16/02/2024", "imagen2", "Guepardo", 3200, bodega3, new ArrayList<>());
        Collections.addAll(dbVino, vino1, vino2);
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
