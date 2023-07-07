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
        instance.agregarDatosPersona(administrador);
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
        instance.modificarDatosPersona(idAdministrador, administrador);
        
    }

    /**
     * Test of eliminarDatosAdministrador method, of class MetodosAdministrador.
     */
    @Test
    public void testEliminarDatosAdministrador() {
        System.out.println("eliminarDatosAdministrador");
        Administrador administrador = null;
        MetodosAdministrador instance = new MetodosAdministrador();
        instance.eliminarDatosPersona(administrador.getId());
       
    }    
}
