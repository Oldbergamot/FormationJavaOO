package be.digitalcity.exoInterface;

public class Human implements Walkable, Humanable {

    String nom;
    int age;

    public Human(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    @Override
    public void sePlaindre() {
        System.out.println("pfffffff");
    }

    @Override
    public void walk() {
        System.out.println("walk humanly");
    }

    @Override
    public void eat() {
        System.out.println("eat humanly");
    }

    void lundiMatin() {
        sePlaindre();
        sePlaindre();
    }
}
