import java.sql.Date;
import java.util.ArrayList;

public class Vino {
    private String añada;
    private String fechaActualizacion;
    private String imagenEtiqueta;
    private String nombre;
    private String notaDeCataBodega;
    private Integer precioARS;
    private ArrayList<Varietal> varietal;
    private ArrayList<Maridaje> maridaje;
    private Bodega bodega;

    public Vino(String añada, String fechaActualizacion, String imagenEtiqueta, String nombre, Integer precioARS, Bodega bodega, ArrayList<Varietal> varietalsForVino1) {
        this.añada = añada;
        this.fechaActualizacion = fechaActualizacion;
        this.imagenEtiqueta = imagenEtiqueta;
        this.nombre = nombre;
        this.precioARS = precioARS;
        this.bodega = bodega;
    }
    
    public String getAñada() {
        return this.añada;
    }

    public void setAñada(String añada) {
        this.añada = añada;
    }

    public String getFechaActualizacion() {
        return this.fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getImagenEtiqueta() {
        return this.imagenEtiqueta;
    }

    public void setImagenEtiqueta(String imagenEtiqueta) {
        this.imagenEtiqueta = imagenEtiqueta;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotaDeCataBodega() {
        return this.notaDeCataBodega;
    }

    public void setNotaDeCataBodega(String notaDeCataBodega) {
        this.notaDeCataBodega = notaDeCataBodega;
    }

    public Integer getPrecioARS() {
        return this.precioARS;
    }

    public void setPrecioARS(Integer precioARS) {
        this.precioARS = precioARS;
    }

    public ArrayList<Varietal> getVarietal() {
        return this.varietal;
    }

    public void setVarietal(ArrayList<Varietal> varietal) {
        this.varietal = varietal;
    }

    public ArrayList<Maridaje> getMaridaje() {
        return this.maridaje;
    }

    public void setMaridaje(ArrayList<Maridaje> maridaje) {
        this.maridaje = maridaje;
    }

    public Bodega getBodega() {
        return this.bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    @Override
    public String toString() {
        return " - Añada: " + añada + ", fecha de actualizacion: " + fechaActualizacion + ", precio: $" + precioARS + ", bodega: " + bodega.getNombre() + ")";
    }

	public boolean perteneceABodegaSeleccionada(Bodega bodegaSeleccionada) {
		if (this.getBodega() == bodegaSeleccionada) {
			return true;
		} else {			
			return false;
		}
	}
}
