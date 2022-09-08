package Abstracts.Pets;

import Abstracts.Pet;
import Abstracts.Species;
import Abstracts.interfaces.FoulAble;

import java.util.Set;

public class DomesticCat extends Pet implements FoulAble {
    public DomesticCat(String nickName) {
        super(nickName);
        super.setSpecies(Species.DOMESTICCAT);
    }

    public DomesticCat(String nickName, int age, int trickLevel, Set<String> habits) {
        super(nickName, age, trickLevel, habits);
        super.setSpecies(Species.DOMESTICCAT);
    }

    @Override
    public void respond() {

    }

    public void foul() {

    }
}

