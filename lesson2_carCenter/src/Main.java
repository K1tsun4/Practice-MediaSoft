import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CarCenter dealership = new CarCenter();
    public static void main(String[] args) {

        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = readInt("Выберите пункт меню: ");

            switch (choice) {
                case 1 -> addCarMenu();
                case 2 -> findByManufacturerMenu();
                case 3 -> averagePriceByTypeMenu();
                case 4 -> listCarsSortedByYear();
                case 5 -> printStatistics();
                case 0 -> {
                    System.out.println("Выход из программы.");
                    exit = true;
                }
                default -> System.out.println("Неверный выбор, попробуйте снова.");
            }
            System.out.println();
        }
    }
        private static void printMenu() {
            System.out.println("=== Меню Автоцентра ===");
            System.out.println("1. Добавить машину");
            System.out.println("2. Найти машины производителя");
            System.out.println("3. Средняя цена машин по типу");
            System.out.println("4. Вывести машины, отсортированные по году (новые -> старые)");
            System.out.println("5. Статистика");
            System.out.println("0. Выход");
        }

        private static void addCarMenu() {
            System.out.println("--- Добавление машины ---");
            String vin = readString("VIN: ");
            String model = readString("Модель: ");
            String manufacturer = readString("Производитель: ");
            int year = readInt("Год выпуска: ");
            int mileage = readInt("Пробег (км): ");
            double price = readDouble("Цена: ");
            CarType type = readCarType();

            Car car = new Car(vin, model, manufacturer, year, mileage, price, type);
            boolean added = dealership.addCar(car);
            if (added) {
                System.out.println("Машина успешно добавлена.");
            } else {
                System.out.println("Ошибка: машина с таким VIN уже существует.");
            }
        }

        private static void findByManufacturerMenu() {
            System.out.println("--- Поиск машин по производителю ---");
            String manufacturer = readString("Введите производителя: ");
            List<Car> cars = dealership.findByManufacturer(manufacturer);
            if (cars.isEmpty()) {
                System.out.println("Машины данного производителя не найдены.");
            } else {
                cars.forEach(System.out::println);
            }
        }

        private static void averagePriceByTypeMenu() {
            System.out.println("--- Средняя цена по типу машины ---");
            CarType type = readCarType();
            double avgPrice = dealership.averagePriceByType(type);
            if (avgPrice == 0) {
                System.out.println("Машины данного типа не найдены.");
            } else {
                System.out.printf("Средняя цена машин типа %s: $%.2f%n", type, avgPrice);
            }
        }

        private static void listCarsSortedByYear() {
            System.out.println("--- Машины, отсортированные по году выпуска (новые -> старые) ---");
            List<Car> sortedCars = dealership.getCarsSortedByYear();
            if (sortedCars.isEmpty()) {
                System.out.println("В автоцентре нет машин.");
            } else {
                sortedCars.forEach(System.out::println);
            }
        }

        private static void printStatistics() {
            System.out.println("--- Статистика автоцентра ---");
            Map<CarType, Long> countByType = dealership.countByType();
            System.out.println("Количество машин по типам:");
            countByType.forEach((type, count) -> System.out.printf("%s: %d%n", type, count));

            Optional<Car> oldest = dealership.getOldestCar();
            Optional<Car> newest = dealership.getNewestCar();

            System.out.println("Самая старая машина:");
            oldest.ifPresentOrElse(
                    System.out::println,
                    () -> System.out.println("Нет машин в наличии."));

            System.out.println("Самая новая машина:");
            newest.ifPresentOrElse(
                    System.out::println,
                    () -> System.out.println("Нет машин в наличии."));
        }

        // --- Вспомогательные методы для чтения из консоли ---

        private static String readString(String prompt) {
            System.out.print(prompt);
            return scanner.nextLine().trim();
        }

        private static int readInt(String prompt) {
            while (true) {
                try {
                    System.out.print(prompt);
                    return Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите целое число.");
                }
            }
        }

        private static double readDouble(String prompt) {
            while (true) {
                try {
                    System.out.print(prompt);
                    return Double.parseDouble(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите число.");
                }
            }
        }

        private static CarType readCarType() {
            System.out.println("Выберите тип машины:");
            for (CarType type : CarType.values()) {
                System.out.println(type.ordinal() + 1 + ". " + type);
            }
            while (true) {
                int choice = readInt("Ваш выбор: ");
                if (choice >= 1 && choice <= CarType.values().length) {
                    return CarType.values()[choice - 1];
                }
                System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
}
