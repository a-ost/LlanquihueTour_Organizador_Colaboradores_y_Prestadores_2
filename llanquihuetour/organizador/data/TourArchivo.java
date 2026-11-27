package cl.llanquihuetour.organizador.data;

import cl.llanquihuetour.organizador.model.*;
import cl.llanquihuetour.organizador.util.RutInvalidoException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TourArchivo {

    public List<Colaboradores> cargarColaboradores(Path ruta) throws IOException {
        List<Colaboradores> resultado = new ArrayList<>();
        List<String> filas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
        for (int i = 1; i < filas.size(); i++) {
            if (filas.get(i).isBlank()) continue;
            String[] d = filas.get(i).split(",", -1);
            try {
                if (d.length != 9) throw new IllegalArgumentException("Columnas incorrectas");
                Direccion direccion = new Direccion(d[4].trim(), d[5].trim(), Integer.parseInt(d[6].trim()));
                switch (d[0].trim().toUpperCase()) {
                    case "GUIA" -> resultado.add(new Guias(d[1].trim(), d[2].trim(), d[3].trim(),
                            direccion, d[7].trim().replace("|", ","), d[8].trim()));
                    // Para OPERADOR la última columna (d[8]) se usa como tarifa por persona
                    case "OPERADOR" -> resultado.add(new Operadores(d[1].trim(), d[2].trim(), d[3].trim(),
                            direccion.toString(), d[7].trim().replace("|", ","), Integer.parseInt(d[8].trim())));
                    default -> throw new IllegalArgumentException("Tipo desconocido: " + d[0].trim());
                }
            } catch (IllegalArgumentException | RutInvalidoException error) {
                System.out.println("Fila " + (i + 1) + " de " + ruta.getFileName() + " ignorada: " + error.getMessage());
            }
        }
        return resultado;
    }

    public List<Proveedores> cargarProveedores(Path ruta) throws IOException {
        List<Proveedores> resultados = new ArrayList<>();
        List<String> filas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
        for (int i = 1; i < filas.size(); i++) {
            if (filas.get(i).isBlank()) continue;
            String[] d = filas.get(i).split(",", -1);
            try {
                if (d.length != 10) throw new IllegalArgumentException("Columnas incorrectas");
                Direccion direccion = new Direccion(d[4].trim(), d[5].trim(), Integer.parseInt(d[6].trim()));
                int capacidad = Integer.parseInt(d[8].trim());
                int tarifa = Integer.parseInt(d[9].trim());
                switch (d[0].trim().toUpperCase()) {
                    case "ALOJAMIENTO" -> resultados.add(new ProvAlojamiento(d[1].trim(), d[2].trim(), d[3].trim(),
                            direccion, d[7].trim(), capacidad, tarifa));
                    case "TRANSPORTE" -> resultados.add(new ProvTransporte(d[1].trim(), d[2].trim(), d[3].trim(),
                            direccion, d[7].trim(), capacidad, tarifa));
                    default -> throw new IllegalArgumentException("Tipo desconocido: " + d[0].trim());
                }
            } catch (IllegalArgumentException | RutInvalidoException error) {
                System.out.println("Fila " + (i + 1) + " de " + ruta.getFileName() + " ignorada: " + error.getMessage());
            }
        }
        return resultados;
    }
}
