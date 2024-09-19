package model;

import java.util.Date;
import java.util.Objects;

public class Pet {
    private long pet;
    private String name;

    private int yearofbirth;
    private String notes;
    private PetType pettype;

    // Constructor vacío
    public Pet() {}

    // Constructor con parámetros
    public Pet(long pet, String name, int yearofbirth, String notes, PetType pettype) {
        this.pet = pet;
        this.name = name;
        this.yearofbirth = yearofbirth;
        this.notes = notes;
        this.pettype = pettype;
    }

    // Getters y Setters
    public long getPet() {
        return pet;
    }

    public void setPet(long pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearofbirth() {
        return yearofbirth;
    }

    public void setYearofbirth(int yearofbirth) {
        this.yearofbirth = yearofbirth;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet1 = (Pet) o;
        return pet == pet1.pet && name.equals(pet1.name) && pettype.equals(pet1.pettype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pet, name, pettype);
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public PetType getPettype() {
        return pettype;
    }

    public void setPettype(PetType pettype) {
        this.pettype = pettype;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "pet=" + pet +
                ", name='" + name + '\'' +
                ", yearofbirt=" + yearofbirth +
                ", notes='" + notes + '\'' +
                ", pettype=" + pettype +
                '}';
    }
}
