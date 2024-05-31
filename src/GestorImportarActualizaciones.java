import java.util.ArrayList;
import java.util.Date;

public class GestorImportarActualizaciones {
    private ArrayList<Bodega> bodegas = new ArrayList<>();
    private Bodega bodegaSeleccionada;
    private ArrayList<Enofilo> enofilos;
    private Date fechaActual = new Date();
    private Bodega infoBodegaSeleccionada;
    private ArrayList<TipoUva> tiposUva;
    private ArrayList<Vino> vinos;

    public void importarActualizacionVinos() {
        this.buscarBodegasConActualizacionDisponible(this.getFechaActual());
    }

    public void buscarBodegasConActualizacionDisponible(Date fechaActual) {
        ArrayList<Bodega> bodegasConActualizacion = new ArrayList<>();

        for (Bodega bodega : bodegas) {
            if (bodega.tieneActualizacionDisponible(fechaActual)) {
                bodegasConActualizacion.add(bodega);
                System.out.println("Bodega " + bodega.getNombre() + " tiene una actualización disponible.");
            }
        }

        this.setBodegas(bodegasConActualizacion);
    }

    // Métodos get y set del gestor
    public ArrayList<Bodega> getBodegas() {
        return this.bodegas;
    }

    public void setBodegas(ArrayList<Bodega> bodegas) {
        this.bodegas = bodegas;
    }

    public Bodega getBodegaSeleccionada() {
        return this.bodegaSeleccionada;
    }

    public void setBodegaSeleccionada(Bodega bodegaSeleccionada) {
        this.bodegaSeleccionada = bodegaSeleccionada;
    }

    public ArrayList<Enofilo> getEnofilos() {
        return this.enofilos;
    }

    public void setEnofilos(ArrayList<Enofilo> enofilos) {
        this.enofilos = enofilos;
    }

    public Date getFechaActual() {
        return this.fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Bodega getInfoBodegaSeleccionada() {
        return this.infoBodegaSeleccionada;
    }

    public void setInfoBodegaSeleccionada(Bodega infoBodegaSeleccionada) {
        this.infoBodegaSeleccionada = infoBodegaSeleccionada;
    }

    public ArrayList<TipoUva> getTiposUva() {
        return this.tiposUva;
    }

    public void setTiposUva(ArrayList<TipoUva> tiposUva) {
        this.tiposUva = tiposUva;
    }

    public ArrayList<Vino> getVinos() {
        return this.vinos;
    }

    public void setVinos(ArrayList<Vino> vinos) {
        this.vinos = vinos;
    }
}
