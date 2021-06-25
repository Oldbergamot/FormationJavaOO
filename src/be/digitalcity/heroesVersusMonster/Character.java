package be.digitalcity.heroesVersusMonster;

public abstract class Character {

    private final String name;
    protected int force;
    protected int sta;
    protected int totalPV;
    protected int PV;
    protected Inventory inventory;
    protected boolean isAlive;

    Character(String name) {
        this.name = name;
        this.sta = generateStat(6);
        this.force = generateStat(6);
        this.PV =  generatePV();
        this.totalPV = PV;
        this.inventory = new Inventory();
        this.isAlive = true;
        }

    /**
     * Generate an array of int. Fill the array with the value of a dice
     * return the sum of the 3 biggest throw
     */
    protected int generateStat(int size) {
        int []  array = new int[size];
        int min = 6;
        int sum = 0;

        //filling the array
        for(int i = 0 ; i < array.length ; i++) {
            array[i] = Dice.thow(6);
            if (array[i]<min) min = array[i];
        }
        //compute sum
        for(int i = 0 ; i < array.length ; i++) {
            if (array[i] == min) continue;
            sum += array[i];
        }
        return sum;
    }
    private int generatePV() {
        return this.sta + generateModifier(this.sta);
    }

    private int generateModifier(int i) {
        if(i<5) return -1;
        else if(i<10) return 0;
        else if(i<15) return 1;
        return 2;
    }

    protected void attack(Character other){
        other.removePV(Dice.thow(4)+generateModifier(this.force));
        if(other.PV<=0) {
            setAlive(false);
            this.getLoot(other);
        }
    }

    protected boolean getAlive() {
        return this.isAlive;
    }

    protected void setAlive (boolean b) {
        this.isAlive = b;
    }

    protected void removePV(int PV) {
        this.PV -= PV;
    }

    public void displayPV() {
        System.out.println(this.PV);
    }

    public void getLoot(Character other) {
        this.inventory.addGold(other.getInventory().getGold());
        this.inventory.addLeather(other.getInventory().getLeather());
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void restoreHealth() {
        this.PV = this.totalPV;
    }

    public String toString() {
        return this.name + " a " +this.PV+ " de point de vie et "+this.sta + " en endurance et "+this.force+" en force"+
                " Inventaire : "+this.inventory.getGold()+ " or "+ this.getInventory().getLeather()+" leather";
    }

}
