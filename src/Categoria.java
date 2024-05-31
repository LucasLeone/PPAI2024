import java.util.ArrayList;
import java.util.HashMap;

public class Categoria {
    private String audioMensajeOpciones;
    private String mensajeOpciones;
    private String nombre;
    private int numeroOrden;
    private ArrayList<Opcion> opciones;

    

	public Categoria(String nombre, ArrayList<Opcion> opciones) {
        this.nombre = nombre;
        this.opciones = opciones;
    }

    // Metodos de CU
    public String getDescripcionCompletaCategoriaYOpcion(Opcion opcion, SubOpcion subOpcion) {
        return opcion.getDescripcionConSubOpcion(subOpcion);
    }

    public HashMap<String, Validacion> buscarValidaciones(Opcion opcion, SubOpcion subOpcion) {
        return opcion.buscarValidaciones(subOpcion);
    }

    // Metodos de Seteo
    public String getAudioMensajeOpciones() {
        return this.audioMensajeOpciones;
    }

    public void setAudioMensajeOpciones(String audioMensajeOpciones) {
        this.audioMensajeOpciones = audioMensajeOpciones;
    }

    public String getMensajeOpciones() {
        return this.mensajeOpciones;
    }

    public void setMensajeOpciones(String mensajeOpciones) {
        this.mensajeOpciones = mensajeOpciones;
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

    public ArrayList<Opcion> getOpciones() {
        return this.opciones;
    }

    public void setOpciones(ArrayList<Opcion> opciones) {
        this.opciones = opciones;
    }
    
    @Override
	public String toString() {
		return "Categoria [audioMensajeOpciones=" + audioMensajeOpciones + ", mensajeOpciones=" + mensajeOpciones
				+ ", nombre=" + nombre + ", numeroOrden=" + numeroOrden + ", opciones=" + opciones + "]";
	}
}