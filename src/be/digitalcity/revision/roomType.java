package be.digitalcity.revision;

public enum roomType {
    SUITENUPTIALES((byte)2,250),
    CHAMBREUNIQUE((byte)4,100),
    CHAMBREDUO((byte) 10,100),
    CHAMBREQUAD((byte) 4,100);

    private byte maxPeople;
    private double price;

    roomType(byte nbPeople, double price) {
        this.maxPeople = nbPeople;
        this.price = price;
    }

    public byte getMaxPeople() {
        return maxPeople;
    }

    public double getPrice() {
        return price;
    }
}
