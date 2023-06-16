
package Modelo;

public class Cliente extends Persona {
    // Atributos
    private int idCliente;

    
    // Constructor
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, int idCliente) {
        super(nombre, apellidoPaterno, apellidoMaterno);
        this.idCliente = idCliente;
    }

    // Getters
    public int getIdCliente() {
        return idCliente;
    }

    // Setters
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // Metodo toString
    @Override
    public String toString() {
        // Llamamos al metodo toString de la super clase
        return super.toString() + "\n" + "ID: " + getIdCliente();
    }
    
    public String getIDString (){
        return String.valueOf(this.idCliente);
    }
    
}


