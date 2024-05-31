public class Validacion {
    private String audioMensajeValidacion;
    private String nombre;
    private int numeroOrden;

    public Validacion(String nombre, String audioMensajeValidacion) {
        this.audioMensajeValidacion = "";
        this.nombre = nombre;
        this.numeroOrden = 0;
    }

    public String getAudioMensajeValidacion() {
        return this.audioMensajeValidacion;
    }

    public void setAudioMensajeValidacion(String audioMensajeValidacion) {
        this.audioMensajeValidacion = audioMensajeValidacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroOrden() {
        return this.numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    @Override
    public String toString() {
        return "Validacion [audioMensajeValidacion=" + audioMensajeValidacion + ", nombre=" + nombre + ", numeroOrden="
                + numeroOrden + "]";
    }
}