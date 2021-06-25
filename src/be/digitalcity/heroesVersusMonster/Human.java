package be.digitalcity.heroesVersusMonster;

public class Human extends Heroes{
    private int PV;

    Human (String name) {
        super(name);
        this.force += 1;
        this.sta += 1;
    }
}
