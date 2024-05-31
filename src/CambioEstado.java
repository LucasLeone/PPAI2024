import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CambioEstado {
    private Estado estado;
    private String fechaInicio;
    private String fechaFin;


    public CambioEstado( Estado estado) {
        Instant instant = Instant.now();
        // Set the time zone to GMT
        ZoneId zone = ZoneId.of("GMT-3");
        // Format the date and time as a string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = instant.atZone(zone).format(formatter);

        this.estado = estado;
        this.fechaInicio = dateTime;
        this.fechaFin = null;
    }


    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Date fechaActual) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaString = formato.format(fechaActual);
        this.fechaFin = fechaString;
    }


    @Override
    public String toString() {
        return
            " estado='" + this.getEstado().getNombre() + "'" +
            ", fechaInicio='" + getFechaInicio() + "'" +
            ", fechaFin='" + getFechaFin() + "'";
    }
}