import java.util.ArrayList;

public class Enofilo {
    private String nombre;
    private ArrayList<Siguiendo> siguiendo;

    public ArrayList<Siguiendo> getSiguiendo() {
        return this.siguiendo;
    }

    public void setSiguiendo(ArrayList<Siguiendo> siguiendo) {
        this.siguiendo = siguiendo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
