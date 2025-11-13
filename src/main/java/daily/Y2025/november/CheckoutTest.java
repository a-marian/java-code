package daily.Y2025.november;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutTest {

    record Country ( String name, String president, boolean isDemocratic ){}

    static List<String> LEFT_SIDE= List.of("Ireland", "Chile", "Brasil");

    public static void main(String[] args) {
        Country country1 = new Country("Argentina", "Milei", true);
        Country country2 = new Country("Denmark", "Frederiksen", true);
        Country country3 = new Country("Corea del Norte", "Kim Jong-un", false );
        Country country4 = new Country("Chile", "Boric", true);
        Country country5 = new Country("Ireland", "Connolly", true);
        List<Country> countries = List.of(country1, country2, country3, country4, country5);

        List<String> leftDemocraticCountries = countries.stream().filter(country ->
                        country.isDemocratic && LEFT_SIDE.contains(country.name))
                .map(Country::name).toList();

        leftDemocraticCountries.forEach(System.out::println);
    }
}
