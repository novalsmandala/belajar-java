public class PersonApp {
    public static void main(String[] args) {

        var person1 = new Person("Joni", "Pilang");
        Person person2 = new Person("Joko Setiawan");
        Person person3;
        person3 = new Person();

        // mengeluarkan data object
        // System.out.println(person1);
        // System.out.println(person2);
        // System.out.println(person3);

        // mengakses field person
        var person = new Person("Noval Mandala", "Serang");
        person.name = "Noval Surya Mandala";
        person.address = "Serang";
        // person.country = "Japan"; tidak bisa mengubah final type data

        // mengakses field pada object
        System.out.println(person.name);
        System.out.println(person.address);
        System.out.println(person.country);

        // mengakses method pada object
        person.sayHello("Joko");
    }
}
