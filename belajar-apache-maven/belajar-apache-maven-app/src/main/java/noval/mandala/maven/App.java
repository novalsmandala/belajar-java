package noval.mandala.maven;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Gson gson = new Gson();

        Person person = new Person("Noval Surya Mandala");
        person.address = "Serang";
        person.school = "SMKN 3 KENDAL";

        String json = gson.toJson(person);

        System.out.println(json);

    }
}
