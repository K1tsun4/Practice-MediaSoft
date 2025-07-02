public class Main {
    public static void main(String[] args) {
        BankAccount anna = new BankAccount("Anna");
        BankAccount ivan = new BankAccount("Ivan");

        System.out.println(anna.deposit(1000)); // счет Анны - 1000
        System.out.println(anna);
        System.out.println(ivan);

        System.out.println(anna.withdraw(300)); // счет Анны - 700
        System.out.println(anna);
        System.out.println(ivan);

        System.out.println(anna.transfer(ivan, 500)); // счет Анны - 200; Ивана - 500
        System.out.println(anna);
        System.out.println(ivan);

        System.out.println(anna.transfer(ivan, 500)); // счет Анны - 200; Ивана - 500, так как у Анны нет средств для перевода

        System.out.println(anna);
        System.out.println(ivan);
    }
}
