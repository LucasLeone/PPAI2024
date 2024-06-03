import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorImportarActualizaciones {
    private ArrayList<Bodega> bodegas = new ArrayList<>();
    private Bodega bodegaSeleccionada;
    private ArrayList<Enofilo> enofilos;
    private String fechaActual;
    private Bodega infoBodegaSeleccionada;
    private ArrayList<TipoUva> tiposUva;
    private ArrayList<Vino> vinos;
    private DB db;
    private PantallaImportarActualizaciones pantallaImportarActualizaciones;
    private InterfazBodega interfazBodega = new InterfazBodega();
    private InterfazPush interfazPush = new InterfazPush();

    public GestorImportarActualizaciones(DB db) {
        this.db = db;
    }

    public void importarActualizacionVinos() {
    	this.fechaActual = getFechaActual();
    	this.pantallaImportarActualizaciones = new PantallaImportarActualizaciones(this);
        pantallaImportarActualizaciones.setVisible(true);
    }

    public void buscarBodegasConActualizacionDisponible() {
        ArrayList<Bodega> bodegasConActualizacion = new ArrayList<>();

        for (Bodega bodega : db.dbBodega) {
            if (bodega.tieneActualizacionDisponible(this.getFechaActual())) {
                bodegasConActualizacion.add(bodega);
                System.out.println("Bodega " + bodega.getNombre() + " tiene una actualización disponible.");
            }
        }

        this.bodegas = bodegasConActualizacion;
        
        this.pantallaImportarActualizaciones.mostrarBodegasConActualizacionDisponible(this.bodegas);
    }
    
    public void tomarSeleccionBodega(Bodega bodega) {
    	this.setBodegaSeleccionada(bodega);
    	this.buscarActualizacionesBodegaSeleccionada(bodega);
    }
    
    public void buscarActualizacionesBodegaSeleccionada(Bodega bodega) {
    	ArrayList<Vino> vinosInterfaz = interfazBodega.obtenerActualizacionesBodegaSeleccionada(bodega);
    	this.actualizarVinosBodega(vinosInterfaz);
    	this.crearVinoNoExistenteEnLaBodega(vinosInterfaz);
    }
    
    public void actualizarVinosBodega(ArrayList<Vino> vinosInterfaz) {
    	this.obtenerTiposUva();
    	
    	for (Vino vino : vinosInterfaz) {
    		if (vino.perteneceABodegaSeleccionada(this.getBodegaSeleccionada())) {
    			System.out.println("SEGUIR CON LA ACTUALIZACION");
    		}
    	}
    }
    
    public void obtenerTiposUva() {
    	this.setTiposUva(db.getDbTipoUva());
    }
    
    public void crearVinoNoExistenteEnLaBodega(ArrayList<Vino> vinosInterfaz) {
    	for (Vino vino : vinosInterfaz) {
    		this.db.agregarVino(vino);
    	}
    	
    	this.pantallaImportarActualizaciones.mostrarVinosCreadosOActualizados(vinosInterfaz);
    	this.enviarNotificacionEnofilosConNovedades();
    }
    
    public void enviarNotificacionEnofilosConNovedades() {
    	ArrayList<Enofilo> enofilos = new ArrayList<>();
    	
    	for (Siguiendo siguiendo : db.getDbSiguiendo()) {
    		if (siguiendo.sigueABodega(this.bodegaSeleccionada)) {
    			enofilos.add(siguiendo.getEnofilo());
    		}
    	}
    	
    	this.notificarEnofilos(enofilos);
    }
    
    public void notificarEnofilos(ArrayList<Enofilo> enofilos) {
    	this.interfazPush.enviarNotificacionPush();
    	System.out.println("Notificacion enviada.");
    	this.actualizarPeriodoActualizacionBodega();
    }
    
    public void actualizarPeriodoActualizacionBodega() {
    	this.bodegaSeleccionada.setPeriodoActualizacion(6);
    	this.finCU();
    }

    public void finCU() {
    	System.out.println("FIN DE CASO DE USO");
    }
    
    // metodos get and set
    public String getFechaActual() {
    	return "03/06/2024";
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

    public void setFechaActual(String fechaActual) {
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
