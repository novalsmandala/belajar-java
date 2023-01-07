package noval.surya.mandala.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    void testCreate() {

        var login1 = Login.createEmpty();

        Assertions.assertNull(login1.getUsername());
        Assertions.assertNull(login1.getPassword());

        var login2 = Login.create("noval", "rahasia");

        Assertions.assertEquals("noval", login2.getUsername());
        Assertions.assertEquals("rahasia", login2.getPassword());
    }

    @Test
    void testToString() {

        var login = Login.create("noval", "rahasia");
        System.out.println(login.toString());
    }
}
