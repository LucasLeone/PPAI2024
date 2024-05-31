public class InformacionCliente {
    private Validacion validacion;
    private String datoAValidar;

    public InformacionCliente(Validacion validacion, String datoAValidar){
        this.validacion = validacion;
        this.datoAValidar = datoAValidar;
    }

    public String getDatoAValidar() {
        return this.datoAValidar;
    }

    public Validacion getValidacion() {
        return this.validacion;
    }

    public void setDatoAValidar(String datoAValidar) {
        this.datoAValidar = datoAValidar;
    }

    public void setValidacion(Validacion validacion) {
        this.validacion = validacion;
    }

    @Override
    public String toString() {
        return "InformacionCliente [validacion=" + validacion + ", datoAValidar=" + datoAValidar + "]";
    }
}