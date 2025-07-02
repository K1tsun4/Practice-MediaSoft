import java.time.LocalDateTime;
import java.util.Random;

public class BankAccount {
    String ownerName;
    int balance;
    LocalDateTime openingDate;
    boolean accountLock;
    String number;

    BankAccount(String ownerName){
        this.ownerName = ownerName;
        this.balance = 0;
        this.openingDate = LocalDateTime.now();
        this.accountLock = false;
        this.number = generateAccountNumber();
    }

    // Генерация 8-значного номера счёта
    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10)); // от 0 до 9
        }
        return sb.toString();
    }

    // Пополнение счета
    public boolean deposit(int amount) {
        if (accountLock || amount <= 0) return false;
        balance += amount;
        return true;
    }

    // Снятие денег
    public boolean withdraw(int amount) {
        if (accountLock || amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }

    // Перевод на другой счет
    public boolean transfer(BankAccount otherAccount, int amount) {
        if (accountLock || otherAccount == null || amount <= 0) return false;
        if (this.withdraw(amount)) {
            return otherAccount.deposit(amount);
        }
        return false;
    }

    // Геттеры
    public String getOwnerName() {
        return ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public boolean isBlocked() {
        return accountLock;
    }

    // Сеттер для блокировки счета
    public void setBlocked(boolean blocked) {
        accountLock = blocked;
    }

    // Метод для отображения информации о счете
    @Override
    public String toString() {
        return "BankAccount{" +
                "ownerName='" + ownerName + '\'' +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                ", openingDate=" + openingDate +
                ", isBlocked=" + accountLock +
                '}';
    }
}
