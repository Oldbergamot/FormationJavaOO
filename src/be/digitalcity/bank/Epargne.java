package be.digitalcity.bank;

import java.time.LocalDate;

public class Epargne extends Compte{
    private LocalDate dateDernierRetrait;

    public Epargne(String numero, double solde, Person titulaire) {
        super(numero, solde, titulaire);
    }

    @Override
    public void retrait(double montant){
        if(this.getSolde() - montant >= 0) this.solde -= montant;
        this.dateDernierRetrait = LocalDate.now();
    }

    public void displayCount(){
        super.displayCount();
        System.out.println("Date dernier retrait : "+dateDernierRetrait);
    }
}
