package cl.llanquihuetour.organizador.app;

import cl.llanquihuetour.organizador.data.TourArchivo;
import cl.llanquihuetour.organizador.model.*;
import cl.llanquihuetour.organizador.service.GestorTour;
import cl.llanquihuetour.organizador.util.RutInvalidoException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Direccion d1 = new Direccion("Av. Francisco Iero", "Llanquihue", 2025);
            Direccion d2 = new Direccion("Elton Charquican", "Puerto Varas", 45);
            Direccion d3 = new Direccion("Ruta v-55 km 9", "Llanquihue", 11);
            Direccion d4 = new Direccion("Fernando Acosta", "Puerto Montt", 78);

            Guias guia = new Guias("Fabiola Puentes", "19.564.231-2", "994651327", d1, "Español, Ingles", "Lago Llanquihue");
            Operadores operador = new Operadores("Lucia Dacus", "19.785.123-2", "99785351", d2.toString(), "Paseo en kayak", 1500);
            ProvAlojamiento alojamiento = new ProvAlojamiento("Cabañas Elton Gatito", "85.246.167-8", "99544628", d3, "Cabañas", 5, 12500);
            ProvTransporte transporte = new ProvTransporte("Transportes patito", "78.124.333-6", "224568943", d4, "Bus", 55, 1000);

            System.out.println("==== COLABORADORES =====");
            System.out.println(guia);
            System.out.println(operador);

            System.out.println("\n====== PROVEEDORES ======");
            System.out.println(alojamiento);
            System.out.println(transporte);

            System.out.println("\n===== DATOS MODIFICADOS=====");
            guia.setSector("Frutillar");
            operador.setServicio("Trekking");
            System.out.println(guia);
            System.out.println(operador);

        } catch (IllegalArgumentException | RutInvalidoException error) {
            System.out.println("Error de validacion: " + error.getMessage());
        }

        GestorTour gestor = new GestorTour();
        TourArchivo archivo = new TourArchivo();
        System.out.println("\n********* CARGAR DESDE ARCHIVO ************");
        try {
            gestor.agregarColaboradores(archivo.cargarColaboradores(Path.of("datos", "colaboradores.csv")));
            gestor.agregarProveedores(archivo.cargarProveedores(Path.of("datos", "proveedores.csv")));
        } catch (IOException error) {
            System.out.println("No fue posible cargar los datos: " + error.getMessage());
            return;
        }

        System.out.println("\n=== COLABORADORES CARGADOS===");
        for (var colaborador : gestor.listarColaboradores()) System.out.println(colaborador + "\n");
        System.out.println("\n=== PROVEEDORES CARGADOS ===");
        for (var proveedor : gestor.listarProveedores()) System.out.println(proveedor + "\n");

        menu(gestor);
    }

    private static void menu(GestorTour gestor) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("------BUSQUEDA-------");
            System.out.println("1.- Rut colaborador");
            System.out.println("2.- Nombre colaborador");
            System.out.println("3.- Comuna proveedor");
            System.out.println("4.- Idioma guía");
            System.out.println("0.- Salir");
            System.out.print("Opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException error) {
                System.out.println("Ingresa un número válido. \n");
                continue;
            } catch (java.util.NoSuchElementException error) {
                break;
            }
            switch (opcion) {
                case 1 -> {
                    System.out.println("RUT: ");
                    Colaboradores c = gestor.buscarColaborador(scanner.nextLine());
                    System.out.println(c != null ? c + "\n" : "Sin resultados\n");
                }
                case 2 -> {
                    System.out.println("Nombre: ");
                    mostrar(gestor.buscarPorNombre(scanner.nextLine()));
                }
                case 3 -> {
                    System.out.println("Comuna: ");
                    mostrar(gestor.filtrarProveedoresPorComuna(scanner.nextLine()));
                }
                case 4 -> {
                    System.out.println("Idioma: ");
                    mostrar(gestor.filtrarGuiasPorIdioma(scanner.nextLine()));
                }
                case 0 -> System.out.println("Hasta luego");
                default -> System.out.println("Opción no valida\n");
            }
        }
    }

    private static void mostrar(List<?> resultados) {
        if (resultados.isEmpty()) System.out.println("Sin resultados \n");
        for (Object elemento : resultados) System.out.println(elemento + "\n");
    }
}