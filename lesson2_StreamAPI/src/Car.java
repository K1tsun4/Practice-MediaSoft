public class Car {
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

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return vin + " | " + model + " | " + manufacturer + " | " + year + " | " + mileage + "км | $" + price;
    }
}

