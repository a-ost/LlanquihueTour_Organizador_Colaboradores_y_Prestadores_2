package cl.llanquihuetour.organizador.model;

import cl.llanquihuetour.organizador.util.RutInvalidoException;
import cl.llanquihuetour.organizador.util.Validador;

public class ProvTransporte extends Proveedores {
    private String tipoDeVehiculo;
    private int capacidadPasajeros;
    private int tarifaPorPasajero;

    public ProvTransporte(String empresa, String rut, String telefono, Direccion direccion,
                          String tipoDeVehiculo, int capacidadPasajeros, int tarifaPorPasajero) throws RutInvalidoException {
        super(empresa, rut, telefono, direccion);
        setTipoDeVehiculo(tipoDeVehiculo);
        setCapacidadPasajeros(capacidadPasajeros);
        setTarifaPorPasajero(tarifaPorPasajero);
    }

    public String getTipoDeVehiculo() {return tipoDeVehiculo;}
    public void setTipoDeVehiculo(String tipoDeVehiculo) {this.tipoDeVehiculo = Validador.texto(tipoDeVehiculo, "Tipo de vehículo");}

    public int getCapacidadPasajeros() {return capacidadPasajeros;}
    public void setCapacidadPasajeros(int capacidadPasajeros) {this.capacidadPasajeros = Validador.positivo(capacidadPasajeros, "Capacidad de pasajeros");}

    public int getTarifaPorPasajero() {return tarifaPorPasajero;}
    public void setTarifaPorPasajero(int tarifaPorPasajero) {this.tarifaPorPasajero = Validador.positivo(tarifaPorPasajero, "Tarifa por pasajero");}

    @Override
    public String toString() {
        return "Proveedor Transporte { Empresa: " + getempresa() + "\nRut: " + getrut()
                + "\nTelefono: " + gettelefono() + "\nDirección: " + getdireccion()
                + "\nTipo de vehículo: " + tipoDeVehiculo
                + "\nCapacidad de pasajeros: " + capacidadPasajeros
                + "\nTarifa por pasajero: $" + tarifaPorPasajero + "}";
    }
}
