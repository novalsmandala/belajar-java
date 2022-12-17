package noval.mandala.i18n;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

    @Test
    void testResourceBundle() {

        var resourcebundle = ResourceBundle.getBundle("message");

        System.out.println(resourcebundle.getString("hello"));
        System.out.println(resourcebundle.getString("goodBye"));
    }

    @Test
    void testResourceBundleIndonesia() {

        var language = "in";
        var country = "ID";

        Locale indonesia = new Locale(language, country);

        var resourcebundle = ResourceBundle.getBundle("message", indonesia);

        System.out.println(resourcebundle.getString("hello"));
        System.out.println(resourcebundle.getString("goodBye"));
    }

    @Test
    void testResourceBundleNotFound() {

        var language = "in";
        var country = "ID";

        Locale locale = new Locale(language, country);

        var resourcebundle = ResourceBundle.getBundle("message");

        System.out.println(resourcebundle.getString("hello"));
        System.out.println(resourcebundle.getString("goodBye"));
    }

    @Test
    void testResourceBundleMultipletime() {

        var indonesia = new Locale("en", "US");

        var resourceBundle1 = ResourceBundle.getBundle("message", indonesia);
        var resourceBundle2 = ResourceBundle.getBundle("message", indonesia);

        System.out.println(resourceBundle1 == resourceBundle2);
    }
}


