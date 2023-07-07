/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Alexandra
 */
public class MetodosVentaTest {
    
    private MetodosVenta metodosVenta;
    private CSV csv;
    
    @Before
    public void setUpClass(){
        metodosVenta = new MetodosVenta();
        csv = new CSV();
    }
    /**
     * Test of getElectronicos method, of class MetodosVenta.
     */
    @Test
    public void testGetElectronicos() {
        List<String> electronicos = metodosVenta.getElectronicos();

        assertEquals(10, electronicos.size());
        assertEquals("MousePad", electronicos.get(0));
        assertEquals("Mouse", electronicos.get(1));
        assertEquals("Alexa Echo", electronicos.get(9));
    }

    /**
     * Test of getPrecioProducto method, of class MetodosVenta.
     */
    @Test
    public void testGetPrecioProducto() {
        Double precio = metodosVenta.getPrecioProducto(0);

        assertEquals(300.0, precio, 0.001);
    }

    /**
     * Test of calcularTotal method, of class MetodosVenta.
     */
    @Test
    public void testCalcularSubtotal_IVA_Total() {
        Double subtotal = 100.0;

        metodosVenta.calcularTotal(subtotal);

        assertEquals(subtotal, metodosVenta.getSubtotal(), 0.001);
        assertEquals(subtotal * 0.16, metodosVenta.getIVA(), 0.001);
        assertEquals(subtotal * 1.16, metodosVenta.getTotal(), 0.001);
    }
    
}
