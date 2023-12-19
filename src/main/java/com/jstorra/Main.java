package com.jstorra;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("""
                                            
                        Selecciona la acción deseada:
                        1. Partido Liga
                        2. Partido PlayOff
                        3. Salir
                        """);
                System.out.print("Opcion: ");
                int opcion = scanner.nextInt();

                if (opcion == 1 || opcion == 2) {
                    procesoPartido(opcion);
                } else if (opcion == 3) {
                    System.out.println("\nSaliendo...");
                    break;
                } else {
                    System.out.println("\nERROR: La opción ingresada no es válida.");
                }
            }
        } catch (Exception e) {
            System.out.println("\nERROR: El dato ingresado no es válido.");
        }
    }

    public static void procesoPartido(int opcion) {
        Scanner scanner = new Scanner(System.in);
        try {
            Partido objeto = null;

            System.out.print("\nIngresa el nombre del equipo local: ");
            String equipoLocal = scanner.nextLine();
            System.out.print("Ingresa el nombre del equipo visitante: ");
            String equipoVisitante = scanner.nextLine();
            System.out.print("Ingresa la fecha del partido DD/MM/YYYY: ");
            String fechaPartido = scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el numero de jornada: ");
                    int numeroJornada = scanner.nextInt();
                    objeto = new PartidoLiga(equipoLocal, equipoVisitante, fechaPartido, numeroJornada);
                    break;
                case 2:
                    System.out.print("Ingresa la ronda (\"octavos\", \"cuartos\", \"final\"): ");
                    String ronda = scanner.nextLine();
                    objeto = new PartidoPlayOff(equipoLocal, equipoVisitante, fechaPartido, ronda);
                    break;
            }

            while (true) {
                System.out.println("""
                                            
                        1. Registrar puntos al equipo Local
                        2. Registrar puntos al equipo visitante
                        3. Información del partido
                        4. Finalizar partido
                        5. Ganador del partido
                        6. Resultados del partido
                        7. Volver al menu
                        """);
                System.out.print("Opcion: ");
                int opcionI = scanner.nextInt();
                int puntos;

                if (objeto != null) {
                    if (opcionI == 1) {
                        if (objeto.isFinalizado()) {
                            System.out.println("\nERROR: No se puede registrar mas puntaje.");
                        } else {
                            System.out.println("------------ EQUIPO LOCAL ------------");
                            System.out.print("Ingresa la cantidad de puntos: ");
                            puntos = scanner.nextInt();
                            if (puntos > 0 && puntos <= 3) {
                                objeto.setCestasLocal(puntos + objeto.getCestasLocal());
                            } else {
                                System.out.println("\nERROR: La puntuación ingresada no es válida.");
                            }
                        }
                    } else if (opcionI == 2) {
                        if (objeto.isFinalizado()) {
                            System.out.println("\nERROR: No se puede registrar mas puntaje.");
                        } else {
                            System.out.println("------------ EQUIPO VISITANTE ------------");
                            System.out.print("Ingresa la cantidad de puntos: ");
                            puntos = scanner.nextInt();
                            if (puntos > 0 && puntos <= 3) {
                                objeto.setCestasVisitante(puntos + objeto.getCestasVisitante());
                            } else {
                                System.out.println("\nERROR: La puntuación ingresada no es válida.");
                            }
                        }
                    } else if (opcionI == 3) {
                        System.out.println(objeto.mostrarPartido());
                    } else if (opcionI == 4) {
                        if (objeto.isFinalizado()) {
                            System.out.println("MENSAJE: El partido ya se encuentra finalizado.");
                        } else {
                            System.out.println((objeto.finalizarPartido()) ? "\nMENSAJE: Se ha finalizado el partido." : "\nMENSAJE: No se ha finalizado el partido.");
                        }
                    } else if (opcionI == 5) {
                        System.out.println("\n------------ GANADOR ------------");
                        System.out.println(objeto.obtenerGanador());
                    } else if (opcionI == 6) {
                        System.out.println("\n------------ RESULTADOS ------------");
                        System.out.println(objeto.obtenerResultado());
                    } else if (opcionI == 7) {
                        System.out.println("\nVolviendo...");
                        break;
                    } else {
                        System.out.println("\nERROR: La opción ingresada no es válida.");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\nERROR: El dato ingresado no es válido.");
        }
    }
}