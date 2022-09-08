package Abstracts;

import Abstracts.Enums.DayOfWeeks;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;


public class Human implements Serializable {
    private String name;
    private String surname;
    private Long birthDate;
    private int iq;
    private Map<DayOfWeeks, String> schedule;
    private Family family;


    public Human(String name, String surname, String date, int iq){
        this.setName(name);
        this.setSurname(surname);
        this.setBirthDate(stringDateParser(date));
        this.setIq(iq);
    }
    public Human(String name, String surname, Long birthDate, int iq, Map<DayOfWeeks, String> schedule, Family family) {
        this.setName(name);
        this.setSurname(surname);
        this.setBirthDate(birthDate);
        this.setIq(iq);
        this.setSchedule(schedule);
        this.setFamily(family);
    }

    public Human() {
    }

    public Human(String name, String surname, Long birthDate) {
        this.setName(name);
        this.setSurname(surname);
        this.setBirthDate(birthDate);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public Map<DayOfWeeks, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeeks, String> schedule) {
        this.schedule = schedule;
    }


    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void greetPet() {
        System.out.println("Hello");
    }

    public String toString() {
        if (iq == 0 && schedule == null) {
            return "{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + getDateString(birthDate) +
                    ", iq = 0" +
                    ", schedule=null" +
                    '}';
        }
        return "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + getDateString(birthDate) +
                ", iq=" + iq +
                ", schedule=" + schedule +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Human)) return false;

        Human human = (Human) obj;

        return this.name.equals(human.name) &&
                this.surname.equals(human.surname) &&
                this.birthDate == human.birthDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname, this.birthDate);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.name + " object collected by Garbage Collector");
    }
    public String describeAge() {
        long current = System.currentTimeMillis() / 1000;
        long duration = current - birthDate / 1000;
        long days = duration / 86400;
        long month = days / 30;
        long year = month / 12;
        String age = String.format("days = %d, months = %d, years = %d", days, month, year);
        return age;
    }

    private long stringDateParser(String date){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try{
            return df.parse(date).getTime();
        }catch (ParseException e){
            e.printStackTrace();
        }
        return -1;
    }

    private String getDateString(long date){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(new Date(date));
    }
}
