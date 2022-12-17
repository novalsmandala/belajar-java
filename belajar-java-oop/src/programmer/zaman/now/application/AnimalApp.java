package programmer.zaman.now.application;

import programmer.zaman.now.annotation.Fancy;
import programmer.zaman.now.data.Animal;
import programmer.zaman.now.data.Cat;

@Fancy(name = "Noval", tags = {"Hello ", "Macem mana kamu"})
public class AnimalApp {
    public static void main(String[] args) {
        Animal animal = new Cat();
        System.out.println(animal.name);
        animal.run();


    }
}
