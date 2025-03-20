package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ComputadorRepositorio implements Repositorio<Computador> {
    private List<Computador> computadores = new ArrayList<>();

    @Override
    public void agregar(Computador computador) {
        computadores.add(computador);
    }

    @Override
    public void eliminar(Computador computador) {
        computadores.remove(computador);
    }

    @Override
    public List<Computador> buscar(String criterio) {
        List<Computador> resultados = new ArrayList<>();
        for (Computador computador : computadores) {
            if (computador.coincideConCriterio(criterio)) {
                resultados.add(computador);
            }
        }
        return resultados;
    }

    @Override
    public List<Computador> obtenerTodos() { 
        return new ArrayList<>(computadores);
    }
}