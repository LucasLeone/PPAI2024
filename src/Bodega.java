import java.util.Date;
import java.util.Calendar;

public class Bodega {
    private String nombre;
    private Integer periodoActualizacion;  // Periodicidad en meses

    public Bodega(String nombre, Integer periodoActualizacion) {
        this.nombre = nombre;
        this.periodoActualizacion = periodoActualizacion;
    }

    public Boolean tieneActualizacionDisponible() {
        if (this.periodoActualizacion == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Métodos get y set
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPeriodoActualizacion() {
        return this.periodoActualizacion;
    }

    public void setPeriodoActualizacion(Integer periodoActualizacion) {
        this.periodoActualizacion = periodoActualizacion;
    }
}
