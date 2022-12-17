package noval.mandala.collection;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackApp {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("Noval");
        stack.push("Surya");
        stack.push("Mandala");

        System.out.println(stack.pop());

        try {
            for (var value = stack.pop(); value != null; value = stack.pop()) {
                System.out.println(value);
            }
        } catch (EmptyStackException e) {
//            e.printStackTrace();
        }
    }
}
