package be.digitalcity.bank;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(firstName, person.firstName) && Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, firstName, birthday);
    }
}
