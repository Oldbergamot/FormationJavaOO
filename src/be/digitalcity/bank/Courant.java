package be.digitalcity.bank;

public class Courant {
    private String numero;
    private double solde;
    private double ligneDeCredit;
    private Person titulaire;

    public Courant(String numero, double solde, double ligneDeCredit, Person titulaire) {
        if(ligneDeCredit<=0) return;
        this.numero = numero;
        this.solde = solde;
        this.ligneDeCredit = ligneDeCredit;
        this.titulaire = titulaire;
    }

    public void retrait(double montant){
        if(this.solde - montant >= -this.ligneDeCredit) this.solde -= montant;
    }

    public void depot(double montant){
        this.solde+= montant;
    }

    public double getSolde () {
        return this.solde;
    }

    public void displayCourant() {
        System.out.println("ID : "+this.numero);
        //reste des paramètres
    }

}
