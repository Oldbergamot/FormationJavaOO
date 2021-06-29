package be.digitalcity.lambda;

import be.digitalcity.lambda.Person;

public class CritèreRecherche {

    public boolean test(Person p, String nom) {
        return p.getNom().equalsIgnoreCase(nom);
    }

    public boolean test1(Person p, String prenom) {
        return p.getPrenom().equals(prenom);
    }
}
