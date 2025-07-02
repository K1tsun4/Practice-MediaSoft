import java.util.*;

enum CarType {
    SEDAN, SUV, ELECTRIC, TRUCK, COUPE, HATCHBACK
}

public class Car {
    private String vin;
    private String model;
    private String manufacturer;
    private int year;
    private int mileage;
    private double price;
    private CarType type;

    public Car(String vin, String model, String manufacturer, int year, int mileage, double price, CarType type) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.type = type;
    }

    public String getVin() {
        return vin;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public double getPrice() {
        return price;
    }

    public CarType getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car)) return false;
        Car other = (Car) obj;
        return vin.equals(other.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %d | %d км | $%.2f | %s",
                vin, manufacturer, model, year, mileage, price, type);
    }
}
