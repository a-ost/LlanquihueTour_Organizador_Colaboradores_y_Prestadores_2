package cl.llanquihuetour.organizador.model;

import cl.llanquihuetour.organizador.util.Validador;

public class Operadores extends Colaboradores {
    private String Servicio;
    private String Tarifaporpersona;
    private String Direccion;

    public Operadores(){

    }

    public Operadores(String Nombre, String Rut, String Telefono, String Dirección, String Area){
        setnombre(Nombre);
        setrut(Rut);
        settelefono(Telefono);
        setdireccion(Direccion);
        this.Servicio = Servicio;
        this.Tarifaporpersona = Tarifaporpersona;

    }

    public String getServicio (){ return Servicio; }
    public void setServicio (String Servicio) { this.Servicio = Validador.texto(Servicio, "Servicio"); }

    public String getTarifaporpersona () {return Tarifaporpersona;}
    public void  setTarifaporpersona (String Tarifaporpersona) {this.Tarifaporpersona = Validador.positivo(Tarifaporpersona, "Tarifa por persona"); }

    @Override
    public String toString () {
        return "Operador{Nombre: " + getnombre() + "\nRut: " + getrut() + "\nTelefono: " + gettelefono() +
                "\nDirección: " + getdireccion() + "\nServicio: " + Servicio + "\nTarifa por persona: $" + Tarifaporpersona
                + "}";

    }

}
