package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PeriodicoRepositorio  implements Repositorio<Periodico> {
    private List<Periodico> periodicos = new ArrayList<>();

    @Override
    public void agregar(Periodico periodico) {
        periodicos.add(periodico);
    }

    @Override
    public void eliminar(Periodico periodico) {
        periodicos.remove(periodico);
    }

    @Override
    public List<Periodico> buscar(String criterio) {
        List<Periodico> resultados = new ArrayList<>();
        for (Periodico periodico : periodicos) {
            if (periodico.coincideConCriterio(criterio)) {
                resultados.add(periodico);
            }
        }
        return resultados;
    }

    @Override
    public List<Periodico> obtenerTodos() {
        return new ArrayList<>(periodicos);
    }
}