package be.digitalcity.lambda;

public class PersonneSimplifiée {
    String nomComplet;
    int totalSec; //depuis la date d'engagement

    public PersonneSimplifiée(String nomComplet, int totalSec) {
        this.nomComplet = nomComplet;
        this.totalSec = totalSec;
    }

    public PersonneSimplifiée(String nom, String prenom, long totalSec) {
        this.nomComplet = nom+prenom;
        this.totalSec = (int) totalSec;
    }

    @Override
    public String toString() {
        return "PersonneSimplifiée{" +
                "nomComplet='" + nomComplet + '\'' +
                ", totalSec=" + totalSec +
                '}';
    }
}
