public class Varietal {
    private TipoUva tipoUva;

    public Varietal(TipoUva tipoUva) {
        this.tipoUva = tipoUva;
    }

    public Varietal() {
	}

	public TipoUva getTipoUva() {
        return this.tipoUva;
    }

    public void setTipoUva(TipoUva tipoUva) {
        this.tipoUva = tipoUva;
    }
}
