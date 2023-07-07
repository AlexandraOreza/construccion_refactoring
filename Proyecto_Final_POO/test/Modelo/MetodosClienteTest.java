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
public class MetodosClienteTest {
    
    private MetodosCliente metodosCliente;
    private CSVStub csvStub;

    @Before
    public void setUp() {
        metodosCliente = new MetodosCliente();
        csvStub = new CSVStub();
        metodosCliente.csv = csvStub;
    }

    @Test
    public void testAgregarDatosPersona() {
        Object objeto = new Object();

        metodosCliente.agregarDatosPersona(objeto);

        assertEquals(1, csvStub.agregarFilaDatosCalls);
        assertEquals("Clientes.csv", csvStub.agregarFilaDatosArchivo);
        assertEquals(objeto, csvStub.agregarFilaDatosObjeto);
        assertEquals("cliente", csvStub.agregarFilaDatosTipo);
    }

    @Test
    public void testModificarDatosPersona() {
        int id = 1;
        Object objeto = new Object();

        metodosCliente.modificarDatosPersona(id, objeto);

        assertEquals(1, csvStub.modificarFilaDatosCalls);
        assertEquals("Clientes.csv", csvStub.modificarFilaDatosArchivo);
        assertEquals(id, csvStub.modificarFilaDatosId);
        assertEquals(objeto, csvStub.modificarFilaDatosObjeto);
        assertEquals("cliente", csvStub.modificarFilaDatosTipo);
    }

    @Test
    public void testEliminarDatosPersona() {
        int id = 1;

        metodosCliente.eliminarDatosPersona(id);

        assertEquals(1, csvStub.eliminarFilaDatosCalls);
        assertEquals("Clientes.csv", csvStub.eliminarFilaDatosArchivo);
        assertEquals(id, csvStub.eliminarFilaDatosId);
    }

    @Test
    public void testExisteIdCuandoIdExiste() {
        int id = 1;
        csvStub.setExisteIdResult(true);

        boolean result = metodosCliente.existeId(id);

        assertTrue(result);
    }

    @Test
    public void testExisteIdCuandoIdNoExiste() {
        int id = 1;
        csvStub.setExisteIdResult(false);

        boolean result = metodosCliente.existeId(id);

        assertFalse(result);
    }

    //Clase csv dummy que simula la creacion y los metodos para un csv
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
