package be.digitalcity.généricité;

import be.digitalcity.lambda.Person;
import be.digitalcity.lambda.PersonneSimplifiée;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Directeur <Secretaire> dir = new Directeur<>();

        dir.nom = "Jean Jean";
//        Directeur <Directeur<Secretaire>> dir2 = new Directeur<>();
//        dir2.assistant.assistant.nom = "Nouvelle Vanessa";
//        dir2.nom = "Jean Jean le retour";

        try {
            dir.setAssistant(Secretaire.class, "Vanessa");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        test();
    }
    /*
    créer une fonction qui transforme un objet dans un autre
     */
    public static <R, T> R modifyObject (T t, Function <T, R >function) {
        return function.apply(t);
    }
    public static <T,R> R modifyObjectToR (T objet, Function <T,R> function) {
        return function.apply(objet);
    }

    public static void test() {
        String i = "5";
        double j = modifyObjectToR(i, f -> Double.parseDouble(i) );
        System.out.println(j);
        Person p = null;
        PersonneSimplifiée ps = modifyObjectToR(p, person -> new PersonneSimplifiée(person.getNom(), (int) person.convertDateEngagement()));
    }
}
