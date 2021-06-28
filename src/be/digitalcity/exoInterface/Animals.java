package be.digitalcity.exoInterface;

public class Animals implements Walkable{

    int age;
    String type;

    public Animals(int age, String type) {
        this.age = age;
        this.type = type;
    }

    @Override
    public void walk() {
        System.out.println("walk");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }

    public void doStuff() {
        System.out.println("doStuff");
    }
}
