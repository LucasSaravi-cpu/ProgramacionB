package modelo;


import java.util.Objects;

public class Habilidad {
    private String nombre;

    public Habilidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habilidad habilidad = (Habilidad) o;
        return nombre.equalsIgnoreCase(habilidad.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}

