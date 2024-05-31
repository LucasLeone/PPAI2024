import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Date;

import javax.swing.text.StyledEditorKit.BoldAction;

public class GestorRtaOperador {
    private Categoria categoriaSeleccionada;
    private String horaInicio;
    private String fechaInicio;
    private Llamada llamada;
    private PantallaRtaOperador PantallaRtaOperador;
    private Estado estadoActual;
    private Estado estadoFinalizado;
    private Estado estadoCancelado;
    private Opcion opcion;
    private SubOpcion subOpcion;
    private ArrayList<CambioEstado> cambiosEstado;
    private DB db;
    private Cliente cliente;
    private String nombreCliente;
    private HashMap<String, Validacion> validaciones;
    private HashMap<Validacion, Boolean> validacionesBool;
    private HashMap<String, Accion> acciones;
    private Accion accionRequerida;
    private String descripcionAccionRequerida;
    private Boolean confirmacion;

    // Metodos CU

    public HashMap<String, Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(HashMap<String, Accion> acciones) {
        this.acciones = acciones;
    }

    public HashMap<String, Validacion> getValidaciones() {
        return validaciones;
    }

    // 1 nuevaRespuestaOperador()
    // Setear todas las variables y llamar la funcion recibirLlamada().
    public void nuevaRespuestaOperador(Llamada llamada, Categoria categoria, Opcion opcion, SubOpcion subOpcion,
            String fechaInicio, String horaInicio) {
        this.setCategoriaSeleccionada(categoria);
        this.setLlamada(llamada);
        this.setOpcion(opcion);
        this.setSubOpcion(subOpcion);
        this.setPantallaRtaOperador(new PantallaRtaOperador(this));
        this.setHoraInicio(horaInicio);
        this.setFechaInicio(fechaInicio);
        this.setCliente(this.llamada.getCliente());

        recibirLlamada();
        System.out.println("Paso 1");
    }

    // 2 recibirLlamada() // 5 tomadoPorOperador()
    /**
     * Recibe una llamada y realiza una serie de pasos para procesarla.
     * Paso 1: busca el estado en 'En Curso' y lo setea como actual. Establece la fecha final del anterior y la fecha inicial del estado actual.
     * Paso 2: obtiene el nombre del cliente y de la categoria de la llamada y los setea en la llamada actual.
     * Paso 3: setea la validacion dependiendo de la categoria seleccionada y se muestran los datos de la llamada.
     * Paso 4: traer todas las validaciones y setearlas en False. Luego, iterar por cada una de ellas y pedir los datos.
     * Paso 5: busca todas las acciones y las setea.
     * Paso 6: solicita la accion y una descripcion de la respuesta del operador y la setea.
     * Paso 7: la pantalla solicita la confirmacion y finaliza el caso de uso.
     */
    public void recibirLlamada() {
        this.setEstadoActual(this.buscarEstadoEnCurso());
        System.out.println("Paso 2");
        Date fechaEstadoEnCurso=this.obtenerFechaYHoraActual();
        // Setea la fecha fin del estado anterior.
        this.llamada.tomadaPorOperador(this.getEstadoActual(), fechaEstadoEnCurso); // 5 tomadoPorOperador()
        System.out.println("Paso 3");
        // Trae y setea el nombre del cliente. Lo mismo con la categoria.
        this.obtenerDatosLlamada();
        System.out.println("Paso 4  (debe mostrar pantalla)");
        // Setea la validacion dependiendo de la categoria seleccionada. Se muestran los datos de la llamada.
        this.buscarValidaciones();
        // Traer todas las validaciones y setearlas en false. Luego iterar por ellas e ir pidiendo los datos requeridos.
        this.validarCliente(); 
        System.out.println("Paso 5");
        this.setAcciones(this.buscarAcciones());
        System.out.println("Paso 6");
        this.PantallaRtaOperador.solicitarAccionDescripcionRequerida(acciones);
        System.out.println("Paso 7");
        this.registrarDescripcionOperador();

        this.llamada.toString();
    }
    public void finCU(){
        System.out.println("FIN DE CASO DE USO");
        System.exit(0);
    }
    public void registrarDescripcionOperador(){
        this.llamada.registrarDescripcionOperador(descripcionAccionRequerida);
    }
    public Date obtenerFechaYHoraActual(){
        Date date = new Date();
        return date;
    }
    public void finalizarLlamada(){
        Date fechaActual=this.obtenerFechaYHoraActual();
        estadoFinalizado=this.buscarEstadoFinalizada();
        this.llamada.finalizarLlamada(fechaActual, estadoFinalizado);
    }
    public Estado buscarEstadoFinalizada() {
        for (int i = 0; i < db.dbEstado.size(); i++) {
            if (db.dbEstado.get(i).esFinalizada()) {
                return db.dbEstado.get(i);
            }
        }
        return null;

    }

    // Traer todas las validaciones y setearlas en false. Luego iterar por ellas e ir pidiendo los datos requeridos.
    public void validarCliente() {
        validacionesBool=new HashMap<Validacion, Boolean>();
        for (Validacion val : validaciones.values()){
            validacionesBool.put(val,false);
        }
        for (String val : validaciones.keySet()){
            if (validacionesBool.get(validaciones.get(val)) == false){
                this.PantallaRtaOperador.solicitarValidacionRequerida(val, validaciones.get(val));
            }
            
            while (true){
                if (validacionesBool.get(validaciones.get(val))){
                    break;
                }else{
                    continue;
                }
            }
        }
    }

