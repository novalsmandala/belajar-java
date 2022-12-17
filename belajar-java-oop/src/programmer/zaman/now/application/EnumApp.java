package programmer.zaman.now.application;

import jdk.swing.interop.SwingInterOpUtils;
import programmer.zaman.now.data.Customer;
import programmer.zaman.now.data.Level;

import java.sql.Array;
import java.util.Arrays;

public class EnumApp {
    public static void main(String[] args) {

        var customer = new Customer();
        customer.setName("Eko");
        customer.setLevel(Level.PREMIUM);
        System.out.println(customer.getLevel().toString());
        System.out.println(customer.getLevel().getDescription());

        String levelString = Level.STANDARD.name();
        System.out.println(levelString);
        Level level = Level.valueOf("VIP");
        System.out.println(level);

        Level[] levels = Level.values();
        System.out.println(Arrays.toString(levels));

    }
}
