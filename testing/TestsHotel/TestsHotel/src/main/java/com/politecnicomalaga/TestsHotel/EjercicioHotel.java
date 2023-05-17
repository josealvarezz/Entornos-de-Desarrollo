/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.politecnicomalaga.TestsHotel;

import javax.naming.ldap.Control;
import java.util.Scanner;

/**
 *
 * @author jose
 */
public class EjercicioHotel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ControladorFicheros gestor = new ControladorFicheros();

        String title = "*  Bienvenido al sistema de gestión de la cadena de hoteles  *";
        starline(title);
        System.out.println("");
        System.out.println(title);
        starline(title);
        System.out.println("");

        System.out.println("Antes de continuar al menú principal, introduce los datos del hotel: ");

        System.out.println("Breve descripción: ");
        String hoteldesc = sc.nextLine();
        while (hoteldesc.equals("")) {
            System.out.println("Introduce una breve descripción");
        }

        System.out.println("Nombre del hotel: ");
        String hotelname = sc.nextLine();
        while (hotelname.equals("")) {
            System.out.println("Introduce un nombre válido");
            hotelname = sc.nextLine();
        }

        System.out.println("Dirección: ");
        String hoteldir = sc.nextLine();
        while (hoteldir.equals("")) {
            System.out.println("Introduce una dirección");
            hoteldir = sc.nextLine();
        }

        System.out.println("Número de teléfono: ");
        String hoteltlf = sc.nextLine();
        while (hoteltlf.toString().length() != 9) {
            System.out.println("Introduce un número de teléfono correcto");
            hoteltlf = sc.nextLine();
        }
        System.out.println("Correo electrónico: ");
        String email = sc.nextLine();
        while (!email.contains("@")) {
            System.out.println("Introduce un correo electrónico válido");
            email = sc.nextLine();
        }
        Hotel hotel = new Hotel(hoteldesc, hotelname, hoteldir, hoteltlf, email);
        System.out.println("Gracias, ahora continuarás al menú principal");

        while (true) {
            System.out.println("Por favor, selecciona una opción: ");
            System.out.println("1. Mostrar datos del hotel");
            System.out.println("2. Mostrar una lista de todos los clientes");
            System.out.println("3. Crear un nuevo cliente");
            System.out.println("4. Eliminar un cliente");
            System.out.println("5. Crear una promoción para clientes en un rango de edad determinado");
            System.out.println("6. Guardar datos en archivo CSV");
            System.out.println("7. Cargar datos de archivo CSV");
            System.out.println("0. Salir");

            int opcion = Integer.valueOf(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println(hotel.toString());
                    continue;

                case 2:
                    System.out.println(hotel.allClients());
                    continue;
                case 3:
                    System.out.println("Introduce el DNI: ");
                    String clientDni = sc.nextLine();
                    System.out.println("Introduce el nombre: ");
                    String clientName = sc.nextLine();
                    System.out.println("Introduce el primer apellido: ");
                    String clientPrimer = sc.nextLine();
                    System.out.println("Introduce el segundo apellido: ");
                    String clientSegundo = sc.nextLine();
                    System.out.println("Introduce el email: ");
                    String clientEmail = sc.nextLine();
                    System.out.println("Introduce el teléfono: ");
                    String clientPhone = sc.nextLine();
                    System.out.println("Introduce la edad: ");
                    String clientAge = sc.nextLine();
                    System.out.println("Introduce la fecha de nacimiento (dd/mm/yy)");
                    String clientBirth = sc.nextLine();

                    hotel.createClient(clientDni, clientName, clientPrimer, clientSegundo, clientEmail, clientPhone, clientAge, clientBirth);
                    continue;
                    
                case 4:
                    System.out.println("Introduce el DNI del cliente al que quieres eliminar: ");
                    String targetDNI = sc.nextLine();
                    hotel.removeClient(targetDNI);
                    continue;
                    
                case 5:
                    System.out.println("Introduce el límite de edad inferior: ");
                    int liminf = Integer.valueOf(sc.nextLine());
                    System.out.println("Introduce el límite de edad superior: ");
                    int limsup = Integer.valueOf(sc.nextLine());
                    System.out.println(hotel.promo(liminf, limsup));

                case 6:
                    System.out.println("¿Quieres guardar los datos en un archivo CSV? (S/N)");
                    String res = sc.nextLine().toLowerCase();
                    if (res.equals("s")) {
                        System.out.println("Introduce el nombre del archivo: ");
                        String nombreArchivo = sc.nextLine() + ".csv";
                        gestor.writeText(nombreArchivo, hotel.toCSV());
                    } else {
                        continue;
                    }

                case 7:
                    System.out.println("Introduce el nombre del fichero: ");
                    String nombreArchivo = sc.nextLine();
                    Hotel hotel1 = new Hotel(gestor.readText(nombreArchivo));
                    continue;

                default:
                    
                    break;
            }
            break;
        }
    }

    public static void starline(String title) {
        for (int i = 0; i < title.length(); i++) {
            System.out.print("*");
        }
    }
}