    // 3 buscarEstadoEnCurso()
    // Busca por todos los estados cual es el En Curso y lo devuelve.
    public Estado buscarEstadoEnCurso() {
        for (int i = 0; i < db.dbEstado.size(); i++) {
            if (db.dbEstado.get(i).esEnCurso()) {
                return db.dbEstado.get(i);
                
            }
        }
        return null;

    }
    
    // Busca por todos los estados cual es el Cancelado y lo devuelve.
    public Estado buscarEstadoCancelado() {
        for (int i = 0; i < db.dbEstado.size(); i++) {
            if (db.dbEstado.get(i).esCancelado()) {
                return db.dbEstado.get(i);
            }
        }
        return null;

    }

    // 7 obtenerDatosLlamada()
    // Trae y setea el nombre del cliente. Lo mismo con la categoria.
    public void obtenerDatosLlamada() {
        this.setNombreCliente(this.llamada.getNombreClienteDeLlamada());
        this.categoriaSeleccionada.getDescripcionCompletaCategoriaYOpcion(opcion, subOpcion);
    }

    //

    // 13
    // Setea la validacion dependiendo de la categoria seleccionada. Se muestran los datos de la llamada.
    public void buscarValidaciones() {
        this.setValidaciones(this.categoriaSeleccionada.buscarValidaciones(opcion, subOpcion));
        this.PantallaRtaOperador.mostrarDatosLlamada(cliente, categoriaSeleccionada, subOpcion,
                opcion );
        System.out.println("buscar y mostrar validaciones");
    }

    public boolean tomarDatoValidacion(String seleccion, Validacion validacion) {
        return this.validarInformacionCliente(seleccion, validacion);
    }

    // Setear las variables de accion y su descripcion. Solicita la confirmacion.
    public void tomarAccionDescripcionRequerida(Accion accion,String descripcion) {
        this.accionRequerida=accion;
        this.descripcionAccionRequerida=descripcion;
        System.out.println(accion.toString());
        System.out.println(descripcion);
        this.PantallaRtaOperador.solicitarConfirmacion();
    }

    // Setea la confirmacion y termina el flujo de trabajo.
    public void tomarConfirmacion(Boolean bol) {
        this.confirmacion=bol;
        System.out.println("Paso 8");
        this.finalizarLlamada();
        this.PantallaRtaOperador.informarAccionRegistrada();
        this.finCU();
        
        for (int i = 0; i < llamada.getCambioEstado().size(); i++) {
    		System.out.println(llamada.getCambioEstado().get(i).toString());
		}
        System.out.println(llamada.toString());
    }

    // Valida si la informacion del cliente es correcta.
    public boolean validarInformacionCliente(String seleccion, Validacion validacion) {
        System.out.println(seleccion);
        System.out.println(this.getLlamada().esInformacionCorrecta(seleccion, validacion));
        if (this.getLlamada().esInformacionCorrecta(seleccion, validacion)){
            validacionesBool.put(validacion,true);
            
        }
        return this.getLlamada().esInformacionCorrecta(seleccion, validacion);
    }

    // 27 Buscar acciones
    public HashMap<String, Accion> buscarAcciones() {
        HashMap<String, Accion> acciones = new HashMap<String, Accion>();
        for (Accion ac : db.dbAccion) {
            acciones.put(ac.getNombre(), ac);
        }
        return acciones;
    }
    
    
    // FLUJO ALTERNATIVO
    
    public void cancelarLlamada() {
        Date fechaActual=this.obtenerFechaYHoraActual();
    	estadoCancelado = this.buscarEstadoCancelado();
    	this.llamada.cancelarLlamada(fechaActual, estadoCancelado);
    	System.out.println("Se actualizo estado");
        
    	for (int i = 0; i < llamada.getCambioEstado().size(); i++) {
    		System.out.println(llamada.getCambioEstado().get(i).toString());
		}
    	System.out.println("Llamada colgada por el cliente");
        this.finCU();
  
    }

    // METODOS DE SETEO
    public void setValidaciones(HashMap<String, Validacion> validaciones) {
        this.validaciones = validaciones;
    }

    public GestorRtaOperador(DB db) {
        this.cambiosEstado = new ArrayList<CambioEstado>();
        this.db = db;
    }

    public Categoria getCategoriaSeleccionada() {
        return this.categoriaSeleccionada;
    }

    public void setCategoriaSeleccionada(Categoria categoriaSeleccionada) {
        this.categoriaSeleccionada = categoriaSeleccionada;
    }

    public String getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Llamada getLlamada() {
        return this.llamada;
    }

    public void setLlamada(Llamada llamada) {
        this.llamada = llamada;
    }

    public PantallaRtaOperador getPantallaRtaOperador() {
        return this.PantallaRtaOperador;
    }

    public void setPantallaRtaOperador(PantallaRtaOperador PantallaRtaOperador2) {
        this.PantallaRtaOperador = PantallaRtaOperador2;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estado getEstadoActual() {
        return this.estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Opcion getOpcion() {
        return this.opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    public SubOpcion getSubOpcion() {
        return this.subOpcion;
    }

    public void setSubOpcion(SubOpcion subOpcion) {
        this.subOpcion = subOpcion;
    }

    public ArrayList<CambioEstado> getCambiosEstado() {
        return this.cambiosEstado;
    }

    public void setCambiosEstado(CambioEstado nuevoCambioEstado) {
        this.cambiosEstado.add(nuevoCambioEstado);
    }

    public String getNombreCliente() {
        return this.nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

}