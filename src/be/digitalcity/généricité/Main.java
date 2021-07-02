package be.digitalcity.généricité;

import java.lang.reflect.InvocationTargetException;

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

    }
}
