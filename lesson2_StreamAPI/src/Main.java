import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Car> carList = List.of(
                new Car("A1", "Audi A4", "Audi", 2023, 20000, 35000),
                new Car("B2", "BMW X5", "BMW", 2021, 60000, 50000),
                new Car("T1", "Tesla S", "Tesla", 2024, 10000, 70000),
                new Car("T2", "Tesla 3", "Tesla", 2020, 40000, 45000),
                new Car("M1", "Mazda 3", "Mazda", 2018, 75000, 20000),
                new Car("TS1", "Tayota Supra", "Tayota", 1988, 30000, 100000)

        );

        System.out.println("Машины с пробегом < 50_000 км:");
        carList.stream()
                .filter(car -> car.mileage < 50_000)
                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
                .limit(3)
                .forEach(System.out::println);

        double avgMileage = carList.stream()
                .mapToInt(car -> car.mileage)
                .average()
                .orElse(0);
        System.out.println("Средний пробег: " + avgMileage);

        Map<String, List<Car>> grouped = carList.stream()
                .collect(Collectors.groupingBy(car -> car.manufacturer));
        System.out.println("Группировка по производителю:");
        grouped.forEach((maker, cars) -> System.out.println(maker + ": " + cars.size()));
    }
}