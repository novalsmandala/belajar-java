public class PolymorphismApp {
    public static void main(String[] args) {
        Employee employee = new Employee("Noval");
        employee.sayHello("Eko");
        employee = new Manager("Joko");
        employee.sayHello("Budi");
        employee = new Manager("Steven");
        employee.sayHello("Wozniak");

        // mengakses dengan method
        sayHello(new Employee("Wicak"));
        sayHello(new Manager("Budi"));
        sayHello(new VicePresident("Dimas"));
    }

    static void sayHello(Employee employee){
        if(employee instanceof VicePresident){
            VicePresident vicePresident = (VicePresident) employee;
            System.out.println("Halo " + vicePresident.name);
        }else if(employee instanceof Manager){
            Manager manager = (Manager) employee;
            System.out.println("Halo " + manager.name);
        }else{
            System.out.println("Halo " + employee.name);
        }

    }

}
