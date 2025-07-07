import java.util.function.Function;

public class NumberDescription {
    public static void main(String[] args) {
        Function<Integer, String> describe = n -> {
            if (n > 0) return (n + " - положительное число");
            else if (n < 0) return (n + " - отрицательное число");
            else return (n + " - Ноль");
        };

        System.out.println(describe.apply(10)); // Положительное число
        System.out.println(describe.apply(-5)); // Отрицательное число
        System.out.println(describe.apply(0));  // Ноль
    }
}