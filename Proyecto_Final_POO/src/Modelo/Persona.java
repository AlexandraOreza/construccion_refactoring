
package Modelo;




public abstract class Persona {
    // Atributos
    public String nombre;
    public String apellidoPaterno;
    public String apellidoMaterno;

    // Constructor
    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno){
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno();
    }

}
