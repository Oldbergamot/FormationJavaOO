package be.digitalcity.heroesVersusMonster;

import java.util.Random;

public class Orc extends Monster{
    Orc(String name, short x, short y) {
        super(name,x,y);
        this.force +=1;
    }

    private void generateLoot() {
        Random r = new Random();
        this.inventory.addGold(r.nextInt(6));
    }
}
