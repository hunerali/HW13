package Dao;

import Abstracts.Family;
import Abstracts.Human;
import Abstracts.Humans.Man;
import Abstracts.Humans.Women;
import Abstracts.Pet;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    CollectionFamilyDao collectionFamilyDao = new CollectionFamilyDao();

    public List<Family> getAllFamilies() {
        return collectionFamilyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        getAllFamilies().forEach(System.out::println);
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return getAllFamilies().stream().filter(x -> x.countFamily() > count).collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int count) {
        return getAllFamilies().stream().filter(x -> x.countFamily() < count).collect(Collectors.toList());
    }

    public List<Family> countFamiliesWithMemberNumber(int count) {
        return getAllFamilies().stream().filter(x -> x.countFamily() == count).collect(Collectors.toList());
    }

    public Family createNewFamily(Human mother, Human father) {
        Family family = new Family(mother, father);
        collectionFamilyDao.saveFamily(family);
        return family;
    }

    public int count() {
        return getAllFamilies().size();
    }

    public Family getFamilyByIndex(int index) {
        return collectionFamilyDao.getFamilyByIndex(index);
    }

    public void deleteFamilyByIndex(int index) {
        collectionFamilyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String type) {
        Human human;
        if ("Masculine".equalsIgnoreCase(type)) {
            human = new Man();
            human.setName("Boyname");
        } else if ("Feminine".equalsIgnoreCase(type)) {
            human = new Women();
            human.setName("GirlName");
        } else {
            throw new RuntimeException("This gender does not exist.");
        }
        family.addChild(human);
        collectionFamilyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family,Human human) {
        family.addChild(human);
        collectionFamilyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThan(int age) {
       getAllFamilies().forEach(f ->
               f.getChildren().removeAll(
               f.getChildren().stream().filter(ch ->
                       LocalDate.now().getYear() - ch.getBirthDate() > age)
                       .collect(Collectors.toList())));
    }

    public Set<Pet> getPets(int index) {
       return getAllFamilies().get(index).getPets();
    }


    public void addPet(int index, Pet pet) {
        Family family = getAllFamilies().get(index);
        Set<Pet> pets = family.getPets();
        pets.add(pet);
        family.setPets(pets);
        collectionFamilyDao.saveFamily(family);
    }

    public List<Family> loadFile(){
        return collectionFamilyDao.loadFile();
    }
    public void saveFile(){
        collectionFamilyDao.saveFile();
    }
}
