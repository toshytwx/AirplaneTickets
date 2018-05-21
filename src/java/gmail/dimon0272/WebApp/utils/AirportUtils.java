package gmail.dimon0272.WebApp.utils;

public class AirportUtils {

    public static String getSignature(String airportName) {
        return airportName.chars()
                .filter(Character::isUpperCase)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }
}
