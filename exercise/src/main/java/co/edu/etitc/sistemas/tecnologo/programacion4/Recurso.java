package co.edu.etitc.sistemas.tecnologo.programacion4;

import java.time.LocalDateTime;

public interface Recurso {
    Integer getId();
    String getNombre();
    LocalDateTime getFechaIngreso();
    boolean isActivo();
    void darDeBaja();
    String toString();
}
