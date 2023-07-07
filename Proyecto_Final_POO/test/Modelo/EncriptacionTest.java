/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexandra
 */
public class EncriptacionTest {
    
    Encriptacion encrip = new Encriptacion();
    /**
     * Test of MD5 method, of class Encriptacion.
     */
    @Test
    public void testMD5() {
        String esperado = "caf1a3dfb505ffed0d024130f58c5cfa";
        String resultado = encrip.MD5("321");
        assertEquals(esperado, resultado);
    }
    
}
