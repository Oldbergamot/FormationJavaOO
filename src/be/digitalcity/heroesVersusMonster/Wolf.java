package be.digitalcity.heroesVersusMonster;

import java.util.Random;

public class Wolf extends Monster{
    Wolf(String name, short x,short y) {
        super(name, x, y);
        generateLoot();
    }

    private void generateLoot() {
        Random r = new Random();
        this.inventory.addLeather(r.nextInt(6));
    }
}
