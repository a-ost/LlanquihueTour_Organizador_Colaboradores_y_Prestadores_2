package cl.llanquihuetour.organizador.model;

import cl.llanquihuetour.organizador.util.RutInvalidoException;
import cl.llanquihuetour.organizador.util.Validador;

public class Operadores extends Colaboradores {
    private String servicio;
    private int tarifaPorPersona;

    public Operadores(String nombre, String rut, String telefono, String direccion, String servicio, int tarifaPorPersona) throws RutInvalidoException {
        super(nombre, rut, telefono, direccion);
        setServicio(servicio);
        setTarifaPorPersona(tarifaPorPersona);
    }

    public String getServicio() {return servicio;}
    public void setServicio(String servicio) {this.servicio = Validador.texto(servicio, "Servicio");}

    public int getTarifaPorPersona() {return tarifaPorPersona;}
    public void setTarifaPorPersona(int tarifaPorPersona) {
        this.tarifaPorPersona = Validador.positivo(tarifaPorPersona, "Tarifa por persona");
    }

    @Override
    public String toString() {
        return "Operador { Nombre: " + getnombre() + "\nRut: " + getrut() + "\nTelefono: " + gettelefono()
                + "\nDirección: " + getdireccion() + "\nServicio: " + servicio
                + "\nTarifa por persona: $" + tarifaPorPersona + "}";
    }
}
