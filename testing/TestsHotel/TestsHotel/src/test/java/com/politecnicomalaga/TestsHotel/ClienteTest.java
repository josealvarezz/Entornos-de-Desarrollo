package com.politecnicomalaga.TestsHotel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    static private String dni;
    static private String nombre;
    static private String apellido1;
    static private String apellido2;
    static private String email;
    static private String telefono;
    static private String edad;
    static private String fechaNacimiento;


    @BeforeAll
    public static void init() {
        dni = "12345678A";
        nombre = "Testeo";
        apellido1 = "Test1";
        apellido2 = "Test2";
        email = "emailCliente@test.com";
        telefono = "123456788";
        edad = "21";
        fechaNacimiento = "1/2/3";
    }

    @Test
    void constructorTest() {
        Cliente c = new Cliente(dni, nombre, apellido1, apellido2, email, telefono, edad, fechaNacimiento);

        assertEquals(dni, c.getDNI());
        assertEquals(nombre, c.getNombre());
        assertEquals(apellido1, c.getApellido1());
        assertEquals(apellido2, c.getApellido2());
        assertEquals(email, c.getEmail());
        assertEquals(telefono, c.getTelefono());
        assertEquals(edad, c.getEdad());
        assertEquals(fechaNacimiento, c.getFechanacimiento());
    }

    @Test
    void GettersSettersTest() {
        Cliente c = new Cliente(".", ".", ".", ".", ".", ".", ".", ".");

        c.setDNI(dni);
        c.setNombre(nombre);
        c.setApellido1(apellido1);
        c.setApellido2(apellido2);
        c.setEmail(email);
        c.setTelefono(telefono);
        c.setEdad(edad);
        c.setFechanacimiento(fechaNacimiento);

        assertEquals(dni, c.getDNI());
        assertEquals(nombre, c.getNombre());
        assertEquals(apellido1, c.getApellido1());
        assertEquals(apellido2, c.getApellido2());
        assertEquals(email, c.getEmail());
        assertEquals(telefono, c.getTelefono());
        assertEquals(edad, c.getEdad());
        assertEquals(fechaNacimiento, c.getFechanacimiento());
    }

    @Test
    void toStringTest() {
        Cliente c = new Cliente(dni, nombre, apellido1, apellido2, email, telefono, edad, fechaNacimiento);
        assertEquals(c.toString(), "DNI: " + this.dni + "\nNombre: " + this.nombre + "\nPrimer apellido: " + this.apellido1 + "\nSegundo apellido: " + this.apellido2 + "\nCorreo electrónico: " + email + "\nTeléfono: " + telefono + "\nEdad: " + edad + "\nFecha de nacimiento: " + fechaNacimiento + "\n************************");
    }
}