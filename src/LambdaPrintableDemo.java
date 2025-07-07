@FunctionalInterface
interface Printable {
    void print();
}

public class LambdaPrintableDemo {
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("Реализация ламбда выражения.");
        printable.print();
    }
}