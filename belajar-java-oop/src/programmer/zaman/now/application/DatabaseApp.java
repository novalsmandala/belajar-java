package programmer.zaman.now.application;

import programmer.zaman.now.data.BlankException;
import programmer.zaman.now.data.DatabaseErorr;

public class DatabaseApp {
    public static void main(String[] args) {
        connectDatabase("admin", "admin12345");
        System.out.println("berhasil terkonek");
    }


    public static void connectDatabase(String name, String password){
        if (name == null | password == null){
            throw new DatabaseErorr("Tidak bisa konek ke database");
        }else if (name.isBlank() | password.isBlank()){
            throw new BlankException("Password & Username is blank");
        }
    }
}
