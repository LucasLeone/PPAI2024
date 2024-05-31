import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Llamada {
    private String descripcionOperador;
    private String detalleAccionRequerida;
    private long duracion;
    private boolean encuestaEnviada;
    private String observacionAuditor;
    private ArrayList<CambioEstado> cambioEstado;
    private Cliente cliente;
    private ArrayList<SubOpcion> subOpcionesSeleccionadas;
    private Date fechaFin;
    private Date fechaInicio;
    
    
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    

    public Llamada(Cliente cliente, Estado estado) {
        this.cambioEstado = new ArrayList<CambioEstado>();
        cambioEstado.add(new CambioEstado(estado));
        this.cliente = cliente;

        this.fechaInicio = new Date();
    }

    // 5 tomadoPorOperador()
    // Setea la fecha fin del estado anterior.
    public void tomadaPorOperador(Estado estado, Date fechaEstadoEnCurso) {
        // 6 new()
        this.cambioEstado.get(this.cambioEstado.size() - 1).setFechaFin(fechaEstadoEnCurso);
        this.cambioEstado.add(new CambioEstado(estado));
    }

    public String getNombreClienteDeLlamada() {
        return this.getCliente().getNombreCompleto();
    }

    public boolean esInformacionCorrecta(String seleccion, Validacion validacion) {
        return this.getCliente().esInformacionCorrecta(seleccion, validacion);
    }

    // METODOS DE SETEO
    public String getDescripcionOperador() {
        return this.descripcionOperador;
    }

    public void setDescripcionOperador(String descripcionOperador) {
        this.descripcionOperador = descripcionOperador;
    }

    public String getDetalleAccionRequerida() {
        return this.detalleAccionRequerida;
    }

    public void setDetalleAccionRequerida(String detalleAccionRequerida) {
        this.detalleAccionRequerida = detalleAccionRequerida;
    }

    public long getDuracion() {
        return this.duracion;
    }

    public void setDuracion(Long duracion) {
        this.duracion = duracion;
    }

    public boolean isEncuestaEnviada() {
        return this.encuestaEnviada;
    }

    public boolean getEncuestaEnviada() {
        return this.encuestaEnviada;
    }

    public void setEncuestaEnviada(boolean encuestaEnviada) {
        this.encuestaEnviada = encuestaEnviada;
    }

    public String getObservacionAuditor() {
        return this.observacionAuditor;
    }

    public void setObservacionAuditor(String observacionAuditor) {
        this.observacionAuditor = observacionAuditor;
    }

    public ArrayList<CambioEstado> getCambioEstado() {
        return this.cambioEstado;
    }

    public void setCambioEstado(ArrayList<CambioEstado> cambioEstado) {
        this.cambioEstado = cambioEstado;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<SubOpcion> getSubOpcionesSeleccionadas() {
        return this.subOpcionesSeleccionadas;
    }

    public void setSubOpcionesSeleccionadas(ArrayList<SubOpcion> subOpcionesSeleccionadas) {
        this.subOpcionesSeleccionadas = subOpcionesSeleccionadas;
    }

    @Override
    public String toString() {
        return "{" +
                " descripcionOperador='" + getDescripcionOperador() + "'" +
                ", detalleAccionRequerida='" + getDetalleAccionRequerida() + "'" +
                ", duracion='" + getDuracion() + "'" +
                ", encuestaEnviada='" + isEncuestaEnviada() + "'" +
                ", observacionAuditor='" + getObservacionAuditor() + "'" +
                ", cambioEstado='" + getCambioEstado() + "'" +
                ", cliente='" + getCliente() + "'" +
                ", subOpcionesSeleccionadas='" + getSubOpcionesSeleccionadas() + "'" +
                "}";
    }

	public void registrarDescripcionOperador(String descripcionAccionRequerida) {
        this.setDescripcionOperador(descripcionAccionRequerida);
	}

    public void finalizarLlamada(Date fechaActual, Estado estadoFinalizado) {
        this.cambioEstado.get(this.cambioEstado.size() - 1).setFechaFin(fechaActual);
        this.calcularDuracion(this.getFechaInicio(), fechaActual);
        this.cambioEstado.add(new CambioEstado(estadoFinalizado));
    }
    
    public void cancelarLlamada(Date fechaActual, Estado estadoFinalizado) {
        this.cambioEstado.get(this.cambioEstado.size() - 1).setFechaFin(fechaActual);
        this.cambioEstado.add(new CambioEstado(estadoFinalizado));
    }

	public void calcularDuracion(Date fechaInicio, Date fechaFin) {
        long duracion = (fechaFin.getTime() - fechaInicio.getTime()) / 1000;
        this.setDuracion(duracion); // diferencia en milisegundos 
        System.out.println("La duracion en segundos es: " + duracion);
	}
    
}    