package model;

import java.util.Objects;

public class PetType {
    private long pettype;
    private String description;

    // Constructor vacío
    public PetType() {}

    // Constructor con parámetros
    public PetType(long pettype, String description) {
        this.pettype = pettype;
        this.description = description;
    }

    // Getters y Setters
    public long getPettype() {
        return pettype;
    }

    public void setPettype(long pettype) {
        this.pettype = pettype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetType petType = (PetType) o;
        return pettype == petType.pettype;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pettype);
    }

    @Override
    public String toString() {
        return description;
    }
}

