import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorImportarActualizaciones {
    private ArrayList<Bodega> bodegas = new ArrayList<>();
    private Bodega bodegaSeleccionada;
    private ArrayList<Enofilo> enofilos;
    private Date fechaActual = new Date();
    private Bodega infoBodegaSeleccionada;
    private ArrayList<TipoUva> tiposUva;
    private ArrayList<Vino> vinos;
    private DB db;
    private PantallaImportarActualizaciones pantallaImportarActualizaciones;
    private SistemaDeBodega sistemaDeBodega;

    public GestorImportarActualizaciones(DB db, SistemaDeBodega sistemaDeBodega) {
        this.db = db;
        this.sistemaDeBodega = sistemaDeBodega;
    }

    public void importarActualizacionVinos() {
        buscarBodegasConActualizacionDisponible();
        pantallaImportarActualizaciones = new PantallaImportarActualizaciones(this, bodegas);
        pantallaImportarActualizaciones.setVisible(true);
    }

    public void buscarBodegasConActualizacionDisponible() {
        ArrayList<Bodega> bodegasConActualizacion = new ArrayList<>();

        for (Bodega bodega : db.dbBodega) {
            if (bodega.tieneActualizacionDisponible()) {
                bodegasConActualizacion.add(bodega);
                System.out.println("Bodega " + bodega.getNombre() + " tiene una actualización disponible.");
            }
        }

        this.bodegas = bodegasConActualizacion;
    }

    public void buscarActualizacionesBodegaSeleccionada(Bodega bodega) {
        this.bodegaSeleccionada = bodega;
        ArrayList<String> vinosInfo = sistemaDeBodega.actualizarYCrearVinos(bodega);
        pantallaImportarActualizaciones.mostrarInformacionVinos(bodega.getNombre(), vinosInfo);
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

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }

    public PantallaImportarActualizaciones getPantallaImportarActualizaciones() {
        return pantallaImportarActualizaciones;
    }

    public void setPantallaImportarActualizaciones(PantallaImportarActualizaciones pantallaImportarActualizaciones) {
        this.pantallaImportarActualizaciones = pantallaImportarActualizaciones;
    }
}
