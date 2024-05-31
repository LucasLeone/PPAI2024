public class App {

    public static DB db = new DB();

    public static void main(String[] args) throws Exception {
        // CASO DE USO ANTERIOR, nos brinda estos datos: :)
        GestorRtaOperador gestor = new GestorRtaOperador(db);
        Categoria categoria = db.dbCategoria.get(0);
        Llamada llamada = db.dbLlamadas.get(0);
        Opcion opcion = db.dbOpcion.get(0);
        SubOpcion subOpcion = db.dbSubOpcion.get(0);
        String horaInicio = "12:00";
        String fechaInicio = "12/12/2020";
        gestor.nuevaRespuestaOperador(llamada, categoria, opcion, subOpcion, horaInicio, fechaInicio);
    }
}