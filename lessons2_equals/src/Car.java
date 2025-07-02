import java.util.*;

public class Car implements Comparable<Car>{
    String vin;
    String model;
    String manufacturer;
    int year;
    int mileage;
    double price;

    public Car(String vin, String model, String manufacturer, int year, int mileage, double price) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car)) return false;
        Car other = (Car) obj;
        return Objects.equals(this.vin, other.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.year, this.year); // от новых к старым
    }

    @Override
    public String toString() {
        return vin + " " + model + " " + year + " " + mileage + "км $" + price;
    }
}
