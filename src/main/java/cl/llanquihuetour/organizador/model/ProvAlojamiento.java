package cl.llanquihuetour.organizador.model;

import cl.llanquihuetour.organizador.util.Validador;

public class ProvAlojamiento extends Proveedores {
   private String tipoAlojamiento;
   private int capacidad;
   private int precioNoche;

   public ProvAlojamiento(String empresa, String rut, String Telefono, Direccion direccion, String tipoAlojamiento, int capacidad, int precioNoche) {
       this.tipoAlojamiento = tipoAlojamiento;
       this.capacidad = capacidad;
       this.precioNoche = precioNoche;
       setrut(rut);
       setempresa(empresa);
       String telefono = "";
       settelefono(telefono);
       setdireccion(direccion);

   }

   public String getTipoAlojamiento () {return tipoAlojamiento;}
    public void setTipoAlojamiento (String tipoAlojamiento) {this.tipoAlojamiento = Validador.texto(tipoAlojamiento, "Tipo de alejamiento");}

    public int getCapacidad () {return capacidad;}
    public void setCapacidad (int capacidad) {this.capacidad = Validador.positivo(capacidad, "Capacidad" );}

    public int getPrecioNoche () {return precioNoche;}
    public void setPrecioNoche (int precioNoche) {this.precioNoche = Validador.positivo(precioNoche, "Precio por noche");}

    @Override
    public String toString() {
       return "Proveedor Alojamiento{ Empresa: " + getempresa() + "\nRut: " + getrut() +
               "\nTelefono: " + gettelefono() + "\nDirección: " + getdireccion() + "\nTipo de alojamiento" + tipoAlojamiento
               + "\nCapacidad: " + capacidad + "\nPrecio por noche: " + precioNoche + "}";


    }

    @Override
    public String toSting() {
        return "";
    }


}

