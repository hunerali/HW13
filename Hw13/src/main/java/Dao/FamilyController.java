package Dao;

import Abstracts.Family;
import Abstracts.Human;
import Abstracts.Pet;
import Abstracts.exception.FamilyOverflowException;

import java.util.List;
import java.util.Set;

public class FamilyController {

    FamilyService familyService = new FamilyService();

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return familyService.getFamiliesBiggerThan(count);
    }

    public List<Family> getFamiliesLessThan(int count) {
        return familyService.getFamiliesLessThan(count);
    }

    public List<Family> countFamiliesWithMemberNumber(int count) {
        return familyService.countFamiliesWithMemberNumber(count);
    }

    public Family createNewFamily(Human mother, Human father) {
        return familyService.createNewFamily(mother, father);
    }

    public void deleteFamilyByIndex(int index) {
        familyService.deleteFamilyByIndex(index);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyByIndex(int index) {
        return familyService.getFamilyByIndex(index);
    }

    public Family bornChild(Family family, String type) {
        if (family.countFamily()<=12)
            return familyService.bornChild(family, type);
       throw new  FamilyOverflowException("besdi dayanin");
    }

    public Family adoptChild(Family family, Human human) {
        if (family.countFamily()<=12)
            return familyService.adoptChild(family, human);
        throw new  FamilyOverflowException("yeter artiq");
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThan(age);
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public List<Family> loadFile(){
        return familyService.loadFile();
    }

    public void saveFile(){
        familyService.saveFile();
    }

}
