package noval.mandala.classes;

import java.util.Arrays;

public class ArrayClassApp {
    public static void main(String[] args) {
        int[] numbers = {
                1, 2, 11, 5 , 33, 5, 2, 66, 4, 9
        };

        // sort array
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        // search array
        System.out.println(Arrays.binarySearch(numbers, 11));

        // copy array
        int[] copyOfNumber = Arrays.copyOf(numbers, 5);
        System.out.println(Arrays.toString(copyOfNumber));
    }
}
