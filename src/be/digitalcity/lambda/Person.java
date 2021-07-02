package be.digitalcity.lambda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Objects;

public class Person {
    private String nom;
    private String prenom;
    private int age;
    private LocalDate dateEngagement;

    public Person(String nom, String prenom, int age, LocalDate dateEngagement) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.dateEngagement = dateEngagement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateEngagement() {
        return dateEngagement;
    }

    public void setDateEngagement(LocalDate dateEngagement) {
        this.dateEngagement = dateEngagement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(nom, person.nom) && Objects.equals(prenom, person.prenom) && Objects.equals(dateEngagement, person.dateEngagement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, age, dateEngagement);
    }

    @Override
    public String toString() {
        return "Person{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", dateEngagement=" + dateEngagement +
                '}';
    }

    public long convertDateEngagement() {
        return LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli() - dateEngagement
                .atTime(0,0,0)
                .toInstant(ZoneOffset.UTC)
                .toEpochMilli();
    }
}
