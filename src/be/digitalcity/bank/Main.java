package be.digitalcity.bank;

//  Final sur une classe -> on empèche qu'elle soit héritée
//  Final sur une méthode -> empèche qu'elle soit overridée

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Simulation de compte courant \n=============================\n");

        Courant c1 = new Courant("12",15, 10, new Person("Daune", "Arnaud", LocalDate.of(1987,12,15)));
        System.out.println("Solde actuel : "+c1.getSolde() );
        c1.retrait(10D);
        System.out.println("Retrait de 10 € : " + c1.getSolde());
        c1.retrait(20D);
        System.out.println("Tentative de retrait de 20 € : " + c1.getSolde()+ "\n");

        System.out.println("Création d'un objet avec de mauvais paramètre \n"+ "==============================================\n");

        Courant c2 = new Courant("12",15, -10, new Person("Daune", "Arnaud", LocalDate.of(1987,12,15)));
        Courant c3 = new Courant("12",15, 15, new Person("Daune", "Arnaud", LocalDate.of(1987,12,15)));
        c3.displayCount();

        System.out.println();
        System.out.println("Création compte épargne \n========================\n");
        Epargne e1 = new Epargne("12",15,new Person("Daune", "Arnaud", LocalDate.of(1987,12,15)));
        e1.displayCount();

        System.out.println("\nRetrait de 10 €\n===============");
        e1.retrait(10);
        e1.displayCount();
        System.out.println("\nAjout de 15€\n=============");
        e1.depot(15);
        e1.displayCount();

        System.out.println("\nCréation d'une banque\n===============");
        Bank b1 = new Bank("Ma Banque");
        b1.addAccount("Compte 1", c3);


    }
}
