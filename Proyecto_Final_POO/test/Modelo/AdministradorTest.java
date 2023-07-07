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
 * @author zhuwu1
 */
public class AdministradorTest {
    
    private static Administrador admin;

    @Before
    public void setupClass(){
        admin = new Administrador("John","Doe","D",100.0,"Jhon",3,"151");
    }
    
    /**
     * Test of getContrasenia method, of class Administrador.
     */
    @Test
    public void testGetContrasenia() {
        System.out.println("getContrasenia");
 
        String expResult = "151";
        String result = admin.getContrasenia();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setContrasenia method, of class Administrador.
     */
    @Test
    public void testSetContrasenia() {
        System.out.println("setContrasenia");
        String contrasenia = "123";
        admin.setContrasenia(contrasenia);
        
        assertEquals(contrasenia, admin.getContrasenia());
       
    }

    /**
     * Test of getSueldo method, of class Administrador.
     */
    @Test
    public void testGetSueldo() {
        System.out.println("getSueldo");
        double expResult = 100.0;
        double result = admin.getSueldo();
       
        assertEquals(expResult, result, 0);
       
    }

    /**
     * Test of getUsuario method, of class Administrador.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        String expResult = "Jhon";
        String result = admin.getUsuario();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getIdAdministrador method, of class Administrador.
     */
    @Test
    public void testGetIdAdministrador() {
        System.out.println("getIdAdministrador");
        
        int expResult = 3;
        int result = admin.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setSueldo method, of class Administrador.
     */
    @Test
    public void testSetSueldo() {
        System.out.println("setSueldo");
        double sueldo = 0.0;
        admin.setSueldo(sueldo);
        assertEquals(sueldo, admin.getSueldo(), 0);
        
    }

    /**
     * Test of setUsuario method, of class Administrador.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        String usuario = "newName";
        admin.setUsuario(usuario);
        assertEquals(usuario, admin.getUsuario());
       
    }    
}
