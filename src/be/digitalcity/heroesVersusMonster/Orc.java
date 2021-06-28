package be.digitalcity.heroesVersusMonster;

import java.util.Random;

public class Orc extends Monster{
    Orc(Position position){
        super(position);
    }

    private void generateLoot() {
        Random r = new Random();
        this.inventory.addGold(r.nextInt(6));
    }
}
