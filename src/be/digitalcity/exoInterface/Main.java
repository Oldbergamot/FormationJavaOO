package be.digitalcity.exoInterface;

public class Main {
    public static void main(String[] args) {
        Animals a1 = new Animals(15,"Plop");
        a1.doStuff();
        a1.eat();
        a1.walk();

        Walkable a2 = new Animals(16,"plip");
        //a2.doStuff(); ne peut pas faire doStuff car doStuff ne fait pas partie du contrat de walkable
        a2.eat();
        a2.walk();
        System.out.println("cast ");
        ((Animals)a2).doStuff(); //casting donc ok

        Human h1 = new Human("Plap", 25);
        h1.eat();
        h1.walk();
        h1.sePlaindre();
        h1.lundiMatin();
        h1.move(); //défini dans l'interface
    }
}
