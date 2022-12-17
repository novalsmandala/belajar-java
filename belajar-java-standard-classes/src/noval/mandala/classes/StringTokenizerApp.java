package noval.mandala.classes;

import java.util.StringTokenizer;

public class StringTokenizerApp {
    public static void main(String[] args) {
        String name = "Noval,Surya,Mandala";
        StringTokenizer tokenizer = new StringTokenizer(name, ",");
        while(tokenizer.hasMoreTokens()){
            String result = tokenizer.nextToken();
            System.out.println(result);
        }
    }
}
