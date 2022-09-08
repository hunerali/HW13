package Abstracts.Pets;


import Abstracts.Pet;
import Abstracts.Species;
import Abstracts.interfaces.FoulAble;

import java.util.Set;

public class RoboCat extends Pet implements FoulAble {
    public RoboCat(String nickName) {
        super(nickName);
        super.setSpecies(Species.ROBOCAT);
    }
    public RoboCat(  String nickName, int age, int trickLevel, Set<String> habits) {
        super(nickName,age,trickLevel,habits);
        super.setSpecies(Species.ROBOCAT);
    }
    @Override
    public void respond() {

    }

    public void foul() {

    }
}
