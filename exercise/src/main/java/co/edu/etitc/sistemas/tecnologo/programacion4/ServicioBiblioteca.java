package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.stereotype.Service;  
import java.util.ArrayList;
import java.util.Collection;

@Service
public class ServicioBiblioteca {
    private LibroRepositorio repositorioLibros;
    private PeriodicoRepositorio repositorioPeriodicos;
    private ComputadorRepositorio repositorioComputadores;
    
    //constructores
    public ServicioBiblioteca(
        LibroRepositorio repositorioLibros,
        PeriodicoRepositorio repositorioPeriodicos, 
        ComputadorRepositorio repositorioComputadores
    ) {
        this.repositorioLibros = repositorioLibros;
        this.repositorioPeriodicos = repositorioPeriodicos;
        this.repositorioComputadores = repositorioComputadores;
    }


    public void agregar(Recurso recurso) {
        if (recurso instanceof Libro) repositorioLibros.save((Libro) recurso);
        else if (recurso instanceof Periodico) repositorioPeriodicos.save((Periodico) recurso);
        else if (recurso instanceof Computador) repositorioComputadores.save((Computador) recurso);
    }

    public void quitarRecurso(Recurso recurso) {
        if (recurso instanceof Libro) repositorioLibros.delete((Libro) recurso);
        else if (recurso instanceof Periodico) repositorioPeriodicos.delete((Periodico) recurso);
        else if (recurso instanceof Computador) repositorioComputadores.delete((Computador) recurso);
    }

    public Collection<Recurso> buscarRecursos(String criterio) {
        Collection<Recurso> resultados = new ArrayList<>();
        resultados.addAll(repositorioLibros.findByCriteria(criterio));
        resultados.addAll(repositorioPeriodicos.findByCriteria(criterio));
        resultados.addAll(repositorioComputadores.findByCriteria(criterio));
        return resultados;
    }

    public Collection<Recurso> obtenerTodos() {
        Collection<Recurso> todos = new ArrayList<>();
        repositorioLibros.findAll().forEach(todos::add);
        repositorioPeriodicos.findAll().forEach(todos::add);
        repositorioComputadores.findAll().forEach(todos::add);
        return todos;
    }
}
