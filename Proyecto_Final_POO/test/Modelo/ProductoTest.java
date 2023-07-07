/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Alexandra
 */
public class ProductoTest {
    private Producto producto;
    
    @Before
    public void setUpClass(){
        producto = new Producto();
    }

    /**
     * Test of getNombreProducto method, of class Producto.
     */
    @Test
    public void testGetYSetNombreProducto() {
        String nombreProducto = "Producto A";

        producto.setNombreProducto(nombreProducto);
        String result = producto.getNombreProducto();

        assertEquals(nombreProducto, result);
    }

    /**
     * Test of getCantidad method, of class Producto.
     */
    @Test
    public void testGetYSetCantidad() {
        int cantidad = 10;

        producto.setCantidad(cantidad);
        int result = producto.getCantidad();

        assertEquals(cantidad, result);
    }
    /**
     * Test of getIdProducto method, of class Producto.
     */
    @Test
    public void testGetYSetIdProducto() {
        int idProducto = 1;

        producto.setIdProducto(idProducto);
        int result = producto.getIdProducto();

        assertEquals(idProducto, result);
    }

    /**
     * Test of getDescripcion method, of class Producto.
     */
    @Test
    public void testGetYSetDescripcion() {
        String descripcion = "Descripcion A";

        producto.setDescripcion(descripcion);
        String result = producto.getDescripcion();

        assertEquals(descripcion, result);
    }

    /**
     * Test of getPrecio method, of class Producto.
     */
    @Test
    public void testGetYSetPrecio() {
        double precio = 100.0;

        producto.setPrecio(precio);
        double result = producto.getPrecio();

        assertEquals(precio, result, 0.001);
    }

    /**
     * Test of getImporte method, of class Producto.
     */
    @Test
    public void testGetYSetImporte() {
        double importe = 500.0;

        producto.setImporte(importe);
        double result = producto.getImporte();

        assertEquals(importe, result, 0.001);
    }
    
    /**
     * Test of constructor method, of class Producto.
     */
    @Test
    public void testConstructor() {
        String nombreProducto = "Product A";
        int cantidad = 10;
        int idProducto = 1;
        String descripcion = "Description A";
        double precio = 100.0;

        producto = new Producto(nombreProducto, cantidad, idProducto, descripcion, precio);

        assertEquals(nombreProducto, producto.getNombreProducto());
        assertEquals(cantidad, producto.getCantidad());
        assertEquals(idProducto, producto.getIdProducto());
        assertEquals(descripcion, producto.getDescripcion());
        assertEquals(precio, producto.getPrecio(), 0.001);
    }
}
