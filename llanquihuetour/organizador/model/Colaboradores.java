package cl.llanquihuetour.organizador.model;

import cl.llanquihuetour.organizador.util.RutInvalidoException;
import cl.llanquihuetour.organizador.util.Validador;

public class Colaboradores {
     private String nombre;
     private String rut;
     private String telefono;
     private String direccion;

     public Colaboradores() {

     }

     public Colaboradores(String nombre, String rut, String telefono, String direccion) throws RutInvalidoException {
         setnombre(nombre);
         setrut(rut);
         settelefono(telefono);
         setdireccion(direccion);
     }


    public String getnombre () {return nombre;}
    public void setnombre (String nombre) { this.nombre = Validador.texto(nombre, "Nombre");}

    public String getrut () {return rut;}
    public void setrut(String rut) throws RutInvalidoException {this.rut = Validador.rut(rut);}

    public String gettelefono(){return telefono;}
    public void settelefono (String telefono) {this.telefono = Validador.telefono(telefono);}

    public String getdireccion () { return direccion; }
    public void setdireccion (String direccion) {this.direccion = Validador.requerido(direccion, "Dirección");}

    @Override
    public String toString(){return "Colaborador {Nombre: " + nombre + "\nRut: " + rut + "\nTelefono: " + telefono + "\nDirección: " + direccion;
    }

}



