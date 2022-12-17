class Person {
    // contoh field
    String name;
    String address;
    final String country = "Indonesia"; // data final atau tidak dapat diubah lagi

    void sayHello(String name){
        System.out.println("Hello " + name);
    }

    Person (String paramName, String paramAddres){
        this.name = paramName;
        this.address = paramAddres;
    }

    /**
     *
     * Constructor overloading
     */
    Person (String paramName){
        this.name = paramName;
    }

    Person(){

    }
}
