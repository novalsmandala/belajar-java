package noval.mandala.classes;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexApp {
    public static void main(String[] args) {
        String text = "Noval Surya Mandala";

//      untuk menentukan pola rex
        Pattern pattern = Pattern.compile("[a-zA-z]*[y][a-zA-Z]*");
//      untuk mengolah hasilnya
        Matcher matcher = pattern.matcher(text);
//      mengeluarka hasilnya
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
