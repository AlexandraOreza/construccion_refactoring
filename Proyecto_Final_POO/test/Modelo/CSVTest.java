/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zhuwu1
 */
public class CSVTest {
    
    public CSVTest() {
    }

    /**
     * Test of leerArchivo method, of class CSV.
     */
    @Test
    public void testLeerArchivo() {
        System.out.println("leerArchivo");
        String nombreArchivoLectura = "";
        CSV instance = new CSV();
        List<String> expResult = null;
        List<String> result = null;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of agregarFilaDatos method, of class CSV.
     */
    @Test
    public void testAgregarFilaDatos() {
        System.out.println("agregarFilaDatos");
        String nombreArchivo = "";
        Object datosNuevaFila = null;
        CSV instance = new CSV();
        instance.agregarFilaDatos(nombreArchivo, datosNuevaFila);
        
    }

    /**
     * Test of modificarFilaDatos method, of class CSV.
     */
    @Test
    public void testModificarFilaDatos() {
        System.out.println("modificarFilaDatos");
        String fileName = "";
        int idFila = 0;
        Object datosModificados = null;
        CSV instance = new CSV();
        instance.modificarFilaDatos(fileName, idFila, datosModificados);
        
    }

    /**
     * Test of eliminarFilaDatos method, of class CSV.
     */
    @Test
    public void testEliminarFilaDatos() {
        System.out.println("eliminarFilaDatos");
        String nombreArchivo = "";
        int idFila = 0;
        CSV instance = new CSV();
        instance.eliminarFilaDatos(nombreArchivo, idFila);
       
    }
    
}
