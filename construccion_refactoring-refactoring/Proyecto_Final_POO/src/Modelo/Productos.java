
package Modelo;



public class Productos{
    // Atributos de clase
    private String nombreProducto;
    private int cantidad;
    private int claveP;
    private String descripcion;
    private double precio;
    private double importe;

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    

    // Constructor del producto
    

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