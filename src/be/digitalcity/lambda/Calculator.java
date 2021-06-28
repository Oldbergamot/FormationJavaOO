package be.digitalcity.lambda;
/*
Ceci est une interface fonctionnelle car elle n'a qu'une seule signature
on peut ajouter @FunctionalInterface, ce n'est pas nécessaire
 */

@FunctionalInterface
public interface Calculator {
    void effectuerOperation(int[] data);
}
