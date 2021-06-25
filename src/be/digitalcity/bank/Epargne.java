package be.digitalcity.bank;

import java.time.LocalDate;

public class Epargne extends Compte{
    private LocalDate dateDernierRetrait;

    public Epargne(String numero, double solde, Person titulaire) {
        super(numero, solde, titulaire);
    }

    public void retrait(double montant){
        super.retrait(montant);
        this.dateDernierRetrait = LocalDate.now();
    }

    public void displayCount(){
        super.displayCount();
        System.out.println("Date dernier retrait : "+dateDernierRetrait);
    }
}
