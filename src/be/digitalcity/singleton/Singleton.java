package be.digitalcity.singleton;

/*
Singleton is a creational design pattern, which ensures that only one object of its kind exists and provides a single point of access to it for any other code.

Ressources :

https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
https://refactoring.guru/design-patterns/java

 */

public class Singleton {
    private static Singleton instance;
    String name;

    private Singleton() {
        this.name = "Singleton";
    }

    public static Singleton getInstance() {
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("call the Singleton");
    }
}
