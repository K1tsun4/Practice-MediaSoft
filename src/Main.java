//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RoomService<Room> service = new RoomServiceImpl<>();

        Room r1 = new EconomyRoom(101, 50);
        Room r2 = new StandardRoom(202, 100);
        Room r3 = new LuxRoom(303, 200);
        Room r4 = new UltraLuxRoom(404, 400);

        Room[] rooms = {r1, r2, r3, r4};

        for (Room room : rooms) {
            service.clean(room);
            try {
                service.reserve(room);
                service.reserve(room); // Вызовет исключение
            } catch (RoomAlreadyReservedException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
            service.free(room);
        }
    }
}