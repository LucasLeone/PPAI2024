import java.util.ArrayList;
import java.util.Collections;

public class Vino {
	private Integer idVino;
    private String añada;
    private String fechaActualizacion;
    private String imagenEtiqueta;
    private String nombre;
    private String notaDeCataBodega;
    private Integer precioARS;
    private ArrayList<Varietal> varietal;
    private ArrayList<Maridaje> maridaje;
    private Bodega bodega;

    public Vino(Integer idVino, String añada, String fechaActualizacion, String imagenEtiqueta, String nombre, Integer precioARS, Bodega bodega, ArrayList<Varietal> varietales) {
        this.idVino = idVino;
    	this.añada = añada;
        this.fechaActualizacion = fechaActualizacion;
        this.imagenEtiqueta = imagenEtiqueta;
        this.nombre = nombre;
        this.precioARS = precioARS;
        this.bodega = bodega;
        this.varietal = varietales;
    }
    
    public String getAñada() {
        return this.añada;
    }

    public Integer getIdVino() {
		return idVino;
	}

	public void setIdVino(Integer idVino) {
		this.idVino = idVino;
	}

	public void setAñada(String añada) {
        this.añada = añada;
    }

    public String getFechaActualizacion() {
        return this.fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getImagenEtiqueta() {
        return this.imagenEtiqueta;
    }

    public void setImagenEtiqueta(String imagenEtiqueta) {
        this.imagenEtiqueta = imagenEtiqueta;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotaDeCataBodega() {
        return this.notaDeCataBodega;
    }

    public void setNotaDeCataBodega(String notaDeCataBodega) {
        this.notaDeCataBodega = notaDeCataBodega;
    }

    public Integer getPrecioARS() {
        return this.precioARS;
    }

    public void setPrecioARS(Integer precioARS) {
        this.precioARS = precioARS;
    }

    public ArrayList<Varietal> getVarietal() {
        return this.varietal;
    }

    public ArrayList<Maridaje> getMaridaje() {
        return this.maridaje;
    }

    public void setMaridaje(ArrayList<Maridaje> maridaje) {
        this.maridaje = maridaje;
    }

    public Bodega getBodega() {
        return this.bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    
    public void setVarietal(ArrayList<Varietal> varietalesActualizar) {
		ArrayList<Varietal> varietales = new ArrayList<>();
		for (Varietal varietal : varietalesActualizar) {
	        Collections.addAll(varietales, varietal);
	        varietal.setTipoUva(varietal.getTipoUva());
		}
		this.varietal = varietales;
    }

    public void actualizarVino(Vino vino, Vino vinoParaActualizar) {
    	vinoParaActualizar.setAñada(vino.getAñada());
    	vinoParaActualizar.setFechaActualizacion(vino.getFechaActualizacion());
    	vinoParaActualizar.setImagenEtiqueta(vino.getImagenEtiqueta());
    	vinoParaActualizar.setNombre(vino.getNombre());
    	vinoParaActualizar.setNotaDeCataBodega(vino.getNotaDeCataBodega());
    	vinoParaActualizar.setPrecioARS(vino.getPrecioARS());
    	vinoParaActualizar.setMaridaje(vino.getMaridaje());
		vinoParaActualizar.setVarietal(vino.getVarietal());
    }
    
    public void crearVarietal(TipoUva uva) {
    	Varietal varietalNuevo = new Varietal();
    	varietalNuevo.setTipoUva(uva);
    	this.setVarietal(varietal);
    }
    
    @Override
    public String toString() {
        return " - Añada: " + añada + ", fecha de actualizacion: " + fechaActualizacion + ", precio: $" + precioARS + ", bodega: " + bodega.getNombre() + ")";
    }

	public boolean perteneceABodegaSeleccionada(Bodega bodegaSeleccionada) {
		if (this.getBodega() == bodegaSeleccionada) {
			return true;
		} else {			
			return false;
		}
	}
}
