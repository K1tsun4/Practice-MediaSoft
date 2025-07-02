import java.util.*;
import java.util.stream.Collectors;

public class CarCenter {
    private List<Car> cars = new ArrayList<>();

    // 1. Добавить машину (без дубликатов VIN)
    public boolean addCar(Car car) {
        if (cars.stream().anyMatch(c -> c.getVin().equals(car.getVin()))) {
            return false; // дубликат VIN
        }
        cars.add(car);
        return true;
    }

    // 2. Найти все машины производителя
    public List<Car> findByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(car -> car.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    // 3. Средняя цена машин определённого типа
    public double averagePriceByType(CarType type) {
        return cars.stream()
                .filter(car -> car.getType() == type)
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
    }

    // 4. Список машин, отсортированных по году выпуска (от новых к старым)
    public List<Car> getCarsSortedByYear() {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getYear).reversed())
                .collect(Collectors.toList());
    }

    // Доп. Статистика

    // Количество машин каждого типа
    public Map<CarType, Long> countByType() {
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getType, Collectors.counting()));
    }

    // Самая старая машина
    public Optional<Car> getOldestCar() {
        return cars.stream()
                .min(Comparator.comparingInt(Car::getYear));
    }

    // Самая новая машина
    public Optional<Car> getNewestCar() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getYear));
    }
}
