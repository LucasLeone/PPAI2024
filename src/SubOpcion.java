import java.util.ArrayList;
import java.util.HashMap;

public class SubOpcion {
    

	private String nombre;
    private int numeroOrden;
    private ArrayList<Validacion> validacionesRequeridas;

    public SubOpcion(String nombre, ArrayList<Validacion> validacionesRequeridas) {
        this.nombre = nombre;
        this.numeroOrden = 0;
        this.validacionesRequeridas = validacionesRequeridas;
    }

    public HashMap<String, Validacion> getMensajeValidacion() {
        ArrayList<Validacion> val = getValidacionesRequeridas();
        HashMap<String, Validacion> map = new HashMap<String, Validacion>();
        for (Validacion validacion : val) {
            // crear hasmap con mensaje y objeto Validacion
            map.put(validacion.getNombre(), validacion);
        }
        return map;
    }

    public ArrayList<Validacion> getValidacionesRequeridas() {
        return validacionesRequeridas;
    }

    public void setValidacionesRequeridas(ArrayList<Validacion> validacionesRequeridas) {
        this.validacionesRequeridas = validacionesRequeridas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }
    
    @Override
	public String toString() {
		return "Nombre: " + nombre + "\n Numero Orden:" + numeroOrden + ", validacionesRequeridas="
				+ validacionesRequeridas + "]";
	}

}