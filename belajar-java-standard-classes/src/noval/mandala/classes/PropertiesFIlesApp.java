package noval.mandala.classes;

import java.io.*;
import java.util.Properties;

public class PropertiesFIlesApp {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("application.properties"));

            // mengambil data menggunakan get propery dengan parameter key
            String host = properties.getProperty("database.host");
            String port = properties.getProperty("database.port");
            String username = properties.getProperty("database.username");
            String password = properties.getProperty("database.password");

            System.out.println(host);
            System.out.println(port);
            System.out.println(username);
            System.out.println(password);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // untuk menambah menggunakan put parameter key dan value
        properties.put("database.name", "siswa");

        // untuk menambahkan nya gunakan perintah store
        try {
            properties.store(new FileOutputStream("application.properties"), "nothing");
            String databaseName = properties.getProperty("database.name");
            System.out.println(databaseName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
