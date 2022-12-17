package programmer.zaman.now.application;

import programmer.zaman.now.data.CreateUserRequest;
import programmer.zaman.now.util.ValidatonUtil;

public class ReflectionApp {

    public static void main(String[] args) {
        CreateUserRequest request = new CreateUserRequest();
        request.setUsername("Noval");
        request.setPassword("rahasia");

        ValidatonUtil.validationreflection(request);
    }

}
