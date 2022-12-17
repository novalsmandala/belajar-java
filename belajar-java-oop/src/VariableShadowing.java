public class VariableShadowing {
    String name;
    String address;

    // variable shadowing
    VariableShadowing(String name, String address){
        // tidak akan berubah karena ditutupi oleh variable dari constructor
        name = name;
        address = address;

        // untuk menyelasaikan itu kita bisa menggunakan this keyword
        // this merpresentasikan dari field class tersebuts
        this.name = name;
        this.address = address;
    }

    // penggunaan this pada method
    void sayHello(String name){
        System.out.println("Hello " + name + " my name is " + this.name );
    }
}
