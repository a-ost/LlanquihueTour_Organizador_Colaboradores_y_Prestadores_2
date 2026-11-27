package cl.llanquihuetour.organizador.service;

import cl.llanquihuetour.organizador.model.Colaboradores;
import cl.llanquihuetour.organizador.model.Proveedores;
import cl.llanquihuetour.organizador.model.Guias;

import java.util.List;
import java.util.ArrayList;

public class GestorTour{
    private final List <Colaboradores> colaboradores = new ArrayList<>();
    private final List <Proveedores> proveedores = new ArrayList<>();

    public void agregarColaboradores (List<Colaboradores> datos) {colaboradores.addAll(datos);}
    public List<Colaboradores> listarColaboradores(){return colaboradores;}

    public void agregarProveedores (List<Proveedores> datos) {proveedores.addAll(datos);}
    public List<Proveedores> listarProveedores(){return proveedores;}

    public Colaboradores buscarColaborador(String rut){
        String buscador = rut.trim().replace(".","");
        for (Colaboradores c : colaboradores){
            if (c.getrut().replace(".","").equalsIgnoreCase(buscador)) return c;
        }
        return null;
    }

    public List<Colaboradores> buscarPorNombre (String nombre){
        List<Colaboradores> resultado = new ArrayList<>();
        for (Colaboradores c : colaboradores){
            if ( c.getnombre().toLowerCase().contains(nombre.trim().toLowerCase())) resultado.add(c);
        }
        return resultado;
    }

    public List<Proveedores> filtrarProveedoresPorComuna (String comuna){
        List<Proveedores> resultado = new ArrayList<>();
        for (Proveedores p : proveedores){
            if (p.getdireccion().getcomuna().equalsIgnoreCase(comuna.trim())) resultado.add(p);
        }
        return resultado;
    }

    public List<Guias> filtrarGuiasPorIdioma (String idioma){
        List<Guias> resultado = new ArrayList<>();
        for (Colaboradores c : colaboradores){
            if (c instanceof Guias g && g.getIdiomas().toLowerCase().contains(idioma.trim().toLowerCase())){
                resultado.add(g);
            }
        }
        return resultado;
    }


}