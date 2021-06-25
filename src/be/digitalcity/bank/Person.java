package be.digitalcity.bank;

import java.time.LocalDate;

public class Person {

    private String name;
    private String firstName;
    private LocalDate birthday;

    public Person(String name, String firstName, LocalDate birthday) {
        this.name = name;
        this.firstName = firstName;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String displayPerson(){
        return "Name : "+name+ ", Firstname : "+firstName+ ", Birthday : "+birthday;
    }
}
