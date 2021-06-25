package be.digitalcity.bank;

public class Compte {
    private final String numero;
    private double solde;
    private final Person titulaire;

    public Compte(String numero, double solde, Person titulaire) {
        this.numero = numero;
        this.solde = solde;
        this.titulaire = titulaire;
    }

    public void retrait(double montant){
        this.solde -= montant;
    }

    public void depot(double montant) {
        this.solde += montant;
    }

    public double getSolde() {
        return solde;
    }

    public void displayCount(){
        System.out.println("ID : "+numero+
                           "\nTitulaire : "+ titulaire.displayPerson() +
                           "\nSolde : "+solde );
    }

    public Person getTitulaire() {
        return this.titulaire;
    }
}
