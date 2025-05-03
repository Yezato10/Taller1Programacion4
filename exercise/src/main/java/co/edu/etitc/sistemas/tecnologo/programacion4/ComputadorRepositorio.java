package co.edu.etitc.sistemas.tecnologo.programacion4;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import org.springframework.data.jdbc.repository.query.Query;

@Repository
public interface ComputadorRepositorio extends CrudRepository<Computador, Integer> {
    @Query("SELECT * FROM COMPUTADOR WHERE nombre LIKE '%' || :criterio || '%' OR TIPO LIKE '%' || :criterio || '%'")
    Collection<Computador> findByCriteria(@Param("criterio") String criterio);
}
