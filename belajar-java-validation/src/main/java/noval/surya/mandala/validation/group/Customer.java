package noval.surya.mandala.validation.group;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Customer {

    @Email(message = "Email must valid format")
    @NotBlank(message = "email can not blank")
    private String email;

    @NotBlank(message = "name can not blank")
    private String name;

    public Customer(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Customer() {
    }
}
