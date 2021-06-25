package be.digitalcity.bank;

public class Courant extends Compte{
    private double solde;
    private double ligneDeCredit;

    public Courant(String numero, double solde, double ligneDeCredit, Person titulaire) {
        super(numero,solde,titulaire);
        if(ligneDeCredit<=0) return; //idéalement il faudrait une meilleure gestion ...
        this.ligneDeCredit = ligneDeCredit;
    }

    public void retrait(double montant){
        if(this.solde - montant >= -this.ligneDeCredit) this.solde -= montant;
    }

    public void displayCount() {
        super.displayCount();
        System.out.println("Ligne de crédit : "+ligneDeCredit);
    }
}
