import java.util.Arrays;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] years = new int[50];
        for (int i = 0; i < years.length; i++) {
            years[i] = rand.nextInt(2026 - 2000) + 2000;
        }

        System.out.println("Машины после 2015 года:");
        Arrays.stream(years)
                .filter(year -> year > 2015)
                .forEach(System.out::println);

        double avgAge = Arrays.stream(years)
                .map(year -> 2025 - year)
                .average()
                .orElse(0);
        System.out.println("Средний возраст авто: " + avgAge + " лет");
    }
}