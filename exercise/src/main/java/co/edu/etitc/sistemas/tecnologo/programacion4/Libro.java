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


    @Override
    public boolean coincideConCriterio(String criterio) {
        if (criterio == null || criterio.isEmpty()) {
            return false;
        }

        if (titulo.contains(criterio)
            || autor.contains(criterio)
            || editorial.contains(criterio)
            || String.valueOf(año).contains(criterio)) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
  
        return super.toString()
            + "autor=" + autor + "\n"
            + "editorial=" + editorial + "\n"
            + "año=" + año + "\n";
    }
}
