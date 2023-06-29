
package Modelo;



public class Productos{
    // Atributos de clase
    private String nombreProducto;
    private int cantidad;
    private int claveP;
    private String descripcion;
    private double precio;

    // Constructor del producto
    
    public Productos(String nombreProducto, int cantidad, int claveP, String descripcion, double precio){
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.claveP = claveP;
        this.descripcion = descripcion;
        this.precio = precio;   
        
    }
    
    // Metodos get
    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getClaveP() {
        return claveP;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    

    // Metodos set
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setClaveP(int claveP) {
        this.claveP = claveP;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    

}