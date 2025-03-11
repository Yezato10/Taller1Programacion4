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


    public abstract boolean coincideConCriterio(String criterio);

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
