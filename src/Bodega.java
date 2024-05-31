import java.util.Date;
import java.util.Calendar;

public class Bodega {
    private String nombre;
    private Integer periodoActualizacion;  // Periodicidad en meses

    public Bodega(String nombre, Integer periodoActualizacion) {
        this.nombre = nombre;
        this.periodoActualizacion = periodoActualizacion;
    }

    public Boolean tieneActualizacionDisponible(Date fechaActual) {
        Calendar calFechaActual = Calendar.getInstance();
        calFechaActual.setTime(fechaActual);

        // Suponemos que la bodega se actualizó la última vez hace 'periodoActualizacion' meses
        Calendar calUltimaActualizacion = Calendar.getInstance();
        calUltimaActualizacion.setTime(fechaActual);
        calUltimaActualizacion.add(Calendar.MONTH, -this.periodoActualizacion);

        // Comparamos las fechas
        int diffYear = calFechaActual.get(Calendar.YEAR) - calUltimaActualizacion.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + calFechaActual.get(Calendar.MONTH) - calUltimaActualizacion.get(Calendar.MONTH);

        return diffMonth >= this.periodoActualizacion;
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
