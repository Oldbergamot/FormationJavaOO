package be.digitalcity.lambda;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static int [] tab = {1,2,3,4,5,6,7,8,9};

    public static void main(String[] args) {
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
}
