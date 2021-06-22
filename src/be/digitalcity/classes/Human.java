package be.digitalcity.classes;

import java.time.LocalDate;

//  Intérêt des getters et setters : Ca permet de pouvoir faire toutes les opérations que l'on veut au sein de la méthode,
//  vérification, modification sur l'input, etc En plus de décider si l'accès à la lecture ou en écriture d'un attribut est
//  permis
//  Racourcis : alt  + insert (permet d'insérer le constructeur/getters/setters)
//              ctrl + insert (sélectionne la ligne)
//              MAJ  + insert (duplique la ligne)

public class Human {

    private String name;
    private String lastName;
    private String nationality;
    private LocalDate birthDate;

    private static int COUNT = 0;

    public Human (String name, String lastName , LocalDate birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        COUNT++;
    }

    public Human(String name, String lastName , String nationality, LocalDate birthDate){
        this(name,lastName,birthDate);
        this.nationality = nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate date) {
        this.birthDate = date;
    }

    public static int getCOUNT(){
        return COUNT;
    }

    public void displayPerson() {
        if(nationality == null) System.out.println("name : " + this.name +" , last name : "+this.lastName + " , birthday : "+this.birthDate);
        else System.out.println("name : " + this.name +" , last name : "+this.lastName + " , " +this.nationality+ " , birthday : "+this.birthDate);
    }
}
