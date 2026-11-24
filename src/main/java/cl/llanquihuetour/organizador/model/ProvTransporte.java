package cl.llanquihuetour.organizador.model;

import cl.llanquihuetour.organizador.util.Validador;

public class ProvTransporte extends Proveedores {
    private String tipoDeVehiculo;
    private int capacidadPasajeros;
    private int tarifaPorPasajero;

    public ProvTransporte(String empresa, String rut, String telefono, Direccion direccion, String
            tipoDeVehiculo, int capacidadPasajeros, int tarifaPorPasajero) {
        this.tipoDeVehiculo = tipoDeVehiculo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.tarifaPorPasajero = tarifaPorPasajero;
        setdireccion(direccion);
        setempresa(empresa);
        setrut(rut);
        settelefono(telefono);
    }

    public String getTipoDeVehiculo () {return tipoDeVehiculo; }
    public void setTipoDeVehiculo (String tipoDeVehiculo) {this.tipoDeVehiculo = Validador.texto(tipoDeVehiculo, "Tipo de vehículo"); }

    public int getCapacidadPasajeros () {return capacidadPasajeros;}
    public void setCapacidadPasajeros (int capacidadPasajeros) {this.capacidadPasajeros = Validador.positivo(capacidadPasajeros, "Capacidad de pasajeros");}

    public int getTarifaPorPasajero () {return tarifaPorPasajero;}
    public void setTarifaPorPasajero (int tarifaPorPasajero) {this.tarifaPorPasajero = Validador.positivo(tarifaPorPasajero, "Tarifa por pasajero");}

@Override
public String toSting () {
        return "Proveedor Transporte{Empresa: " + getempresa() + "\nRut: " + getrut() + "\nTelefono: " + gettelefono()
                + "\nDirección: " + "Tipo de vehiculo" + tipoDeVehiculo + "\nCapacidad de pasajero: " + capacidadPasajeros
                + "\nTarifa por pasajero: " + tarifaPorPasajero + "}";

}



























}
