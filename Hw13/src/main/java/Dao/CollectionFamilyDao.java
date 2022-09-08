package Dao;

import Abstracts.Family;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> families = new ArrayList<>();
    private final String filePath = "db.bin";

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (families.get(index) != null) return families.get(index);
        else return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < families.size() && index >= 0) {
            families.remove(families.get(index));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        this.families.remove(family);
        return true;
    }

    @Override
    public void saveFamily(Family family) {
        if (families.contains(family)) families.set(families.indexOf(family), family);
        else families.add(family);
    }

    @Override
    public void saveFile() {
        File file = new File(filePath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(families);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public List<Family> loadFile(){
        File file = new File(filePath);
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = oos.readObject();
            List<Family> familyList = new ArrayList<>((List<Family>) obj);
            this.families = familyList;
            return families;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
