package be.digitalcity.singleton;

public class Main {
    public static void main(String[] args) {
//        Singleton s = new Singleton(); -> impossible car constructeur privé
        Singleton.getInstance();
        Singleton.getInstance().doSomething();
    }
}
