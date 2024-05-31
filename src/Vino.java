import java.sql.Date;
import java.util.ArrayList;

public class Vino {
    private String añada;
    private Date fechaActualizacion;
    private String imagenEtiqueta;
    private String nombre;
    private String notaDeCataBodega;
    private Integer precioARS;
    private ArrayList<Varietal> varietal;
    private ArrayList<Maridaje> maridaje;
    private Bodega bodega;

    public String getAñada() {
        return this.añada;
    }

    public void setAñada(String añada) {
        this.añada = añada;
    }

    public Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
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
}
