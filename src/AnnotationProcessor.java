import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) {
        Class<?> clazz = OldClass.class;

        // Проверка класса
        if (clazz.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx annotation = clazz.getAnnotation(DeprecatedEx.class);
            System.out.println("Внимание: класс '" + clazz.getSimpleName() +
                    "' устарел. Альтернатива: '" + annotation.message() + "'");
        }

        // Проверка методов
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx annotation = method.getAnnotation(DeprecatedEx.class);
                System.out.println("Внимание: метод '" + method.getName() +
                        "' устарел. Альтернатива: '" + annotation.message() + "'");
            }
        }
    }
}
