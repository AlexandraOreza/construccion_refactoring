package Modelo;


import org.junit.Test;

/**
 *
 * @author zhuwu1
 */
public class MetodosAdministradorTest {
    
    public MetodosAdministradorTest() {
    }
    
    /**
     * Test of agregarDatosAdministrador method, of class MetodosAdministrador.
     */
    @Test
    public void testAgregarDatosAdministrador() {
        System.out.println("agregarDatosAdministrador");
        Administrador administrador = null;
        MetodosAdministrador instance = new MetodosAdministrador();
        instance.agregarDatosAdministrador(administrador);
       
    }

    /**
     * Test of modificarDatosAdministrador method, of class MetodosAdministrador.
     */
    @Test
    public void testModificarDatosAdministrador() {
        System.out.println("modificarDatosAdministrador");
        int idAdministrador = 1;
        Administrador administrador = null;
        MetodosAdministrador instance = new MetodosAdministrador();
        instance.modificarDatosAdministrador(idAdministrador, administrador);
        
    }

    /**
     * Test of eliminarDatosAdministrador method, of class MetodosAdministrador.
     */
    @Test
    public void testEliminarDatosAdministrador() {
        System.out.println("eliminarDatosAdministrador");
        Administrador administrador = null;
        MetodosAdministrador instance = new MetodosAdministrador();
        instance.eliminarDatosAdministrador(administrador);
       
    }

    /**
     * Test of obtenerDatosAdministrador method, of class MetodosAdministrador.
     */
    @Test
    public void testObtenerDatosAdministrador() {
        System.out.println("obtenerDatosAdministrador");
        int idAdministrador = 1;
        MetodosAdministrador instance = new MetodosAdministrador();
        Administrador expResult = null;
        Administrador result = instance.obtenerDatosAdministrador(idAdministrador);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of cantidadAdministradorRegistrados method, of class MetodosAdministrador.
     */
    @Test
    public void testCantidadAdministradorRegistrados() {
        System.out.println("cantidadAdministradorRegistrados");
        MetodosAdministrador instance = new MetodosAdministrador();
        int expResult = 0;
        int result = instance.cantidadAdministradorRegistrados();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of compararExistenteID method, of class MetodosAdministrador.
     */
    @Test
    public void testCompararExistenteID() {
        System.out.println("compararExistenteID");
        int idExistente = 1;
        MetodosAdministrador instance = new MetodosAdministrador();
        int expResult = 0;
        int result = instance.compararExistenteID(idExistente);
        assertEquals(expResult, result);
       
    }
    
}
