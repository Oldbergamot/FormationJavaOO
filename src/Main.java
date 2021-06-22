import be.digitalcity.classes.Dice;
import be.digitalcity.classes.Human;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Constructeur pour la classe Human");
        System.out.println("==================================");

        Human person = new Human("Arnaud", "Daune",LocalDate.of(1987,12,15));
        person.displayPerson();
        person.setName("plop");
        person.displayPerson();
        System.out.println("Number of humans created : "+Human.getCOUNT());
        System.out.println();

        System.out.println("Utilisation de la classe dice");
        System.out.println("==================================");

        for (int i = 0 ; i <10 ; i++) {
            System.out.print(Dice.throwDice(6));
            if(i != 9) System.out.print(" , ");
        }
        System.out.println();


    }
}
