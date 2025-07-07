import java.util.function.Consumer;

class HeavyBox {
    int weight;

    public HeavyBox(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

public class HeavyBoxDemo {
    public static void main(String[] args) {
        Consumer<HeavyBox> ship = box -> System.out.println("Отгрузили ящик с весом " + box.getWeight());
        Consumer<HeavyBox> send = box -> System.out.println("Отправляем ящик с весом " + box.getWeight());

        Consumer<HeavyBox> process = ship.andThen(send);

        HeavyBox box = new HeavyBox(15);
        process.accept(box);
    }
}
