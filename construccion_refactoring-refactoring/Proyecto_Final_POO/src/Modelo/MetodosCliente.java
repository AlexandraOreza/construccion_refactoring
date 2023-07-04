/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class MetodosCliente implements Serializable{
    
    private ArrayList<Object> datosCliente = new ArrayList<>();

    // Constructor vacio
    public MetodosCliente() {
    }

    //Constructor con la lista de los datos del cliente
    public MetodosCliente(ArrayList<Object> datosCliente){
        this.datosCliente = datosCliente;
    }

    // Metodos para agregar, modificar y eliminar datos del Cliente de la tabla
    public void agregarDatosCliente(Cliente cliente){
        this.datosCliente.add(cliente);
    }
    public void modificarDatosCliente(int idCliente, Cliente cliente){
        this.datosCliente.set(idCliente, cliente);
    }
    public void eliminarDatosCliente(Cliente cliente){
        this.datosCliente.remove(cliente);
    }
    
    // Metodo para obtener los registros del cliente de la tabla
    public Cliente obtenerDatosCliente(int idCliente){
        return (Cliente) datosCliente.get(idCliente);
    }
    
    // Metodo para evaluar la cantidad de clientes registrados
    public int cantidadClientesRegistrados(){
        return this.datosCliente.size();
    }

    // Metodo para evaluar si existen ID´s iguales
    public int compararExistenteID(int idExistente){
        for(int i = 0; i < cantidadClientesRegistrados(); i++){
            if(idExistente == obtenerDatosCliente(i).getIdCliente()){
                return i;
            }
        }
        return -1;
    }
    
}
