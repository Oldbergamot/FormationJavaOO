package be.digitalcity.classes;

import java.time.LocalDate;

public class Human {

    private String name;
    private String lastName;
    private LocalDate birthDate;

    private static int COUNT = 0;

    public Human ( String name, String lastName , LocalDate birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        COUNT++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate date) {
        this.birthDate = date;
    }

    public static int getCOUNT(){
        return COUNT;
    }

    public void displayPerson() {
        System.out.println("name : " + this.name +" , last name : "+this.lastName + " , birthday : "+this.birthDate);
    }
}
