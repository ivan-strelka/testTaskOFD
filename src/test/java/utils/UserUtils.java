package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.stream.Stream;

public class UserUtils {

    private static final Faker ruFaker = new Faker(new Locale("ru"));
    private static final Faker enFaker = new Faker(new Locale("en"));

    public static String getUserFirstName() {
        return ruFaker.name().firstName();
    }

    public static String getUserLastName() {
        return ruFaker.name().lastName();
    }

    public static String getUserName() {
        return ruFaker.name().name();
    }

    public static String getRandomEmail() {
        return enFaker.internet().emailAddress();
    }

    public static String getRandomPhone() {
        return enFaker.phoneNumber().cellPhone();
    }

}
