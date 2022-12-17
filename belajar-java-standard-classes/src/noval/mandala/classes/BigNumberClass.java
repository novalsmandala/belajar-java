package noval.mandala.classes;

import java.math.BigInteger;

public class BigNumberClass {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("1000000000000000000000000");
        BigInteger b = new BigInteger("5000000000000000000000000");

        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
