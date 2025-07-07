@DeprecatedEx(message = "Use NewClass instead")
class OldClass {
    @DeprecatedEx(message = "Use newMethod() instead")
    public void oldMethod() {
        System.out.println("Старый метод");
    }

    public void newMethod() {
        System.out.println("Новый метод");
    }
}