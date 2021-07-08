package be.digitalcity.files;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    private String marque;
    private int cylinder;

    public Car(String marque, int cylinder) {
        this.marque = marque;
        this.cylinder = cylinder;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getCylinder() {
        return cylinder;
    }

    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return cylinder == car.cylinder && Objects.equals(marque, car.marque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marque, cylinder);
    }

    @Override
    public String toString() {
        return "Car{" +
                "marque='" + marque + '\'' +
                ", cylinder=" + cylinder +
                '}';
    }
}
