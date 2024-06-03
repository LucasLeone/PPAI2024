import java.util.ArrayList;

public class GestorImportarActualizaciones {
    private ArrayList<Bodega> bodegas = new ArrayList<>();
    private Bodega bodegaSeleccionada;
    private ArrayList<Enofilo> enofilos = new ArrayList<>();
    private String fechaActual = "03/06/2024";
    private ArrayList<TipoUva> tiposUva;
    private ArrayList<Vino> vinos;
    private DB db;
    private PantallaImportarActualizaciones pantallaImportarActualizaciones;
    private InterfazBodega interfazBodega = new InterfazBodega();
    private InterfazPush interfazPush = new InterfazPush();

    public GestorImportarActualizaciones(DB db) {
        this.db = db;
    }
    
    public void crearPantalla() {
    	this.pantallaImportarActualizaciones = new PantallaImportarActualizaciones(this);
        pantallaImportarActualizaciones.setVisible(true);
    }

    public void importarActualizacionVinos() {
    	// PASO 1
    	this.fechaActual = getFechaActual();
    	this.buscarBodegasConActualizacionDisponible();
    }

    public void buscarBodegasConActualizacionDisponible() {
    	// PASO 2
        ArrayList<Bodega> bodegasConActualizacion = new ArrayList<>();

        for (Bodega bodega : db.dbBodega) {
            if (bodega.tieneActualizacionDisponible(this.getFechaActual())) {
                bodegasConActualizacion.add(bodega);
                System.out.println("Bodega " + bodega.getNombre() + " tiene una actualización disponible.");
            }
        }

        this.setBodegas(bodegasConActualizacion);
        
        // PASO 3
        this.pantallaImportarActualizaciones.mostrarBodegasConActualizacionDisponible(this.bodegas);
    }
    
    public void tomarSeleccionBodega(Bodega bodega) {
    	// PASO 4
    	this.setBodegaSeleccionada(bodega);
    	this.buscarActualizacionesBodegaSeleccionada(bodega);
    }
    
    public void buscarActualizacionesBodegaSeleccionada(Bodega bodega) {
    	// PASO 5
    	ArrayList<Vino> vinosInterfaz = interfazBodega.obtenerActualizacionesBodegaSeleccionada(bodega);
    	// PASO 6
    	this.actualizarVinosBodega(vinosInterfaz);
    	this.crearVinoNoExistenteEnLaBodega(vinosInterfaz);
    	this.setVinos(vinosInterfaz);
    	this.pantallaImportarActualizaciones.mostrarVinosCreadosOActualizados(vinos);
    	// PASO 7
    	this.enviarNotificacionEnofilosConNovedades();
    }
    
    public void actualizarVinosBodega(ArrayList<Vino> vinosInterfaz) {
    	this.obtenerTiposUva();
    	
    	for (Vino vino : vinosInterfaz) {
    		if (vino.perteneceABodegaSeleccionada(this.getBodegaSeleccionada())) {
    			for (Vino vinoDB : db.getDbVino()) {
    				if (vinoDB.getIdVino() == vino.getIdVino()) {
    					vinoDB.actualizarVino(vino, vinoDB);
    				}
    			}
    		}
    	}
    }
    
    public void obtenerTiposUva() {
    	this.setTiposUva(db.getDbTipoUva());
    }
    
    public void crearVinoNoExistenteEnLaBodega(ArrayList<Vino> vinosInterfaz) {
    	for (Vino vino : vinosInterfaz) {
    		this.db.agregarVino(vino);
    		vino.crearVarietal(this.tiposUva.get(0));
    	}
    }
    
    public void enviarNotificacionEnofilosConNovedades() {
    	for (Siguiendo siguiendo : db.getDbSiguiendo()) {
    		if (siguiendo.sigueABodega(this.bodegaSeleccionada)) {
    			enofilos.add(siguiendo.getEnofilo());
    		}
    	}
    	
    	this.notificarEnofilos(enofilos);
    }
    
    public void notificarEnofilos(ArrayList<Enofilo> enofilos) {
    	this.interfazPush.enviarNotificacionPush();
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
    	return this.fechaActual;
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
