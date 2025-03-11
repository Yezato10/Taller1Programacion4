package co.edu.etitc.sistemas.tecnologo.programacion4;

import java.util.List;

public interface Repositorio<T extends Recurso> { 
    void agregar(T recurso);
    void eliminar(T recurso);
    List<T> buscar(String criterio);
    List<T> obtenerTodos();
}