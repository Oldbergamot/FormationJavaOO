package be.digitalcity.revision;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reservation {


    private int nbPeople;
    private String lastName;
    private String firtName;
    private LocalDateTime arrival;
    private LocalDateTime departure;
    private List<Option> options;
    private double price;

    private Reservation( int nbPeople, String lastName, String firtName, LocalDateTime arrival, LocalDateTime departure, List<Option> options, double price) {
        this.nbPeople = nbPeople;
        this.lastName = lastName;
        this.firtName = firtName;
        this.arrival = arrival;
        this.departure = departure;
        this.options = options;
        this.price = price;
    }

    public static void createReservation() {
        Scanner sc = new Scanner(System.in);
        String lastName = "";
        String firstName = "";
        LocalDateTime arrival;
        LocalDateTime departure;
        roomType room;
        byte nbPeople;
        List<Option> options = new ArrayList<>();
        double price;

        System.out.println("Nom du client :");
        lastName = sc.nextLine();
        System.out.println("Prénom du client :");
        firstName = sc.nextLine();
        nbPeople = getNbPeople();

        arrival = getArrivalDate();
        departure = getDepartureDate(arrival);
        options = getOptions();
        room = getRoomType();
        price = getStayPrice(arrival, departure, options, room, nbPeople);

        Reservation reservation = new Reservation((int)nbPeople, lastName, firstName, arrival,departure,options, price);


    }

    private static byte getNbPeople() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nombre de client : ");
        //check si nb est ok et si chambre est dispo
        return sc.nextByte();
    }

    private static double getStayPrice(LocalDateTime arrival, LocalDateTime departure, List<Option> options, roomType room, byte nbPeople) {
        int duration = arrival.compareTo(departure);
        double result = 0;

        //result without options
        switch(nbPeople){
            case 1 : result = room.getPrice()*duration;
                break;
            case 2 : result = (room.getPrice()+ room.getPrice()*.85)*duration;
                break;
            case 3 : result = (room.getPrice()+ room.getPrice()*.85+ room.getPrice()*.7)*duration;
                break;
            case 4 : result = (room.getPrice()+ room.getPrice()*.85+ room.getPrice()*.7+ room.getPrice()*.55)*duration;
                break;
        }

        //add options
        for(Option o : options) {
            result += o.getPrice();
        }
        return result;
    }

    private static roomType getRoomType() {
        Scanner sc = new Scanner(System.in);
        List <roomType> list = new ArrayList<>();
        list = getRoomAvailable();
        System.out.println("Choix de chambre : (Entrer le numéro");
        byte index = 1;
        for (roomType r: list) {
            System.out.print(index);
            System.out.println(r);
            index++;
        }
        byte i = sc.nextByte();
        roomType result = list.get(i);

        return result;
    }

    /*
    temp
     */
    private static List<roomType> getRoomAvailable() {
        List <roomType> list = new ArrayList<>();
        list.add(roomType.CHAMBREUNIQUE);
        list.add(roomType.CHAMBREDUO);
        list.add(roomType.CHAMBREQUAD);
        list.add(roomType.SUITENUPTIALES);

        return list;
    }

    private static List<Option> getOptions() {
        Scanner sc = new Scanner(System.in);
        List<Option> options = new ArrayList<>();

        System.out.println("Choix d'options : (entrer un numéro à la fois, valider en appuyant sur s");
        while(!sc.nextLine().equals("s")){
            //display options
            for(int i = 1 ; i <= GestionReservation.options.size(); i++) {
                System.out.print(i+ " ");
                System.out.println((GestionReservation.options.get(i-1)));
            }
            int i = sc.nextInt();

            //check si l'option est déjà présente
            if(isPresent(options,i)) continue;

            //add l'option
            options.add(GestionReservation.options.get(i-1));
            System.out.println("Option ajoutée");
        }
        return options;
    }

    private static LocalDateTime getDepartureDate(LocalDateTime arrival) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Durée du séjour : (en jour)");
        int duration = sc.nextInt(); //verif / appel d'autre méthode
        return arrival.plusDays((int) duration).withHour(11).withMinute(0); //le départ se fait toujours à 11h
    }

    public static boolean isPresent(List<Option> list, int index) {
        --index;
        for (Option o : list) {
            if(GestionReservation.options.get(index).equals(o)) return true;
        }
        return false;
    }

    public static LocalDateTime getArrivalDate() {
        Scanner sc = new Scanner(System.in);
        LocalDate date;
        LocalTime time;

        System.out.println("Date d'arrivée : (format DD/MM/YY");
        String [] temp = sc.nextLine().split("/"); //ajout de vérification
        date = LocalDate.of(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]), Integer.parseInt(temp[0]));
        System.out.println("Heure d'arrivée : (Format HH:MM");
        temp = sc.nextLine().split(":");
        time = LocalTime.of(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));

        return LocalDateTime.of(date, time);
    }


    public void displayReservation() {
        System.out.println("Reservation{" +
                " lastName='" + lastName + '\'' +
                ", firtName='" + firtName + '\'' +
                ", arrival=" + arrival +
                ", departure=" + departure +
                ", nbPeople=" + nbPeople +
                ", options=" + options +
                ", price=" + price +
                '}');
    }
}
