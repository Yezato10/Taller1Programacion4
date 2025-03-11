package co.edu.etitc.sistemas.tecnologo.programacion4;

import java.time.LocalDateTime;


public abstract class Recurso {
    private String titulo;         
    private LocalDateTime fechaIngreso; 
    private boolean activo;        


    public Recurso(String titulo, LocalDateTime fechaIngreso, boolean activo) {
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
        this.activo = activo;
    }



    @Override
    public String toString() {
        return getClass().getSimpleName() + "\n"  
            + "titulo=" + titulo + "\n"
            + "fechaIngreso=" + fechaIngreso + "\n"
            + "activo=" + activo + "\n";
    }


    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public boolean isActivo() {
        return activo;
    }
}

 public boolean coincideConCriterio(String criterio) {
        if (criterio == null || criterio.isEmpty()) {
            return false;
        }
        return titulo.contains(criterio) || fechaIngreso.toString().contains(criterio);
    }
}
