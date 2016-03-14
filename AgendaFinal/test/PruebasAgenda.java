
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import agendafinal.AgendaFinal;
import modelo.Agenda;
import modelo.Contacto;
import modelo.Telefono;
import modelo.RedSocial;
import java.util.ArrayList;

public class PruebasAgenda {
    Agenda agendaPrueba=new Agenda();
    Contacto contactoPrueba=new Contacto();
    Telefono telefonoPrueba;
    RedSocial redSocialPrueba;
    
    public PruebasAgenda() {
        
    }
    //Pruebas Agenda
    @Test
    public void pruebaAgregarContacto(){
        boolean valorEsperado=true;
        assertEquals("",valorEsperado,agendaPrueba.guardarContacto(contactoPrueba));
    }
    @Test
    public void pruebaEliminarContacto(){
        boolean valorEsperado=true;
        contactoPrueba.setNombre("Paco");
        agendaPrueba.guardarContacto(contactoPrueba);
        assertEquals("", valorEsperado, agendaPrueba.eliminarContacto("Paco"));
    }
    @Test
    public void pruebaTamanoLista(){
        int valorEsperado=0;
        assertEquals(" ", valorEsperado, agendaPrueba.tamanoLista());
    }
    
    //Pruebas Contacto
    @Test
    public void pruebaRegistrarCorreosElectronicos(){
        boolean valorEsperado=true;
        assertEquals("",valorEsperado,contactoPrueba.registrarCorreosElectronicos("paco@uv.com"));
    }
    @Test
    public void pruebaTelefonos(){
        boolean valorEsperado=true;
        assertEquals("",valorEsperado,contactoPrueba.registrarTelefonos(telefonoPrueba));
    }
    @Test
    public void pruebaRegistrarRedesSociales(){
        boolean valorEsperado=true;
        assertEquals("",valorEsperado,contactoPrueba.registrarRedesSociales(redSocialPrueba));
    }
    
    @Test
    public void pruebaMostrarContactoVacio(){
        boolean valorEsperado=false;
        assertEquals("",valorEsperado,agendaPrueba.mostrarContactos());
    }
    @Test
    public void pruebaMostrarContacto(){
        boolean valorEsperado=true;
        contactoPrueba.setNombre("Renato");
        agendaPrueba.guardarContacto(contactoPrueba);
        assertEquals("",valorEsperado,agendaPrueba.mostrarContactos());
    }
    @Test
    public void buscarContactoEncontrado(){
        boolean valorEsperado=true;
        contactoPrueba.setNombre("Renato");
        agendaPrueba.guardarContacto(contactoPrueba);
        assertEquals("",valorEsperado,agendaPrueba.imprimirBusqueda(agendaPrueba.buscarPorNombre("Renato")));
    }
    @Test
    public void buscarContactoNoEncontrado(){
        boolean valorEsperado=false;
        contactoPrueba.setNombre("Paco");
        agendaPrueba.guardarContacto(contactoPrueba);
        assertEquals("",valorEsperado,agendaPrueba.imprimirBusqueda(agendaPrueba.buscarPorNombre("P4Kit0")));
    }
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
