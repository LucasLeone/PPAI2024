import java.util.ArrayList;

public class Cliente {
    private String dni;
    private String nombreCompleto;
    private String nroCelular;
    private ArrayList<InformacionCliente> informacionCliente;

    public Cliente(String dni, String nombreCompleto, String nroCelular, ArrayList<InformacionCliente> informacionCliente) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.nroCelular = nroCelular;
        this.informacionCliente =new ArrayList<InformacionCliente>();
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNroCelular() {
        return this.nroCelular;
    }

    public void setNroCelular(String nroCelular) {
        this.nroCelular = nroCelular;
    }

    public ArrayList<InformacionCliente> getInformacionCliente() {
        return this.informacionCliente;
    }

    public void setInformacionCliente(ArrayList<InformacionCliente> informacionCliente) {
        this.informacionCliente = informacionCliente;
    }

    public boolean esInformacionCorrecta(String seleccion, Validacion validacion){     
        for (InformacionCliente info : informacionCliente) {
            if (info.getValidacion().equals(validacion) ){
                if (info.getDatoAValidar().equals(seleccion)){
                    return true;
                }else{
                    return false;
                }
            }
        }
        System.out.println("validacion no encontrada");
        return false;
    };


    @Override
    public String toString() {
        return 
            "DNI:" + getDni()  + "\n" +
            "Nombre Completo: " + getNombreCompleto() + "\n" +
            "Numero Celular: " + getNroCelular() + "\n"+
            "Información Cliente: " + getInformacionCliente() 
            ;
    }

}