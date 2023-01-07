package noval.surya.mandala.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public class Person {

//    @Valid
//    @NotBlank(message = "hobbies cannot blank") // salah
//    private List<String> hobbies;
    // validasi list atau container (queue, map , list , and etc)
    private List<@NotBlank(message = "hobbies cannot blank") String> hobbies;

    @NotBlank(message = "First name cannot blank")
    @Size(max = 20, message = "first name length must 20 character")
    private String firstName;

    @NotBlank(message = "Last name cannot blank")
    @Size(max = 20, message = "first name length must 20 character")
    private String lastName;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @NotNull(message = "address cannot null")
    @Valid
    private Address address;

    @Valid
    public Person() {
    }

    @Valid
    public Person(@NotBlank(message = "first name cannot blank") String firstName,
                  @NotBlank(message = "last name cannot blank") String lastName,
                  @NotNull(message = "address name cannot null") @Valid Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void sayHello(@NotBlank(message = "name cannot blank") String name) {
        System.out.println("Hello " + name + ", my name is " + firstName);
    }

    @NotBlank(message = "full name can not blank")
    public String fullName() {
        return firstName + " " + lastName;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
