import java.util.ArrayList;
import java.util.Collections;

public class InterfazBodega {
	private ArrayList<Vino> vinos = new ArrayList<>();
    public ArrayList<TipoUva> dbTipoUva;
    public ArrayList<Varietal> dbVarietal;
    
	public ArrayList<Vino> obtenerActualizacionesBodegaSeleccionada(Bodega bodega) {
		System.out.println("Conectada a la API del Sistema de Bodega.");
		System.out.println("Se obtuvo 3 vinos.");
		
        // tipos de uva
        this.dbTipoUva = new ArrayList<TipoUva>();
        TipoUva tipoUva1 = new TipoUva("Cabernet");
        TipoUva tipoUva2 = new TipoUva("Mencia");
        TipoUva tipoUva3 = new TipoUva("Malbec");
        TipoUva tipoUva4 = new TipoUva("Syrah");
        Collections.addAll(dbTipoUva, tipoUva1, tipoUva2, tipoUva3, tipoUva4);

        // varietal
        this.dbVarietal = new ArrayList<Varietal>();
        Varietal varietal1 = new Varietal(tipoUva1);
        Varietal varietal2 = new Varietal(tipoUva1);
        Varietal varietal3 = new Varietal(tipoUva3);
        Varietal varietal4 = new Varietal(tipoUva4);
        Collections.addAll(dbVarietal, varietal1, varietal2, varietal3, varietal4);
        
        // Listas de varietales para cada vino
        ArrayList<Varietal> varietalesVino1 = new ArrayList<>();
        Collections.addAll(varietalesVino1, varietal1, varietal2);

        ArrayList<Varietal> varietalesVino2 = new ArrayList<>();
        Collections.addAll(varietalesVino2, varietal2);

        ArrayList<Varietal> varietalesVino3 = new ArrayList<>();
        Collections.addAll(varietalesVino3, varietal3, varietal4);
        
        // Vinos a crear
        Vino vino1 = new Vino("2020", "03/06/2024", "imagen1", "Tilin", 11200, bodega, varietalesVino1);
        Vino vino2 = new Vino("2022", "03/06/2024", "imagen2", "Valentin", 3200, bodega, varietalesVino2);
        
        // Vino a actualizar
        Vino vino3 = new Vino("2024", "03/06/2024", "imagen3", "Piel de cordero", 12000, bodega, varietalesVino3);
        
		this.vinos.add(vino1);
		this.vinos.add(vino2);
		this.vinos.add(vino3);
		
		return getVinos();
	}

	public ArrayList<Vino> getVinos() {
		return vinos;
	}
	
	
	
}
