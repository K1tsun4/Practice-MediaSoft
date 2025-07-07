import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> notNull = str -> str != null;
        Predicate<String> notEmpty = str -> !str.isEmpty();

        Predicate<String> validString = notNull.and(notEmpty);

        String test1 = "Hello";
        String test2 = "";
        String test3 = null;

        System.out.println("Test1: " + validString.test(test1)); // true
        System.out.println("Test2: " + validString.test(test2)); // false
        System.out.println("Test3: " + validString.test(test3)); // false
    }
}