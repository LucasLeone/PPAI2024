public class Estado {
    private String nombre;

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean esEnCurso(){
        if (this.getNombre() == "enCurso") {
            return true;
        } else {
            return false;
        }
    }
    public boolean esFinalizada(){
        if (this.getNombre() == "finalizada") {
            return true;
        } else {
            return false;
        }
    }
    public boolean esCancelado(){
        if (this.getNombre() == "cancelado") {
            return true;
        } else {
            return false;
        }
    }
	@Override
	public String toString() {
		return "Estado [nombre=" + nombre + "]";
	}
}