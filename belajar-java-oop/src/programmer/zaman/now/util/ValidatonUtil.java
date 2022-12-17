package programmer.zaman.now.util;

import programmer.zaman.now.annotation.NotBlank;
import programmer.zaman.now.data.BlankException;
import programmer.zaman.now.data.LoginRequest;
import programmer.zaman.now.data.ValidationException;

import java.lang.reflect.Field;

public class ValidatonUtil {
    public static void validate(LoginRequest loginRequest) throws ValidationException, NullPointerException{
        if (loginRequest.username() == null){
            throw new NullPointerException("Username tidak boleh null");
        }else if(loginRequest.username().isBlank()){
            throw new ValidationException("Username tidak boleh kosong");
        }else if(loginRequest.password() == null){
            throw new NullPointerException("Password tidak boleh null");
        }else if (loginRequest.password().isBlank()){
            throw new ValidationException("Password tidak boleh kosong");
        }
    }

    public static void validateRuntime(LoginRequest loginRequest){
        if (loginRequest.username() == null){
            throw new NullPointerException("Username is null");
        }else if (loginRequest.username().isBlank()){
            throw new BlankException("username is blank");
        }else if (loginRequest.password() == null){
            throw new NullPointerException("Password is null");
        }else if (loginRequest.password().isBlank()){
            throw new BlankException("Password is blank");
        }
    }

    public static void validationreflection(Object o){
        Class aclass = o.getClass();
        Field[] fields = aclass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            if (field.getAnnotation(NotBlank.class) != null){
                // validate
                try {
                    String value = (String) field.get(o);

                    if(value == null || value.isBlank()){
                        throw new BlankException("Field " + field.getName() + " is Blank");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    System.out.println("Tidak bisa mengkakses field " + field.getName());
                }
            }
        }
    }

}
