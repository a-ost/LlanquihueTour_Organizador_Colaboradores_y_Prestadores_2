package cl.llanquihuetour.organizador.model;

import cl.llanquihuetour.organizador.util.RutInvalidoException;
import cl.llanquihuetour.organizador.util.Validador;

public class Guias extends Colaboradores {
    private String idiomas;
    private String sector;

    public Guias(String nombre, String rut, String telefono, Direccion direccion, String idiomas, String sector) throws RutInvalidoException {
        super(nombre, rut, telefono, Validador.requerido(direccion, "Dirección").toString());
        setIdiomas(idiomas);
        setSector(sector);
    }

    public String getIdiomas() {
        return idiomas;
    }
    public void setIdiomas(String idiomas) {
        this.idiomas = Validador.texto(idiomas, "Idiomas");
    }

    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = Validador.texto(sector, "Sector");
    }

    @Override
    public String toString() {
        return "Guía { Nombre: " + getnombre() + "\nRut: " + getrut() + "\nTelefono: " + gettelefono()
                + "\nDirección: " + getdireccion() + "\nIdiomas: " + idiomas + "\nSector: " + sector
                + "}";
    }
}
