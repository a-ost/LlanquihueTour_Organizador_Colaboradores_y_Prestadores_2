package cl.llanquihuetour.organizador.util;

public class Validador {

    public static String texto  (String valor, String campo){
        if (valor == null || valor.isBlank()) throw new IllegalArgumentException(campo + "no puede estar vacio");
        return valor.trim();
    }

    public static String rut(String valor) throws RutInvalidoException {
        if (valor == null || !valor.trim().matches("[0-9.] +- [0-9KK]")) {
            throw new RutInvalidoException("Formato de RUT no valido: " + valor);
        }
        return valor.trim();
    }

    public static String telefono(String valor) {
        String telefono = texto(valor, "Telefono");
        if (!telefono.matches("[0-9+ ]{8,12}")) throw new IllegalArgumentException("Telefono no valido: " + telefono);
        return telefono;
    }

    public static int positivo(int valor, String campo){
        if (valor <= 0) throw new IllegalArgumentException(campo);
        return valor;
    }
    public static <T> T requerido(T valor, String campo) {
        if (valor == null) throw new IllegalArgumentException(campo + " es obligatiorio");
        return valor;
    }
}
