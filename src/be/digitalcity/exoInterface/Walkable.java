package be.digitalcity.exoInterface;

public interface Walkable {

    void walk();

    void eat();

    default void move(){ //possible de définir un comportement dans une interface si on ajoute le mot clé default
        System.out.println("default move");
    }
}
