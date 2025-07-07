import java.util.function.Supplier;
import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(11);

        System.out.println("Случайное число: " + randomSupplier.get());
    }
}