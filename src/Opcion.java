import java.util.ArrayList;
import java.util.HashMap;

public class Opcion {
    

	private String audioMensajeSubopciones;
    private String mensajeSubopciones;
    private String nombre;
    private int nroOrden;
    private ArrayList<SubOpcion> subopciones;

    public Opcion(String nombre, ArrayList<SubOpcion> subopciones, ArrayList<Validacion> validacionesRequeridas) {
        // this.audioMensajeSubopciones = audioMensajeSubopciones;
        // this.mensajeSubopciones = mensajeSubopciones;
        this.nombre = nombre;
        this.nroOrden = 0;
        this.subopciones = subopciones;
        this.validacionesRequeridas = validacionesRequeridas;
    }

    public HashMap<String, Validacion> buscarValidaciones(SubOpcion subOpcion) {
        return subOpcion.getMensajeValidacion();
    }

    public String getDescripcionConSubOpcion(SubOpcion subOpcion) {
        return subOpcion.getNombre();
    }

    public ArrayList<SubOpcion> getSubopciones() {
        return subopciones;
    }

    public void setSubopciones(ArrayList<SubOpcion> subopciones) {
        this.subopciones = subopciones;
    }

    public ArrayList<Validacion> getValidacionesRequeridas() {
        return validacionesRequeridas;
    }

    public void setValidacionesRequeridas(ArrayList<Validacion> validacionesRequeridas) {
        this.validacionesRequeridas = validacionesRequeridas;
    }

    private ArrayList<Validacion> validacionesRequeridas;

    public String getAudioMensajeSubopciones() {
        return this.audioMensajeSubopciones;
    }

    public void setAudioMensajeSubopciones(String audioMensajeSubopciones) {
        this.audioMensajeSubopciones = audioMensajeSubopciones;
    }

    public String getMensajeSubopciones() {
        return this.mensajeSubopciones;
    }

    public void setMensajeSubopciones(String mensajeSubopciones) {
        this.mensajeSubopciones = mensajeSubopciones;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroOrden() {
        return this.nroOrden;
    }

    public void setNroOrden(int nroOrden) {
        this.nroOrden = nroOrden;
    }

	@Override
	public String toString() {
		return "Audio Mensaje Subopciones: " + audioMensajeSubopciones + "\n Mensaje Subopciones: "
				+ mensajeSubopciones + " \n Nombre=" + nombre + "\n Nro Orden: " + nroOrden + " Sub opciones: " + subopciones
				+ "\n Validaciones Requeridas: " + validacionesRequeridas;
	}

	
    
    
    
    
}