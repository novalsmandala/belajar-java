package programmer.zaman.now.application;

import programmer.zaman.now.data.LoginRequest;
import programmer.zaman.now.data.ValidationException;
import programmer.zaman.now.util.ValidatonUtil;

public class ValidationApp {
    public static void main(String[] args) {
        LoginRequest loginRequest = new LoginRequest("Noval", "rahasia");

        try {
            ValidatonUtil.validate(loginRequest);
            System.out.println("Login Berhasil");
        } catch (ValidationException | NullPointerException e) {
            e.printStackTrace();
            e.getMessage();
        }finally {
            System.out.println("erorr gak error tetap di eksekusi");
        }

        // runtime exception
        LoginRequest loginRequest1 = new LoginRequest("root", "root");
        ValidatonUtil.validateRuntime(loginRequest1);
        System.out.println("sukses");

//        try {
//            ValidatonUtil.validate(loginRequest);
//        } catch (ValidationException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }catch (NullPointerException e){
//            System.out.println("Null Exception " + e.getMessage());
//        }
    }
}
