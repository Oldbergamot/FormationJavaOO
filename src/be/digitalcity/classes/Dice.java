package be.digitalcity.classes;

import java.util.Random;

//Plutôt que de créer une classe avec constructeur et tout, ici on n'a besoin que d'un dès pour jouer
//il suffit de le lancer autant de fois qu'on a besoin
//Autant faire une méthode static que l'on appellera Dice.throwDice();

public class Dice {

    public static int throwDice(int face) {
        Random r = new Random();
        return r.nextInt(face)+1;
    }
}
