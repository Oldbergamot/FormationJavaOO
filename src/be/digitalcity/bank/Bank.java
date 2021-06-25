package be.digitalcity.bank;

import java.util.HashMap;

public class Bank {
    private final String name;
    private HashMap <String, Compte> allAccounts;

    public Bank(String name) {
        this.name = name;
        this.allAccounts = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void addAccount(String name, Compte compte){
        this.allAccounts.put(name,compte);
    }

    public void removeAccount(String name){
        this.allAccounts.remove(name);
    }

    public String totalHoldingsPerson(Person person) {
        double totalHoldings = 0;
        boolean personIsKnown = false;
        for (Compte account : allAccounts.values()){
            if(account.getTitulaire().equals(person)){
                personIsKnown = true;
                if(account.getSolde()>0) totalHoldings += account.getSolde();
            }
        }
        if(!personIsKnown) return "Personne inconnue";
        return "Le titulaire possède : "+totalHoldings+" €";
    }

}
