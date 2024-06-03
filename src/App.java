public class App {

    public static DB db = new DB();

    public static void main(String[] args) throws Exception {
        GestorImportarActualizaciones gestor = new GestorImportarActualizaciones(db);
        gestor.habilitarPantalla();
    }
}