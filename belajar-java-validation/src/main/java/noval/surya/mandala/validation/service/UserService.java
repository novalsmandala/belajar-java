package noval.surya.mandala.validation.service;

import jakarta.validation.constraints.NotBlank;
import noval.surya.mandala.validation.constraint.CheckPasswordParameter;

public class UserService {

    @CheckPasswordParameter(
        passwordParam = 1,
        retypePasswordParam = 2
    )
    public void register(@NotBlank(message = "username cannot blank") String username,
                         @NotBlank(message = "username cannot blank") String password,
                         @NotBlank(message = "username cannot blank") String retypePass) {
        // TODO register
    }
}
