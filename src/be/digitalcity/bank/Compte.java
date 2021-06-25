package be.digitalcity.bank;

import java.util.Objects;

public abstract class Compte {  //aucune raison d'instancier un compte, donc on met la méthode en abstract
    protected final String numero;
    protected double solde;
    protected final Person titulaire;

    public Compte(String numero, double solde, Person titulaire) {
        this.numero = numero;
        this.solde = solde;
        this.titulaire = titulaire;
    }

    public abstract void retrait(double montant);

    public void depot(double montant) {
        this.solde += montant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compte)) return false;
        Compte compte = (Compte) o;
        return Double.compare(compte.solde, solde) == 0 && Objects.equals(numero, compte.numero) && Objects.equals(titulaire, compte.titulaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, solde, titulaire);
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
