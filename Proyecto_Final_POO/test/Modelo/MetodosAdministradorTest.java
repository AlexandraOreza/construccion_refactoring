package Modelo;


import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author zhuwu1
 */
public class MetodosAdministradorTest {
    private Administrador admin;
    private MetodosAdministrador metodos;
    
    @Before
    public void setUpClass(){
        admin = new Administrador("John","Doe","D",100.0,"Jhon",4,"151");
        metodos = new MetodosAdministrador();
    }
    
    /**
     * Test of agregarDatosAdministrador method, of class MetodosAdministrador.
     */
    @Test
    public void testAgregarDatosAdministrador() {
        System.out.println("agregarDatosAdministrador");
        metodos.agregarDatosPersona(admin);
    }

    /**
     * Test of modificarDatosAdministrador method, of class MetodosAdministrador.
     */
    @Test
    public void testModificarDatosAdministrador() {
        System.out.println("modificarDatosAdministrador");
        String nombre = "Mary";
        admin.setApellidoMaterno(nombre);
        metodos.modificarDatosPersona(admin.getId(), admin);
    }

    /**
     * Test of eliminarDatosAdministrador method, of class MetodosAdministrador.
     */
    @Test
    public void testEliminarDatosAdministrador() {
        System.out.println("eliminarDatosAdministrador");
        metodos.eliminarDatosPersona(admin.getId());
       
    }    
    
    @Test
    public void testExisteId(){
        boolean resultado = metodos.existeId(4);
        assertFalse(resultado);
    }
}
