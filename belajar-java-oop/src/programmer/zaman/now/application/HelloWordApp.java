package programmer.zaman.now.application;

import programmer.zaman.now.data.HelloWorld;

public class HelloWordApp {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld(){
            @Override
            public void sayHello() {
                System.out.println("Hello");
            }

            @Override
            public void sayHello(String name) {
                System.out.println("Hello " + name);
            }
        };
    }
}
