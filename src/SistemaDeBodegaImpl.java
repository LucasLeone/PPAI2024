import java.util.ArrayList;
import java.util.List;

public class SistemaDeBodegaImpl implements SistemaDeBodega {
    private DBAPI dbAPI;

    public SistemaDeBodegaImpl(DBAPI dbAPI) {
        this.dbAPI = dbAPI;
    }

    @Override
    public ArrayList<String> actualizarYCrearVinos(Bodega bodega) {
        List<String> vinosActualizados = new ArrayList<>();
        List<String> vinosCreados = new ArrayList<>();

        // Actualizar un vino existente
        dbAPI.actualizarVino("Toro", "11/03/2024", "imagenActualizada1", "(Actualizado) Toro" , 12000);
        vinosActualizados.add(dbAPI.dbVino.get(0).toString());

        // Crear y agregar dos nuevos vinos
        Vino nuevoVino1 = new Vino("2019", "01/06/2024", "imagen5", "Portillo", 7000, bodega, new ArrayList<>());
        Vino nuevoVino2 = new Vino("2021", "01/06/2024", "imagen6", "Benegas", 8000, bodega, new ArrayList<>());
        dbAPI.agregarVino(nuevoVino1);
        dbAPI.agregarVino(nuevoVino2);
        vinosCreados.add(nuevoVino1.toString());
        vinosCreados.add(nuevoVino2.toString());

        ArrayList<String> result = new ArrayList<>();
        result.addAll(vinosActualizados);
        result.addAll(vinosCreados);
        return result;
    }
}
