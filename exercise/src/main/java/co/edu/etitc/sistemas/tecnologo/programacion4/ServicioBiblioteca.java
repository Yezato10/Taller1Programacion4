package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.stereotype.Service;  
import java.util.ArrayList;
import java.util.Collection;

@Service
public class ServicioBiblioteca {
    private LibroRepositorio repositorioLibros;
    private PeriodicoRepositorio repositorioPeriodicos;
    private ComputadorRepositorio repositorioComputadores;
    
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

    public void quitarRecurso(Integer id, String tipo) {
        switch(tipo.toLowerCase()) {
            case "libro":
                repositorioLibros.deleteById(id);
                break;
            case "periodico":
                repositorioPeriodicos.deleteById(id);
                break;
            case "computador":
                repositorioComputadores.deleteById(id);
                break;
            default:
                throw new IllegalArgumentException("Tipo de recurso no válido: " + tipo);
        }
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