/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public class CSVTest {
    
    private static CSV csv;
    private final String TEST_FILE_NAME = "Administradores.csv";
    private static Administrador TEST_DATA;
    
    @Before
    public static void setupClass(){
        csv = new CSV();
        TEST_DATA = new Administrador("John","Doe","D",100.0,"Jhon",3,"151");
    }
    
    /**
     * Test del método leerArchivo de la clase CSV.
     */
    @Test
    public void obtenerDatosArchivo() {
        List<String> datosArchivo = csv.obtenerDatosArchivo(TEST_FILE_NAME);
        assertNotNull(datosArchivo);
        assertEquals(2, datosArchivo.size());
    }

    /**
     * Test del método agregarFilaDatos de la clase CSV.
     */
    @Test
    public void testAgregarFilaDatos() {
        csv.agregarFilaDatos(TEST_FILE_NAME, TEST_DATA, "administrador");
        
        List<String> datosArchivo = csv.obtenerDatosArchivo(TEST_FILE_NAME);
        assertEquals(3, datosArchivo.size());
    }
    
    /**
     * Test del método eliminarFilaDatos de la clase CSV.
     */
    @Test
    public void testEliminarFilaDatos() {
        csv.eliminarFilaDatos(TEST_FILE_NAME, 3);
        
        List<String> listaDatosModificados = csv.obtenerDatosArchivo(TEST_FILE_NAME);

        assertEquals(2, listaDatosModificados.size());
        assertEquals("1,Becky2, Zhu, Wu, Becky2,123,1500", listaDatosModificados.get(0));
        assertEquals("2,Alex,Oreza,Mendicuti,Alex,321,5000", listaDatosModificados.get(1));
    }

    /**
     * Test del método existeId de la clase CSV.
     */
    @Test
    public void testExisteId_IdExistente() {
        boolean existe = csv.existeId("Administradores.csv", 1);
        assertTrue(existe);
    }
    
    @Test
    public void testExisteId_IdNoExiste() {
        boolean existe = csv.existeId("Administradores.csv", 100);
        assertFalse(existe);
    }
    
    @Test
    public void testExisteId_ArchivoInvalido() {
        boolean existe = csv.existeId("ArchivoInvalido.csv", 1);
        assertFalse(existe);
    }
}
