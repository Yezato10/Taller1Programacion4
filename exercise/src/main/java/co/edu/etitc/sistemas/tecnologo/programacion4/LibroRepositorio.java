package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepositorio implements Repositorio<Libro> {
    private List<Libro> libros = new ArrayList<>();

    @Override
    public void agregar(Libro libro) {
        libros.add(libro);
    }

    @Override
    public void eliminar(Libro libro) {
        libros.remove(libro);
    }

    @Override
    public List<Libro> buscar(String criterio) {
        return libros.stream()
            .filter(libro -> libro.coincideConCriterio(criterio))
            .toList();
    }

    @Override
    public List<Libro> obtenerTodos() {
        return new ArrayList<>(libros);
    }
}