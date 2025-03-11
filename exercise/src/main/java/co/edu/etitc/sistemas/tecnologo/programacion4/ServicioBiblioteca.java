package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioBiblioteca {
    private final Repositorio<Libro> libroRepo;
    private final Repositorio<Periodico> periodicoRepo;
    private final Repositorio<Computador> computadorRepo;

    @Autowired
    public ServicioBiblioteca(
        @Qualifier("libroRepositorio") Repositorio<Libro> libroRepo,
        @Qualifier("periodicoRepositorio") Repositorio<Periodico> periodicoRepo,
        @Qualifier("computadorRepositorio") Repositorio<Computador> computadorRepo) {
        
        this.libroRepo = libroRepo;
        this.periodicoRepo = periodicoRepo;
        this.computadorRepo = computadorRepo;
    }

    // Métodos públicos para agregar recursos
    public void agregarLibro(Libro libro) {
        libroRepo.agregar(libro);
    }

    public void agregarPeriodico(Periodico periodico) {
        periodicoRepo.agregar(periodico);
    }

    public void agregarComputador(Computador computador) {
        computadorRepo.agregar(computador);
    }

    public List<Recurso> buscarRecursos(String criterio) {
        List<Recurso> resultados = new ArrayList<>();
        resultados.addAll(libroRepo.buscar(criterio));
        resultados.addAll(periodicoRepo.buscar(criterio));
        resultados.addAll(computadorRepo.buscar(criterio));
        return resultados;
    }

    public List<Recurso> obtenerTodos() {
        List<Recurso> todos = new ArrayList<>();
        todos.addAll(libroRepo.obtenerTodos());
        todos.addAll(periodicoRepo.obtenerTodos());
        todos.addAll(computadorRepo.obtenerTodos());
        return todos;
    }


    public void eliminarRecurso(Recurso recurso) {
        if (recurso instanceof Libro) {
            libroRepo.eliminar((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            periodicoRepo.eliminar((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            computadorRepo.eliminar((Computador) recurso);
        }
    }
}