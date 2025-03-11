package co.edu.etitc.sistemas.tecnologo.programacion4;

import java.time.LocalDateTime;

public class Computador extends Recurso {
    private String marca;
    private TipoComputador tipo;

    public Computador(String titulo, LocalDateTime fechaIngreso, boolean activo,
                      String marca, TipoComputador tipo) {
        super(titulo, fechaIngreso, activo);
        this.marca = marca;
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public TipoComputador getTipo() {
        return tipo;
    }

    @Override
    public boolean coincideConCriterio(String criterio) {
        if (super.coincideConCriterio(criterio)) {
            return true;
        }

        if (criterio == null || criterio.isEmpty()) {
            return false;
        }

        return marca.contains(criterio)
            || tipo.toString().contains(criterio);
    }

    @Override
    public String toString() {
        return super.toString()
            + "marca=" + marca + "\n"
            + "tipo=" + tipo + "\n";
    }
}
