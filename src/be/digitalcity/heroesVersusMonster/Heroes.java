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

    @Override
    protected void attack(Character other) {
        other.removePV(Dice.thow(4)+generateModifier(this.force));
    }

    protected void attack(Character other){
        other.removePV(Dice.thow(4)+generateModifier(this.force));
        System.out.println(this.name +" attaque "+ other.name);
        this.displayPV();
        other.displayPV();
        if(other.PV<=0) {
            other.setAlive(false);
            this.getLoot(other);
        }

    }
}
