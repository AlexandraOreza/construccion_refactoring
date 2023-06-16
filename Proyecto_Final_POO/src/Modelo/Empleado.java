
package Modelo;

public class Empleado extends Persona implements PorPagar{
    // Atributos
    private double horasDeTrabajo;
    private String NSS;
    private int idEmpleado;

    // Constructor
    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, double horasDeTrabajo, String NSS,
            int idEmpleado) {
        // Llamamos al constructor de la clase abstracta padre
        super(nombre, apellidoPaterno, apellidoMaterno);
        this.horasDeTrabajo = horasDeTrabajo;
        this.NSS = NSS;
        this.idEmpleado = idEmpleado;
    }

    // Getters
    public double getHorasDeTrabajo() {
        return horasDeTrabajo;
    }

    public String getNSS() {
        return NSS;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    // Setters
    public void setHorasDeTrabajo(double horasDeTrabajo) {
        this.horasDeTrabajo = horasDeTrabajo;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public double obtenerMontoPago() {
        return getHorasDeTrabajo()*80*14;
    }
    
    // Metodo toString
    @Override
    public String toString() {
        return "[ ID: " + getIdEmpleado() + "]"
        // Llamamos al metodo toString de la super clase
                + super.toString()
                + "\n" + "Sueldo: $" + getHorasDeTrabajo()
                + "\n" + "Numero de Seguro Social: " + getNSS();
    }
}
