import java.util.*;
public class Main {
    public static void main(String[] args) {
        Set<Car> carSet = new HashSet<>();
        carSet.add(new Car("111", "BMW X5", "BMW", 2020, 30000, 90000));
        carSet.add(new Car("222", "Tesla Model 3", "Tesla", 2022, 10000, 40000));
        carSet.add(new Car("111", "BMW X5", "BMW", 2021, 30000, 90000)); // дубликат
        carSet.add(new Car("333", "Toyota Supra", "Toyota", 1988, 30000, 50000));

        System.out.println("Уникальные машины:");
        carSet.forEach(System.out::println);

        // Сортировка
        List<Car> sortedCars = new ArrayList<>(carSet);
        Collections.sort(sortedCars);

        System.out.println("\nМашины от новых к старым:");
        sortedCars.forEach(System.out::println);
    }
}