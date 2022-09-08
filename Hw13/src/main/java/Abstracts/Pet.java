package Abstracts;


import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public abstract class Pet implements Serializable { private Species species;
    private String nickName;
    private int age;
    private int trickLevel;
    private Set<String> habits;

    public Pet() {

    }

    public Pet(String nickName) {
        this.setSpecies(Species.UNKNOWN);
        this.setNickName(nickName);
    }
    public Pet(  String nickName, int age, int trickLevel, Set<String> habits) {
        this.setSpecies(Species.UNKNOWN);
        this.setNickName(nickName);
        this.setAge(age);
        this.setTrickLevel(trickLevel);
        this.setHabits(habits);
    }


    public void eat() {
        System.out.println("I am eating.");
    }

    public abstract void respond();

    public Species getSpecies() {
        return Species.valueOf(species.name());
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    @Override
    public String toString() {
        return "{" +
                "species:" +  this.getSpecies().name() +
                ", nickName='" + getNickName() + '\'' +
                ", age=" + getAge() +
                ", trickLevel=" + getTrickLevel() +
                ", habits=" + habits +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Pet)) return false;

        Pet pet = (Pet) obj;
        return this.nickName.equals(pet.nickName) &&
                this.species.equals(pet.species) &&
                this.age == pet.age &&
                this.trickLevel == pet.trickLevel;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.nickName + " object collected by Garbage Collector");
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickName, age, trickLevel);
    }
}


