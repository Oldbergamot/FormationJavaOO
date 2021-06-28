package be.digitalcity.heroesVersusMonster;

public class Heroes extends Character{

    String name;

    Heroes(Position position, String name) {
        super(position);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
