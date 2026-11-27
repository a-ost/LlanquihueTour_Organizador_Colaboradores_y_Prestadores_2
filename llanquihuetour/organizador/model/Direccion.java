package cl.llanquihuetour.organizador.model;

import cl.llanquihuetour.organizador.util.Validador;

public class Direccion {
    private String calle;
    private int numero;
    private String comuna;


    public Direccion(String calle, String comuna, int numero) {
        setcalle(calle);
        setnumero(numero);
        setcomuna(comuna);

    }


    public String getcalle() {
        return calle;
    }
    public void setcalle(String calle) {
        this.calle = Validador.texto(calle, "Calle");
    }

    public int getnumero() {
        return numero;
    }
    public void setnumero(int numero) {
        this.numero = Validador.positivo(numero, "Numero");
    }

    public String getcomuna() {
        return comuna;
    }
    public void setcomuna(String comuna) {
        this.comuna = Validador.texto(comuna, "Comuna");
    }

    @Override
    public String toString() {
        return calle + "" + numero + ", " + comuna;
    }

}