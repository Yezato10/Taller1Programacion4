package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.data.repository.CrudRepository;
import java.util.Collection;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface PeriodicoRepositorio extends CrudRepository<Periodico, Integer> {
    @Query("SELECT * FROM PERIODICO WHERE nombre LIKE '%' || :criterio || '%' OR EDITORIAL LIKE '%' || :criterio || '%'")
    Collection<Periodico> findByCriteria(@Param("criterio") String criterio);
    
}
