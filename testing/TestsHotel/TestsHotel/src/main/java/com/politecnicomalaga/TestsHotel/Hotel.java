/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.TestsHotel;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jose
 */
public class Hotel {

    private String desc;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private ArrayList<Cliente> listaClientes;

    public Hotel(String desc, String nombre, String direccion, String telefono, String email) {
        this.desc = desc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.listaClientes = new ArrayList<>();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Hotel(String sCSV) {
        String[] lineas = sCSV.split("\n");
        String[] columnas = lineas[0].split(";");
        if (columnas[0].equals("Hotel")) {
            this.desc = columnas[1];
            this.nombre = columnas[2];
            this.direccion = columnas[3];
            this.telefono = columnas[4];
            this.email = columnas[5];
        } else {
            return;
        }

        this.listaClientes = new ArrayList<>();

        String[] posiblesClientes = sCSV.split("Cliente");
        String resultado;

        for (int i = 1; i < posiblesClientes.length; i++) {
            resultado = "Cliente"  + posiblesClientes[i];
            Cliente c = new Cliente(resultado);
            listaClientes.add(c);
        }

    }

    public String toCSV() {
        String resultado = String.format("Hotel;%s;%s;%s;%s;%s\n", desc, nombre, direccion, telefono, email);
        for (Cliente c: listaClientes) {
            resultado += c.toCSV();
        }
        return resultado;
    }

    public String toString() {
        return "Nombre del hotel: " + this.nombre + "\nDescripción del hotel: " + this.desc + "\nDirección postal: " + this.direccion + "\nTeléfono: " + this.telefono + "\nCorreo electrónico: " + this.email;
    }

    public void createClient(String DNI, String nombre, String apellido1, String apellido2, String email, String telefono, String edad, String fechanacimiento) {
        Cliente cliente = new Cliente(DNI, nombre, apellido1, apellido2, email, telefono, edad, fechanacimiento);
        listaClientes.add(cliente);
    }

    public void removeClient(String targetDNI) {
        Iterator<Cliente> iterator = listaClientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getDNI().matches(targetDNI)) {
                iterator.remove();
            }
        }
    }


    public Cliente[] allClients() {
        Cliente[] lista = listaClientes.toArray(new Cliente[0]);
        return lista;
    }

    public String promo(int liminf, int limsup) {
        int counter = 0;
        for (Cliente cliente : listaClientes) {
            if (Integer.valueOf(cliente.getEdad()) >= liminf && Integer.valueOf(cliente.getEdad())  <= limsup) {
                counter += 1;
            }
        }
        return "La promoción se ha aplicado a " + counter + " clientes";
    }

}
