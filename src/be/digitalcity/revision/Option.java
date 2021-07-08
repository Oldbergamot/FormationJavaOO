package be.digitalcity.revision;

import java.util.Objects;

public class Option {
    private String optionName;
    private double price;
    private Enum frequencie;
    private boolean perPerson;

    public Option(String optionName, double price, Enum frequencie, boolean perPerson) {
        this.optionName = optionName;
        this.price = price;
        this.frequencie = frequencie;
        this.perPerson = perPerson;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Enum getFrequencie() {
        return frequencie;
    }

    public boolean isPerPerson() {
        return perPerson;
    }

    public void setPerPerson(boolean perPerson) {
        this.perPerson = perPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Option)) return false;
        Option option = (Option) o;
        return price == option.price && perPerson == option.perPerson && Objects.equals(optionName, option.optionName) && Objects.equals(frequencie, option.frequencie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optionName, price, frequencie, perPerson);
    }

    @Override
    public String toString() {
        return "Option{" +
                "optionName='" + optionName + '\'' +
                ", price=" + price +
                ", frequencie='" + frequencie + '\'' +
                ", perPerson=" + perPerson +
                '}';
    }
}
