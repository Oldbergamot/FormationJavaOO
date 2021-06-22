package be.digitalcity.bank;

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
        c2.displayCourant();

    }
}
