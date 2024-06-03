public class Siguiendo {
    private Bodega bodega;
    private Enofilo enofilo;

    public Siguiendo(Bodega bodega, Enofilo enofilo) {
        this.bodega = bodega;
        this.enofilo = enofilo;
    }

    public Enofilo getEnofilo() {
        return this.enofilo;
    }

    public void setEnofilo(Enofilo enofilo) {
        this.enofilo = enofilo;
    }

    public Bodega getBodega() {
        return this.bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    
    public Boolean sigueABodega(Bodega bodega) {
    	if (this.getBodega() == bodega) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
