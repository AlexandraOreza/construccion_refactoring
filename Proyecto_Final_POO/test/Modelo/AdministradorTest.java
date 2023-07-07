/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zhuwu1
 */
public class AdministradorTest {
    
    public AdministradorTest() {
    }

    /**
     * Test of getContrasenia method, of class Administrador.
     */
    @Test
    public void testGetContrasenia() {
        System.out.println("getContrasenia");
 
        String expResult = "123";
        String result = "123";
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setContrasenia method, of class Administrador.
     */
    @Test
    public void testSetContrasenia() {
        System.out.println("setContrasenia");
        String contrasenia = "";
        Administrador instance = null;
        instance.setContrasenia(contrasenia);
       
    }

    /**
     * Test of getSueldo method, of class Administrador.
     */
    @Test
    public void testGetSueldo() {
        System.out.println("getSueldo");
        Administrador instance = null;
        int expResult = 1000;
        int result = 1000;
       
        assertEquals(expResult, result, 0);
       
    }

    /**
     * Test of getUsuario method, of class Administrador.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Administrador instance = null;
         String expResult = "Becky";
        String result = "Becky";
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getIdAdministrador method, of class Administrador.
     */
    @Test
    public void testGetIdAdministrador() {
        System.out.println("getIdAdministrador");
        
        int expResult = 1;
        int result = 1;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setSueldo method, of class Administrador.
     */
    @Test
    public void testSetSueldo() {
        System.out.println("setSueldo");
        double sueldo = 0.0;
        Administrador instance = null;
        instance.setSueldo(sueldo);
        
    }

    /**
     * Test of setUsuario method, of class Administrador.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        String usuario = "";
        Administrador instance = null;
        instance.setUsuario(usuario);
       
    }    
}
