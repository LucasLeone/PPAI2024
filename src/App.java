public class App {

    public static DB db = new DB();

    public static void main(String[] args) throws Exception {
        // CASO DE USO ANTERIOR, nos brinda estos datos: :)
        GestorImportarActualizaciones gestor = new GestorImportarActualizaciones(db);
        gestor.habilitarPantalla();
    }
}