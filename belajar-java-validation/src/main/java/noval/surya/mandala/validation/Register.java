package noval.surya.mandala.validation;

import jakarta.validation.constraints.NotBlank;
import noval.surya.mandala.validation.constraint.CheckPassword;

@CheckPassword(message = "invalid invalid password and retype password must be same")
public class Register {

    @NotBlank(message = "username cannot blank")
    private String username;

    @NotBlank(message = "password cannot blank")
    private String password;

    @NotBlank(message = "retype password cannot blank")
    private String retypePassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    @Override
    public String toString() {
        return "Register{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", retypePassword='" + retypePassword + '\'' +
                '}';
    }
}
