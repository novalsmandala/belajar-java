package programmer.zaman.now.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadApp {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("README.md"))){
            while(true){
                String text = reader.readLine();
                if (text == null){
                    break;
                }
                System.out.println(text);
            }
        }catch (IOException e){
            System.out.println("Erorr membuka file " + e.getMessage());
        }
    }
}
