package be.digitalcity.lambda;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static int [] tab = {1,2,3,4,5,6,7,8,9};
    private static List<Person> persons = new ArrayList<>();
    public static void main(String[] args) {

        persons.add(new Person("Ceuleers", "Grégory", 41, LocalDate.of(2015,12,5)));
        persons.add(new Person("Ly", "Khun", 39, LocalDate.of(2013,3,15)));
        persons.add(new Person("Ovyn", "Flavian", 30, LocalDate.of(2014,3,10)));
        persons.add(new Person("Geerts", "Mélanie", 28, LocalDate.of(2016,11,17)));
        persons.add(new Person("Coppin", "Julien", 26, LocalDate.of(2013,10,25)));
        persons.add(new Person("Ly", "Pyu", 40, LocalDate.of(2014,3,5)));

        //1ère approche
        System.out.println("1ère approche \n=============");
        chercherPersonneAvecNom(persons, "Ly");

        //2ème approche
        System.out.println("2ème approche\n=============");
        chercherPersonneViaClasse(persons, new CritèreRecherche());

        //3ème approche
        System.out.println("3ème approche\n=============");
        rechercherPersonneViaClasseAnonyme(persons, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getAge()<40;
            }
        });

        //4ème approche
        System.out.println("4ème approche\n=============");
        //rechercherPersonneViaClasseAnonyme(persons, person -> person.getNom().endsWith("n") && person.getAge() < 40);


        //Exercice 1

        System.out.println("Exercice 1 \n" +
                "=============="); //si agé de moins de 40, on sout sous le format donné et le nom
        filterThenDisplay(persons, person -> person.getAge()<40,
                person -> System.out.println(person.getNom()+
                        " fait partie de la tranche d'age des moins de 40 ans"));

        //variation sur l'exo 1

        System.out.println("" +
                "\n" +
                "Variation une sur l'exercice 1" +
                "\n-------------------------------");
        filterThenDisplay(persons , person -> person.getPrenom().equalsIgnoreCase("flavian"),
                System.out::println);
        System.out.println("" +
                "\n" +
                "Variation deux sur l'exercice 1" +
                "\n---------------------------------");
        filterThenDisplay(persons, person -> person.getDateEngagement().getYear()>=2015,
                person -> System.out.println(person.getNom()+ " a été embauchée durant ou après l'année 2015"));

        System.out.println("" +
                "\n" +
                "Exercice 2" +
                "\n==================\n");
        boiteACalcul(9,5, (a,b) -> System.out.println(a+b));

        System.out.println("" +
                "\n" +
                "Variation sur exercice 2 " +
                "\n---------------------\n");
        boiteACalculV2(1,5, (a,b) -> System.out.println(a+b));

        System.out.println(modifyList(persons));

    }



    public void premiereApprocheLambda() {
        afficher(lambda1 -> {
            for (int i = 0; i < tab.length; i++) {
                System.out.println(tab[i]);
            }
            /*
            tout ce qui est à la gauche de la , est les paramètres d'entrée, si plusieurs para => (para1, para2)
            this n'est pas implémenté
            si une seule ligne return est implicice ex : calculer(tab -> sout);
             */

            //test récurcivité

            afficher( lambda2 -> {
                for (int i: tab) {
                    System.out.println(i);
                }
            });
        });

        afficher((tab -> { //on peut y écrire ce qu'on veut même avec le même nom
            int sum = 0;
            for (int i = 0; i < tab.length; i++) {
                sum += tab[i];
            }
            System.out.println("Mean : "+sum/ tab.length);
        }));

        String msg = "Bonjour";
        testConsumer(data -> System.out.println(data), msg);

        testConsumer(data1 -> {
            data1 += " les amis";
            System.out.println(data1);
        }, msg );
    }
    public static void afficher(Calculator fct){  //on passe ici une variable du type de notre interface
        System.out.println("Début lambda");
        fct.effectuerOperation(tab);
        System.out.println("Fin lambda \n");
    }

    public  static void testConsumer(Consumer<String> consumer, String data) {
        if (data != null) {
            consumer.accept(data);
        }
        else {
            throw new IllegalArgumentException("Data is null");
        }
    }

    //test stream

    public static void testStream() {
        Arrays.stream(tab).forEach(i -> System.out.println(i));
    }

    public static void test() {
        int sumOfSquare = Arrays.stream(tab).filter(i -> i>5)   //si i est plus grand que 5 alors :
                .map(i -> i * i)            //i = i * i
                .sum();                     //

        System.out.println(sumOfSquare);
    }

    public static void example1() {
        List<Integer>ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(6);
        ints.add(7);
        ints.add(8);
        ints.add(9);

        //classiquement
        System.out.println("Méthode classique");
        for (int i: ints) {
            System.out.print(i+ ". ");
        }
        System.out.println();

        //fonctionnel
        System.out.println("Fonctionnel");
        ints.forEach(integer -> System.out.print(integer+ ". "));
        System.out.println();

        /*
        si la signature suggère un return, le return est optionnel tant qu'il n'y a qu'une ligne dans la lambda
        s'il y a plusieurs lignes il faut le spécifier
         */

        Consumer <Integer> fct = x -> System.out.println(x*x);
        Consumer <Integer> fct2 = x -> System.out.println(x*x*x);
        fct.accept(5);
        fct2.accept(5);
    }

    //1ère approche  : méthode cherchant une liste avec un critère
    public static void chercherPersonneAvecNom(List <Person> list , String nom){
        for (Person p: list) {
            if (p.getNom().equalsIgnoreCase(nom)) System.out.println(p);
        }
    }

    //2ème approche : classe qui va stocker les différentes méthodes de recherche
    public static void chercherPersonneViaClasse(List<Person> list , CritèreRecherche recherche) {
        for (Person p : list) {
            if(recherche.test1(p, "Khun")){
                System.out.println(p);
            }
        }
    }
    //3ème approche : via classe anonyme
    public  static  void rechercherPersonneViaClasseAnonyme(List <Person> persons, CheckPerson recherche) {
        for(Person p : persons) {
            if(recherche.test(p)){
                System.out.println(p);
            }
        }
    }

    //5ème approche : via les prédicates
    public  static  void rechercherPersonneViaClasseAnonyme(List <Person> persons, Predicate<Person> recherche) {
        for(Person p : persons) {
            if(recherche.test(p)){
                System.out.println(p);
            }
        }
    }

    /*
    Exercices :

    Ecrire une méthode qui permet de filtrer un résultat et de passer ensuite une action
    d'affichage au choix
     */

    public static void filterThenDisplay(List<Person> persons, Predicate <Person> predicate, Consumer <Person> consumer){
        for(Person p : persons){
            if(predicate.test(p)){
                consumer.accept(p);
            }
        } //ou
//        persons.forEach(item -> {
//            if (predicate.test(item)) {
//                consumer.accept(item);
//            }
//        });
    }

    /*
     * Ecrire une méthode qui servira de boîte à calcul sur deux variables int
     * Cette méthode prendra en paramètre les 2 nombres, la lambda pour le calcul
     * et affichera le résutat
     */
    public static void boiteACalcul(int a, int b, BiConsumer<Integer, Integer> consumer){
        consumer.accept(a,b);
    }

    public static void boiteACalculV2(int a , int b, Calculable operation){
        operation.execute(a,b);
    }

    /*
    retourne la moyenne des ages de la liste placée en paramètre
     */
    public static void getAgeMean(List <Person> list){
        if(list == null || list.isEmpty()) return;
        System.out.println(
        list.stream()
//                .mapToInt(Person::getAge)
                .mapToInt(person -> person.getAge())
                .average()
        .orElse(-1D));
     }

     /*
     trier du moins agé au plus agé, 3 façons
      */

    public static void sortList(List <Person> list) {
        try {
            list.sort((person, other) -> person.getAge()- other.getAge());

            list.sort(Comparator.comparingInt(Person::getAge));

            list.stream()                       //nb : le stream créée une copie locale et ne sort pas la liste passée en paramètre
                    .mapToInt(Person::getAge)
                    .sorted()
                    .forEach(System.out::println);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<PersonneSimplifiée> modifyList(List <Person> list) {
        ArrayList<PersonneSimplifiée> result = new ArrayList<>();
        list
                .forEach(person -> {
                    String name = person.getNom()+person.getPrenom();
                    long totalSec = person.convertDateEngagement();
                    result.add(new PersonneSimplifiée(name, (int) totalSec));
                });
        return result;
    }

    public static void transformData() {
        List<PersonneSimplifiée> result = persons
                .stream()
                .map(x -> new PersonneSimplifiée(x.getNom(),x.getPrenom(), x.convertDateEngagement()))
                .collect(Collectors.toList());
    }
}
