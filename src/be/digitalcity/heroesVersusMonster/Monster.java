package be.digitalcity.heroesVersusMonster;

public class Monster extends Character{

    protected short x;
    protected short y;

    Monster(String name,short x, short y) {
        super(name);
        this.x = x;
        this.y = y;
    }

}
