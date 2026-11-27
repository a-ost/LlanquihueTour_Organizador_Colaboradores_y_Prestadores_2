package cl.llanquihuetour.organizador.model;

import cl.llanquihuetour.organizador.util.RutInvalidoException;
import cl.llanquihuetour.organizador.util.Validador;

public abstract class Proveedores {
    private String empresa;
    private String rut;
    private String telefono;
    private Direccion direccion;

    public Proveedores() {
    }

    public Proveedores(String empresa, String rut, String telefono, Direccion direccion) throws RutInvalidoException {
        setempresa(empresa);
        setrut(rut);
        settelefono(telefono);
        setdireccion(direccion);
    }

    public String getempresa() {return empresa;}
    public void setempresa(String empresa) {this.empresa = Validador.texto(empresa, "Empresa");}

    public String getrut() {return rut;}
    public void setrut(String rut) throws RutInvalidoException {this.rut = Validador.rut(rut);}

    public String gettelefono() {return telefono;}
    public void settelefono(String telefono) {this.telefono = Validador.telefono(telefono);}

    public Direccion getdireccion() {return direccion;}
    public void setdireccion(Direccion direccion) {this.direccion = Validador.requerido(direccion, "Direccion");}

    @Override
    public String toString() {
        return "Proveedor {Empresa: " + empresa + "\nRut: " + rut + "\nTelefono: "
                + telefono + "\nDireccion: " + direccion + "}";
    }
}
