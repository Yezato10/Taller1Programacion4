package co.edu.etitc.sistemas.tecnologo.programacion4;

import java.util.ArrayList;
import java.util.List;


public class ServicioBiblioteca {
    private List<Recurso> listaRecursos; 

    public ServicioBiblioteca() {
        
        listaRecursos = new ArrayList<>();
    }


    public void agregarRecurso(Recurso r) {
        listaRecursos.add(r);
    }


    public List<Recurso> buscarRecursos(String criterio) {
        List<Recurso> encontrados = new ArrayList<>();
        for (Recurso r : listaRecursos) {
            if (r.coincideConCriterio(criterio)) {
                encontrados.add(r);
            }
        }
        return encontrados;
    }


    public void eliminarRecurso(Recurso r) {
        listaRecursos.remove(r);
    }

 
    public List<Recurso> obtenerTodos() {
   
        return listaRecursos;
    }
}

