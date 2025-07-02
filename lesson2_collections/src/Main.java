import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> models = new ArrayList<>(List.of(
                "Toyota Camry", "BMW X5", "Tesla Model S", "BMW X5", "Toyota Camry", "Toyota Supra"
        ));

        Set<String> uniqueModels = new TreeSet<>(Comparator.reverseOrder());
        for (String model : models) {
            if (model.contains("Tesla")) {
                model = "ELECTRO_CAR";
            }
            uniqueModels.add(model);
        }

        System.out.println("Отсортированные модели:");
        uniqueModels.forEach(System.out::println);
    }
}