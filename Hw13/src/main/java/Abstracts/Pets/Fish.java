package Abstracts.Pets;


import Abstracts.Pet;
import Abstracts.Species;

import java.util.Set;

public class Fish extends Pet {
    public Fish(String nickName) {
        super(nickName);
        super.setSpecies(Species.FISH);
    }
    public Fish(  String nickName, int age, int trickLevel, Set<String > habits) {
        super(nickName,age,trickLevel,habits);
        super.setSpecies(Species.FISH);
    }
    @Override
    public void respond() {

    }
}
