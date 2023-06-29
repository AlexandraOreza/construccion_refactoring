
package Modelo;

import java.util.ArrayList;

public class MetodosAdministrador {

    private ArrayList<Object> datosAdministrador = new ArrayList<>();
    private CSV csv = new CSV();
    private final String nombreArchivo = "Administradores.csv";
    // Constructor vacio
    public MetodosAdministrador() {
    }


    // Metodos para agregar, modificar y eliminar datos del Empleado de la tabla
    public void agregarDatosAdministrador(Administrador administrador) {
        csv.agregarFilaDatos(nombreArchivo, administrador);
    }

    public void modificarDatosAdministrador(int idAdministrador, Administrador administrador) {
        csv.modificarFilaDatos(nombreArchivo, idAdministrador, datosAdministrador);
    }

    public void eliminarDatosAdministrador(int idAdministrador) {
        csv.eliminarFilaDatos(nombreArchivo, idAdministrador);
    }

    public boolean existeId(int idAdministrador){
        return csv.existeId(nombreArchivo, idAdministrador);
    }
    
    // Metodo para evaluar la cantidad de empleados registrados
    public int cantidadAdministradorRegistrados() {
        return this.datosAdministrador.size();
    }

}
