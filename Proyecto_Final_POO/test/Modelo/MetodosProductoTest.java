/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Alexandra
 */
public class MetodosProductoTest {
    
    private MetodosProducto metodosProducto;
    private CSVStub csvStub;

    @Before
    public void setUp() {
        metodosProducto = new MetodosProducto();
        csvStub = new CSVStub();
        metodosProducto.csv = csvStub;
    }

    @Test
    public void testAgregarDatosProducto() {
        Producto producto = new Producto();

        metodosProducto.agregarDatosProducto(producto);

        assertEquals(1, csvStub.agregarFilaDatosCalls);
        assertEquals("Catalogo.csv", csvStub.agregarFilaDatosArchivo);
        assertEquals(producto, csvStub.agregarFilaDatosObjeto);
        assertEquals("producto", csvStub.agregarFilaDatosTipo);
    }

    @Test
    public void testModificarDatosProducto() {
        int idProducto = 1;
        Producto producto = new Producto();

        metodosProducto.modificarDatosProducto(idProducto, producto);

        assertEquals(1, csvStub.modificarFilaDatosCalls);
        assertEquals("Catalogo.csv", csvStub.modificarFilaDatosArchivo);
        assertEquals(idProducto, csvStub.modificarFilaDatosId);
        assertEquals(producto, csvStub.modificarFilaDatosObjeto);
        assertEquals("producto", csvStub.modificarFilaDatosTipo);
    }

    @Test
    public void testEliminarDatosProducto() {
        int idProducto = 1;

        metodosProducto.eliminarDatosProducto(idProducto);

        assertEquals(1, csvStub.eliminarFilaDatosCalls);
        assertEquals("Catalogo.csv", csvStub.eliminarFilaDatosArchivo);
        assertEquals(idProducto, csvStub.eliminarFilaDatosId);
    }

    @Test
    public void testExisteIdWhenIdExists() {
        int idProducto = 1;
        csvStub.setExisteIdResult(true);

        boolean result = metodosProducto.existeId(idProducto);

        assertTrue(result);
    }

    @Test
    public void testExisteIdWhenIdDoesNotExist() {
        int idProducto = 1;
        csvStub.setExisteIdResult(false);

        boolean result = metodosProducto.existeId(idProducto);

        assertFalse(result);
    }

    @Test
    public void testCantidadProductoRegistrados() {
        int expectedCantidad = 5;
        metodosProducto.datosProducto = new ArrayList<>();
        for (int i = 0; i < expectedCantidad; i++) {
            metodosProducto.datosProducto.add(new Producto());
        }

        int result = metodosProducto.cantidadProductoRegistrados();

        assertEquals(expectedCantidad, result);
    }

    private static class CSVStub extends CSV {
        private int agregarFilaDatosCalls = 0;
        private String agregarFilaDatosArchivo;
        private Object agregarFilaDatosObjeto;
        private String agregarFilaDatosTipo;
        private int modificarFilaDatosCalls = 0;
        private String modificarFilaDatosArchivo;
        private int modificarFilaDatosId;
        private Object modificarFilaDatosObjeto;
        private String modificarFilaDatosTipo;
        private int eliminarFilaDatosCalls = 0;
        private String eliminarFilaDatosArchivo;
        private int eliminarFilaDatosId;
        private boolean existeIdResult;

        @Override
        public void agregarFilaDatos(String archivo, Object objeto, String tipo) {
            agregarFilaDatosCalls++;
            agregarFilaDatosArchivo = archivo;
            agregarFilaDatosObjeto = objeto;
            agregarFilaDatosTipo = tipo;
        }

        @Override
        public void modificarFilaDatos(String archivo, int id, Object objeto, String tipo) {
            modificarFilaDatosCalls++;
            modificarFilaDatosArchivo = archivo;
            modificarFilaDatosId = id;
            modificarFilaDatosObjeto = objeto;
            modificarFilaDatosTipo = tipo;
        }

        @Override
        public void eliminarFilaDatos(String archivo, int id) {
            eliminarFilaDatosCalls++;
            eliminarFilaDatosArchivo = archivo;
            eliminarFilaDatosId = id;
        }

        @Override
        public boolean existeId(String archivo, int id) {
            return existeIdResult;
        }

        public void setExisteIdResult(boolean result) {
            existeIdResult = result;
        }
    }
}
