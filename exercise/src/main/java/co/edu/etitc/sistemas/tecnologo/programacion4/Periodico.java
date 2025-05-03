package co.edu.etitc.sistemas.tecnologo.programacion4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PERIODICO")
public class Periodico implements Recurso {
    @Id
    private Integer id;
    private String nombre;
    private LocalDateTime fechaIngreso;
    private boolean activo;
    private LocalDate fechaPublicacion;
    private String editorial;

    // Constructor vacío
    public Periodico() {}

    // Constructor
    public Periodico(String nombre, LocalDateTime fechaIngreso, boolean activo, 
                    LocalDate fechaPublicacion, String editorial) {
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.activo = activo;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    @Override public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    @Override public LocalDateTime getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDateTime fechaIngreso) { this.fechaIngreso = fechaIngreso; }
    @Override public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }
    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }

    @Override
    public void darDeBaja() {
        this.activo = false;
    }

    @Override
    public String toString() {
        return "Periodico[id=" + id + ", nombre=" + nombre + ", activo=" + activo + "]";
    }
}
