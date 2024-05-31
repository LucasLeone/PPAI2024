public class Accion {
    private String nombre;


    public Accion(String nombre) {
        this.nombre = nombre;
    }

    public Accion() {
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Accion [nombre=" + nombre + "]";
    }

}
