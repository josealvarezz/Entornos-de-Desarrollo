/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.TestsHotel;

/**
 *
 * @author jose
 */
public class Cliente {
    private String DNI;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String telefono;

    public String getDNI() {
        return this.DNI;
    }

    public String getEdad() {
        return this.edad;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    private String edad;
    private String fechanacimiento;
    
    public Cliente(String DNI, String nombre, String apellido1, String apellido2, String email, String telefono, String edad, String fechanacimiento) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        this.fechanacimiento = fechanacimiento;
    }

    public Cliente(String sCSV) {
        String[] lineas = sCSV.split("\n");
        String[] columnas = lineas[0].split(";");
        if (columnas[0].equals("Cliente")) {
            this.DNI = columnas[1];
            this.nombre = columnas[2];
            this.apellido1 = columnas[3];
            this.apellido2 = columnas[4];
            this.email = columnas[5];
            this.telefono = columnas[6];
            this.edad = columnas[7];
            this.fechanacimiento = columnas[8];
        } else {
            return;
        }
    }
    
    public String toString() {
        return "DNI: " + this.DNI + "\nNombre: " + this.nombre + "\nPrimer apellido: " + this.apellido1 + "\nSegundo apellido: " + this.apellido2 + "\nCorreo electrónico: " + email + "\nTeléfono: " + telefono + "\nEdad: " + edad + "\nFecha de nacimiento: " + fechanacimiento + "\n************************";
    }

    public String toCSV() {
        String resultado = String.format("Cliente;%s;%s;%s;%s;%s;%s;%s;%s\n", DNI, nombre, apellido1, apellido2, email, telefono, edad, fechanacimiento);
        return resultado;
    }

}
