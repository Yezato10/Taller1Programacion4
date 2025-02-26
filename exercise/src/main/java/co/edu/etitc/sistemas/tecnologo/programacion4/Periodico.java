package co.edu.etitc.sistemas.tecnologo.programacion4;

import java.time.LocalDateTime;


public class Periodico extends Recurso {
    private String editorial;
    private LocalDateTime fechaPublicacion;

    public Periodico(String titulo, LocalDateTime fechaIngreso, boolean activo,
                     String editorial, LocalDateTime fechaPublicacion) {
        super(titulo, fechaIngreso, activo);
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public boolean coincideConCriterio(String criterio) {
        if (criterio == null || criterio.isEmpty()) {
            return false;
        }

        if (titulo.contains(criterio)
            || editorial.contains(criterio)
            || fechaPublicacion.toString().contains(criterio)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString()
            + "editorial=" + editorial + "\n"
            + "fechaPublicacion=" + fechaPublicacion + "\n";
    }
}
