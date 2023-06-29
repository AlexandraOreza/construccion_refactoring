/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author mario
 */
public class Administrador{
    
    // Atributos
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private double sueldo;
    private String usuario;
    private int idAdministrador;
    private String contrasenia;

    // Constructor
    public Administrador(String nombre, String apellidoPaterno, String apellidoMaterno, double sueldo, String usuario, int idAdministrador, String contrasenia) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sueldo = sueldo;
        this.usuario = usuario;
        this.idAdministrador = idAdministrador;
        this.contrasenia = contrasenia;
    }
    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public double getSueldo() {
        return sueldo;
    }
    public String getUsuario() {
        return usuario;
    }
    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
}
