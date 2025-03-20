package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
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
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.coincideConCriterio(criterio)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    @Override
    public List<Libro> obtenerTodos() { 
        return new ArrayList<>(libros);
    }
}