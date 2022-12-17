public class ManagerApp {
    public static void main(String[] args) {
        var manager = new Manager("Nopal");
        manager.name = "Paul";
        manager.sayHello("Roger");

        var vicePresident = new VicePresident("Nopal");
        vicePresident.name = "Budi";
        vicePresident.sayHello("Rudi");
    }
}
