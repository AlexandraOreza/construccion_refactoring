/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Jesus
 */
public class MetodosProductos {
   private ArrayList<Object> datosProducto = new ArrayList<Object>();
    
    // Constructor vacio
    public MetodosProductos() {
    }
    
    // Constructor con la lista de los datos del producto
    public MetodosProductos(ArrayList<Object> datosProducto) {
        this.datosProducto= datosProducto;
    }
    
    // Metodos para agregar, modificar y eliminar datos del Empleado de la tabla
    public void agregarDatosProducto(Productos producto) {
        this.datosProducto.add(producto);
    }
    
    public void modificarDatosProducto(int claveP, Productos producto) {
        this.datosProducto.set(claveP, producto);
    }

    public void eliminarDatosProducto(Productos producto) {
        this.datosProducto.remove(producto);
    }
    
    // Metodo para obtener los registros del empleado de la tabla
    public Productos obtenerDatosProducto(int claveP) {
        return (Productos) datosProducto.get(claveP);
        
    }

    // Metodo para evaluar la cantidad de empleados registrados
    public int cantidadProductoRegistrados() {
        return this.datosProducto.size();
    }

    // Metodo para evaluar si existen ID´s iguales
    public int compararExistenteID(int claveP) {
        for (int i = 0; i < cantidadProductoRegistrados(); i++) {
            if (claveP == obtenerDatosProducto(i).getClaveP()) {
                return i;
            }
        }
        return -1;
    } 
}
