package cl.llanquihuetour.organizador.model;
import cl.llanquihuetour.organizador.util.Validador;

public class Guias extends Colaboradores {
    private String DIRECCION;
    private String idiomas;
    private String sector;

    public Guias(String Nombre, String rut, String Telefono, Direccion Direccion, String Idiomas, String Sector) {

        setnombre(Nombre);
        setrut(rut);
        settelefono(Telefono);
        setdireccion(String.valueOf(Direccion));
        this.idiomas = Idiomas;
        this.sector = Sector;
    }

    public String getIdiomas() {
        return idiomas;
    }
    public void setIdiomas(String Idiomas) {
        this.idiomas = Validador.texto(idiomas, "Idiomas");
    }

    public String getSector() {
        return sector;
    }
    public void setSector(String Area) {
        this.sector = Validador.texto(Area, "Sector");
    }

    @Override
    public String toString() {
        return "Guía { Nombre: " + getnombre() + "\nRut: " + getrut() + "\nTelefono: " + gettelefono()
                + "\nDirección: " + DIRECCION + "\nIdiomas: " + idiomas + "\nSectores: " + sector
                + "}";

    }

}
