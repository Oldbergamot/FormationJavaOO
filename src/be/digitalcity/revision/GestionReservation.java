package be.digitalcity.revision;

import java.util.ArrayList;
import java.util.List;

public class GestionReservation {
    static String fileName = "C:\\Users\\local_user\\IdeaProjects\\FormationJavaOO\\src\\be\\digitalcity\\revision\\options_hotel.csv";
    static List<Option> options = DataLoader.getInstance().load(fileName);
    public static void main(String[] args) {
        List <Reservation> reservations = new ArrayList<>();


        for(Option o : options) {
            System.out.println(o);
        }
    }
}
