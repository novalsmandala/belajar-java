package util;

import java.util.Scanner;

public class InputUtil {
    public static String input(String info){

        Scanner scanner = new Scanner(System.in);
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }
}
