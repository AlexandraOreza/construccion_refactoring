
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class MetodosEmpleado implements Serializable {

    private ArrayList<Object> datosEmpleado = new ArrayList<Object>();

    // Constructor vacio
    public MetodosEmpleado() {
    }

    // Constructor con la lista de los datos del empleado
    public MetodosEmpleado(ArrayList<Object> datosEmpleado) {
        this.datosEmpleado = datosEmpleado;
    }

    // Metodos para agregar, modificar y eliminar datos del Empleado de la tabla
    public void agregarDatosEmpleado(Empleado empleado) {
        this.datosEmpleado.add(empleado);
    }

    public void modificarDatosEmpleado(int idEmpleado, Empleado empleado) {
        this.datosEmpleado.set(idEmpleado, empleado);
    }

    public void eliminarDatosEmpleado(Empleado empleado) {
        this.datosEmpleado.remove(empleado);
    }

    // Metodo para obtener los registros del empleado de la tabla
    public Empleado obtenerDatosEmpleado(int idEmpleado) {
        return (Empleado) datosEmpleado.get(idEmpleado);
    }

    // Metodo para evaluar la cantidad de empleados registrados
    public int cantidadEmpleadosRegistrados() {
        return this.datosEmpleado.size();
    }

    // Metodo para evaluar si existen ID´s iguales
    public int compararExistenteID(int idExistente) {
        for (int i = 0; i < cantidadEmpleadosRegistrados(); i++) {
            if (idExistente == obtenerDatosEmpleado(i).getIdEmpleado()) {
                return i;
            }
        }
        return -1;
    }
}
