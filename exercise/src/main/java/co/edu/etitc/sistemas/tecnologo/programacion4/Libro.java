package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
import org.springframework.data.relational.core.mapping.Table;


@Table("LIBRO")
public class Libro implements Recurso {
    @Id
    private Integer id;
    private String nombre;
    private LocalDateTime fechaIngreso;
    private boolean activo;
    private String autor;
    private String editorial;
    private int anio;
    
    // Constructor vacío 
    public Libro() {}

    // Constructor
    public Libro(String nombre, LocalDateTime fechaIngreso, boolean activo, 
                String autor, String editorial, int anio) {
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.activo = activo;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
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
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    @Override
    public void darDeBaja() {
        this.activo = false;
    }

    @Override
    public String toString() {
        return "Libro[id=" + id + ", nombre=" + nombre + ", activo=" + activo + "]";
    }

}
