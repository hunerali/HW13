package Abstracts;

import Abstracts.Humans.Women;

import java.io.Serializable;
import java.util.*;

public class Family implements Serializable {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.pets = getPets();
        this.children = new ArrayList<>();
        father.setFamily(this);
        mother.setFamily(this);
    }

    public void addChild(Human child) {
        child.setFamily(this);
        children.add(child);
        setChildren(children);
    }

    public void deleteChild(int index) {
        if (index < children.size()) {
            for (int i = 0; i < children.size(); i++) {
                if (i == index) getChildren().remove(i);
            }
        }
    }


    public int countFamily() {
        return 2 + getChildren().size();
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        if (pets == null) {
            this.pets = new HashSet<>();
        }
        this.pets.add(pet);
    }

    @Override
    public String toString() {
        return prettyFormat();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return mother.equals(family.mother) && father.equals(family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this + " object collected by Garbage Collector");
    }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("Family:\n");
        sb.append("\tmother: " + mother + ",\n");
        sb.append("\tfather: " + father + ",\n");
        sb.append("\tchildren:\n");
        for (Human child : children) {
            if (child instanceof Women)
                sb.append("\t\tgirl: " + child + "\n");
            else
                sb.append("\t\tboy: " + child + "\n");
        }
        sb.append("\tpets: " + pets + "\n");
        return sb.toString();

    }
}

