package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.data.repository.CrudRepository;
import java.util.Collection;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface LibroRepositorio extends CrudRepository<Libro, Integer> {
    @Query("SELECT * FROM LIBRO WHERE nombre LIKE '%' || :criterio || '%' OR AUTOR LIKE '%' || :criterio || '%'")
    Collection<Libro> findByCriteria(@Param("criterio") String criterio);
}
