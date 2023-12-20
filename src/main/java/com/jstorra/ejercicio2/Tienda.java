package com.jstorra.ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Cliente> clientes;

    public Tienda() {
        this.peliculas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void registrarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void alquilarPelicula(Pelicula pelicula, Cliente cliente) {
        double precioTotal = pelicula.getPrecioAlquiler();
        System.out.println("Información de la película: " + pelicula.mostrarInformacion());
        System.out.println("Información del cliente: " + cliente.mostrarInformacion());
        System.out.println("Precio total: " + precioTotal);
    }

    public boolean buscarPelicula(int idPelicula, String tipo) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == idPelicula) {
                if (tipo.equals("cambiarPrecio")) {
                    System.out.print("Ingresa el nuevo precio de alquiler: ");
                    double nuevoPrecio = scanner.nextDouble();
                    cambiarPrecioPelicula(pelicula, nuevoPrecio);
                } else if (tipo.equals("remover")) {
                    eliminarPelicula(idPelicula);
                } else {
                    System.out.println("\nERROR: El tipo de busqueda no es válida.");
                }
                return true;
            }
        }
        return false;
    }

    public void cambiarPrecioPelicula(Pelicula pelicula, double nuevoPrecio) {
        pelicula.setPrecioAlquiler(nuevoPrecio);
        System.out.println("Precio de la película '" + pelicula.getTitulo() + "' cambiado a: $" + nuevoPrecio);
    }

    public void eliminarPelicula(int idPelicula) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == idPelicula) {
                peliculas.remove(pelicula);
                System.out.println("Se ha removido la pelicula '" + pelicula.getTitulo() + "' exitosamente.");
                break;
            }
        }
    }
}