import java.util.function.Predicate;
public class StringCheck {
    public static void main(String[] args) {
        Predicate<String> startsWithJorN = s -> s.startsWith("J") || s.startsWith("N");
        Predicate<String> endsWithA = s -> s.endsWith("A");

        Predicate<String> check = startsWithJorN.and(endsWithA);

        System.out.println(check.test("JavaA")); // true
        System.out.println(check.test("NodeA")); // true
        System.out.println(check.test("Python")); // false
    }
}