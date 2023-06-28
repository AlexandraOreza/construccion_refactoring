
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class MetodosAdministrador implements Serializable {

    private ArrayList<Object> datosAdministrador = new ArrayList<Object>();

    // Constructor vacio
    public MetodosAdministrador() {
    }

    // Constructor con la lista de los datos del empleado
    public MetodosAdministrador(ArrayList<Object> datosAdministrador) {
        this.datosAdministrador= datosAdministrador;
    }

    // Metodos para agregar, modificar y eliminar datos del Empleado de la tabla
    public void agregarDatosAdministrador(Administrador administrador) {
        this.datosAdministrador.add(administrador);
    }

    public void modificarDatosAdministrador(int idAdministrador, Administrador administrador) {
        this.datosAdministrador.set(idAdministrador, administrador);
    }

    public void eliminarDatosAdministrador(Administrador administrador) {
        this.datosAdministrador.remove(administrador);
    }

    // Metodo para obtener los registros del empleado de la tabla
    public Administrador obtenerDatosAdministrador(int idAdministrador) {
        return (Administrador) datosAdministrador.get(idAdministrador);
        
    }

    // Metodo para evaluar la cantidad de empleados registrados
    public int cantidadAdministradorRegistrados() {
        return this.datosAdministrador.size();
    }

    // Metodo para evaluar si existen ID´s iguales
    public int compararExistenteID(int idExistente) {
        for (int i = 0; i < cantidadAdministradorRegistrados(); i++) {
            if (idExistente == obtenerDatosAdministrador(i).getIdAdministrador()) {
                return i;
            }
        }
        return -1;
    }
}
