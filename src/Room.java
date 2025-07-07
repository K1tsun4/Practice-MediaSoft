public abstract class Room {
    protected int roomNumber;
    protected int maxPeople;
    protected int pricePerNight;
    protected boolean isReserved;

    public Room(int roomNumber, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.maxPeople = (int) (Math.random() * 4 + 1); // случайно от 1 до 4
        this.pricePerNight = pricePerNight;
        this.isReserved = false;
    }

    // Геттеры
    public int getRoomNumber() { return roomNumber; }
    public int getMaxPeople() { return maxPeople; }
    public int getPricePerNight() { return pricePerNight; }
    public boolean isReserved() { return isReserved; }

    // Сеттеры
    public void setReserved(boolean reserved) { isReserved = reserved; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " #" + roomNumber +
                ", Цена: " + pricePerNight + ", Макс: " + maxPeople +
                ", Забронирована: " + isReserved;
    }
}