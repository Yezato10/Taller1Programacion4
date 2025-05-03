package co.edu.etitc.sistemas.tecnologo.programacion4;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("COMPUTADOR")
public class Computador implements Recurso {
    @Id
    private Integer id;
    private String nombre;
    private LocalDateTime fechaIngreso;
    private boolean activo;
    private String marca;
    private String modelo;
    private String sistemaOperativo;
    private TipoComputador tipo;

    // Constructor vacío
    public Computador() {}

    // Constructor
    public Computador(String nombre, LocalDateTime fechaIngreso, boolean activo, 
                     String marca, String modelo, String sistemaOperativo, TipoComputador tipo) {
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.activo = activo;
        this.marca = marca;
        this.modelo = modelo;
        this.sistemaOperativo = sistemaOperativo;
        this.tipo = tipo;
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
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getSistemaOperativo() { return sistemaOperativo; }
    public void setSistemaOperativo(String sistemaOperativo) { this.sistemaOperativo = sistemaOperativo; }
    public TipoComputador getTipo() { return tipo; }
    public void setTipo(TipoComputador tipo) { this.tipo = tipo; }

    @Override
    public void darDeBaja() {
        this.activo = false;
    }

    @Override
    public String toString() {
        return "Computador[id=" + id + ", nombre=" + nombre + ", activo=" + activo + "]";
    }
}