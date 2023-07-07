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
public class VentaTest {
    
    private Venta venta;
    private Double subtotal;
    
    @Before
    public void setUpClass(){
        venta = new Venta();
        subtotal = 100.0;
    }
    /**
     * Test of setSubtotal and getSubtotal method, of class Venta.
     */
    @Test
    public void testSetYGetSubtotal() {
        venta.setSubtotal(subtotal);
        Double result = venta.getSubtotal();

        assertEquals(subtotal, result, 0.001);
    }
    /**
     * Test of setIVA and getIVA method, of class Venta.
     */
    @Test
    public void testSetIVAYGetIVA() {
        Double expectedIVA = subtotal * 0.16;

        venta.setSubtotal(subtotal);
        venta.setIVA();
        Double result = venta.getIVA();

        assertEquals(expectedIVA, result, 0.001);
    }

    /**
     * Test of setTotal and getTotal method, of class Venta.
     */
    @Test
    public void testSetYGetTotal() {
        Double expectedIVA = subtotal * 0.16;
        Double expectedTotal = subtotal + expectedIVA;

        venta.setSubtotal(subtotal);
        venta.setIVA();
        venta.setTotal();
        Double result = venta.getTotal();

        assertEquals(expectedTotal, result, 0.001);
    }
    
}
