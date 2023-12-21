package com.jstorra.ejercicio2;

import java.util.Scanner;

public class Main {
    // 2. La tienda de alquiler de películas PelisChill, esta incorporando un sistema de registro de películas
    // y clientes.

    // Para ello, la tienda almacena información relevante de las películas como id de la película el cual no
    // puede repetirse, titulo, director, genero y precio de alquiler. Se destaca que existen algunas películas
    // especiales las cuales poseen un descuento que puede variar. De igual forma, la tienda requiere almacenar
    // la información de los clientes de la tienda, como nombre, correo y numero de celular. Para todas las
    // películas debe permitir mostrar su información y calcular el precio total.

    // Por ultimo, es necesario que el sistema cuente con las funcionalidades de registrar películas, registrar
    // clientes, realizar el alquiler de una película y mostrar la información tanto de la película, como del
    // cliente y su valor total, cambiar el precio de una película y finalmente, eliminar una película del catalogo.

    public static void main(String[] args) {
        Tienda miTienda = new Tienda();

        Scanner scanner = new Scanner(System.in);
        int idP = 0;
        int idC = 0;
        
        try {
            while (true) {
                System.out.println("""
                                                   
                        1. Registrar pelicula
                        2. Registrar Cliente
                        3. Alquilar pelicula
                        4. Cambiar precio a una pelicula
                        5. Eliminar pelicula
                        6. Salir
                        """);
                System.out.print("Opcion: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion == 6) {
                    System.out.println("\nSaliendo...");
                    break;
                } else if (opcion == 1) {
                    System.out.println("--------------- REGISTRAR PELICULA ---------------");
                    System.out.print("Ingresa el titulo de la pelicula: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingresa el director de la pelicula: ");
                    String director = scanner.nextLine();
                    System.out.print("Ingresa el genero de la pelicula: ");
                    String genero = scanner.nextLine();
                    System.out.println("""
                            La pelicula es especial?
                            1. Si
                            2. No
                            """);
                    System.out.print("Opcion: ");
                    int especial = scanner.nextInt();
                    
                    double precioAlquiler;
                    while(true) {
                        try {
                            scanner.nextLine();
                            System.out.print("Ingresa el precio de alquiler (ex: 1,99): ");
                            precioAlquiler = scanner.nextDouble();
                            break;
                        } catch (Exception e) {
                            System.out.println("\nERROR: El valor ingresado no es válido, asegurate de seguir el formato.\n");
                        }
                    }

                    double descuento = 0;
                    boolean isEspecial = false;

                    if (especial == 1) {
                        isEspecial = true;
                        System.out.println("Ingresa el descuento a aplicar: ");
                        descuento = scanner.nextDouble();
                    } else if (especial != 2) {
                        System.out.println("\nERROR: La opción ingresada no es válida.");
                    }

                    Pelicula miPelicula = new Pelicula(idP++, titulo, director, genero, isEspecial, precioAlquiler, descuento);
                    miTienda.registrarPelicula(miPelicula);
                    System.out.println(miPelicula.mostrarInformacion());

                } else if (opcion == 2) {
                    System.out.println("--------------- REGISTRAR CLIENTE ---------------");
                    System.out.print("Ingresa el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingresa el correo electronico del cliente: ");
                    String correo = scanner.nextLine();
                    System.out.print("Ingresa el numero de telefono del cliente: ");
                    String numeroTelefono = scanner.nextLine();

                    Cliente miCliente = new Cliente(idC++, nombre, correo, numeroTelefono);
                    miTienda.registrarCliente(miCliente);

                } else if (opcion == 3) {

                } else if (opcion == 4 || opcion == 5) {
                    System.out.print("Ingresa el ID de la pelicula: ");
                    int idPelicula = scanner.nextInt();
                    String tipo = (opcion == 4) ? "cambiarPrecio" : "remover";
                    if (!miTienda.buscarPelicula(idPelicula, tipo))
                        System.out.println("No se encontró ninguna película con el ID: " + idPelicula);
                } else {
                    System.out.println("\nERROR: La opción ingresada no es válida.");
                }
            }
        } catch (Exception e) {
            System.out.println("\nERROR: El caracter ingresado no es válido.");
        }
    }
}