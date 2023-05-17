import com.politecnicomalaga.TestsHotel.Cliente;
import com.politecnicomalaga.TestsHotel.Hotel;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {
    static private String desc;
    static private String nombre;
    static private String direccion;
    static private String telefono;
    static private String email;

    static String dni;
    static String nombreCliente;
    static String apellido1Cliente;
    static String apellido2Cliente;
    static String emailCliente;
    static String telefonoCliente;
    static String edadCliente;
    static String fechaNacCliente;

    @BeforeAll
    public static void init() {
        desc = "descripcion test";
        nombre = "test nombreHotel";
        direccion = "test direccionHotel";
        telefono = "123456789";
        email = "test@test.com";

        dni = "12345678A";
        nombreCliente = "Testeo";
        apellido1Cliente = "Test1";
        apellido2Cliente = "Test2";
        emailCliente = "emailCliente@test.com";
        telefonoCliente = "123456788";
        edadCliente = "21";
        fechaNacCliente = "1/2/3";

        System.out.println("#before ejecutado");
    }

    @Test
    void testConstructor() {
        Hotel h = new Hotel(desc, nombre, direccion, telefono, email);

        assertTrue(h.getDesc().equals(desc));
        assertTrue(h.getNombre().equals(nombre));
        assertTrue(h.getDireccion().equals(direccion));
        assertTrue(h.getTelefono().equals(telefono));
        assertTrue(h.getEmail().equals(email));
        assertTrue(h.getListaClientes().isEmpty());
    }

    @Test
    void testGettersSetters() {
        Hotel h = new Hotel(".", ".", ".", ".", ".");

        h.setDesc(desc);
        h.setNombre(nombre);
        h.setDireccion(direccion);
        h.setTelefono(telefono);
        h.setEmail(email);

        assertEquals(desc, h.getDesc());
        assertEquals(nombre, h.getNombre());
        assertEquals(direccion, h.getDireccion());
        assertEquals(telefono, h.getTelefono());
        assertEquals(email, h.getEmail());
    }

    @Test
    void toStringTest() {
        Hotel h = new Hotel(desc, nombre, direccion, telefono, email);

        assertTrue(h.getDesc().equals(desc));
        assertTrue(h.getNombre().equals(nombre));
        assertTrue(h.getDireccion().equals(direccion));
        assertTrue(h.getTelefono().equals(telefono));
        assertTrue(h.getEmail().equals(email));
        assertTrue(h.getListaClientes().isEmpty());

        assertTrue(h.toString().equals("Nombre del hotel: " + this.nombre + "\nDescripción del hotel: " + this.desc + "\nDirección postal: " + this.direccion + "\nTeléfono: " + this.telefono + "\nCorreo electrónico: " + this.email));
    }

    @Test
    void createClientTest() {
        Hotel h = new Hotel(desc, nombre, direccion, telefono, email);
        h.createClient(dni, nombre, apellido1Cliente, apellido2Cliente, email, telefono, edadCliente, fechaNacCliente);
        assertEquals(1, h.getListaClientes().size());
    }

    @Test
    void removeClientTest() {
        Hotel h = new Hotel(desc, nombre, direccion, telefono, email);
        h.createClient(dni, nombre, apellido1Cliente, apellido2Cliente, email, telefono, edadCliente, fechaNacCliente);
        assertEquals(1, h.getListaClientes().size());
        h.removeClient(dni);
        assertTrue(h.getListaClientes().isEmpty());
    }

    @Test
    void allClientsTest() {
        Hotel h = new Hotel(desc, nombre, direccion, telefono, email);
        for (int i = 0; i < 100; i++) {
            h.createClient(dni + i, nombre + i, apellido1Cliente + i, apellido2Cliente + i, email + i, telefono + i, edadCliente + i, fechaNacCliente + i);
        }
        assertEquals(100, h.getListaClientes().size());

        assertEquals(h.getListaClientes().size(), h.allClients().length);
    }
}