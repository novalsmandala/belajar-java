package noval.surya.mandala.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    void testCustomer() {

        var customer = new Customer();
        customer.setId("100");
        customer.setName("Noval");

        System.out.println(customer.getId());
        System.out.println(customer.getName());
    }

    @Test
    void testCustomerConstructor() {

        var customer = new Customer("id", "name");
        Assertions.assertEquals("id", customer.getId());
        Assertions.assertEquals("name", customer.getName());
    }

    @Test
    void testEquals() {

        var customer1 = new Customer("ID", "NAME 1");
        var customer2 = new Customer("ID", "NAME 1");

        Assertions.assertEquals(customer1, customer2);
        Assertions.assertEquals(customer1.hashCode(), customer2.hashCode());

        System.out.println(customer1.hashCode());
        System.out.println(customer2.hashCode());
    }
}
