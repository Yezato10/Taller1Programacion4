package co.edu.etitc.sistemas.tecnologo.programacion4;

import java.time.LocalDateTime;

public class Libro extends Recurso {
    private String autor;
    private String editorial;
    private int año;

    public Libro(String titulo, LocalDateTime fechaIngreso, boolean activo,
                 String autor, String editorial, int año) {
        super(titulo, fechaIngreso, activo);
        this.autor = autor;
        this.editorial = editorial;
        this.año = año;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAño() {
        return año;
    }

    @Override
    public boolean coincideConCriterio(String criterio) {
        if (super.coincideConCriterio(criterio)) {
            return true;
        }

        if (criterio == null || criterio.isEmpty()) {
            return false;
        }

        return autor.contains(criterio)
            || editorial.contains(criterio)
            || String.valueOf(año).contains(criterio);
    }

    @Override
    public String toString() {
        return super.toString()
            + "autor=" + autor + "\n"
            + "editorial=" + editorial + "\n"
            + "año=" + año + "\n";
    }
}

