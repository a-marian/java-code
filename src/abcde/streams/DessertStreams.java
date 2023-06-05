package abcde.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import static java.util.stream.Collectors.groupingBy;

enum DessertCategory {
    CAKE, FROZEN, DRINKS, FRIED, COBBLERS, TART, BAKED;
}
record Dessert(Integer id, String name, Double calories, DessertCategory category  ){}
public class DessertStreams {

    public static void main(String[] args) {
        List<Dessert> menu = new ArrayList<>();
        menu.add(new Dessert(1,"Banana split", 23.09, DessertCategory.FROZEN));
        menu.add(new Dessert(2,"Ice Cream Sandwich", 23.09, DessertCategory.FROZEN));
        menu.add(new Dessert(3,"Gelato cioccolato", 23.09, DessertCategory.FROZEN));
        menu.add(new Dessert(4,"Cheesecake", 30.05, DessertCategory.TART ));
        menu.add(new Dessert(5,"Pastafrola", 30.05, DessertCategory.TART ));
        menu.add(new Dessert(6,"Apple Frangipane Tart", 10.10, DessertCategory.TART ));
        menu.add(new Dessert(7,"Coq au vin pie", 28.30, DessertCategory.CAKE));
        menu.add(new Dessert(8,"Chocolate brownie pie", 28.30, DessertCategory.CAKE));
        menu.add(new Dessert(9,"Mum's mini mince pies", 28.30, DessertCategory.BAKED));
        menu.add(new Dessert(10,"Irish Coffee Cake", 11.90 , DessertCategory.DRINKS ));
        menu.add(new Dessert(11,"Flan", 11.90 , DessertCategory.DRINKS ));
        menu.add(new Dessert(12,"Mudslide", 11.90 , DessertCategory.DRINKS ));
        menu.add(new Dessert(13,"Yogurt with Blueberries", 23.09, DessertCategory.FROZEN));

        // list dishes by name with calories lower than 25.00
        List<String> highCaloriesDishes = menu.stream()
                .filter(dish -> dish.calories() > 25.00)
                .map(Dessert::name)
                .limit(4)
                .toList();

        highCaloriesDishes.forEach(System.out::println);

        // Filter all frozen desserts then print in by name in alphabetical order
        List<Dessert> frozenDesserts = menu.stream().filter(d -> d.category().equals(DessertCategory.FROZEN))
                .sorted((a,b) -> a.name().compareTo(b.name())).toList();
        for (Dessert dessert: frozenDesserts) {
            System.out.println(dessert);
        }

        //print how much dessert exist in the menu by category
        Map<DessertCategory, List<Dessert>> dessertsByCategory = menu.stream()
                .collect(groupingBy(Dessert::category));
        dessertsByCategory.forEach((k,v) -> System.out.println(k +": "+  v + " \n" ));


        // matching
        Predicate<Dessert> getTartDesserts = d -> d.category().equals(DessertCategory.TART);
        System.out.println("Is there any tart as dessert? " + menu.stream().anyMatch(getTartDesserts)); // true
        System.out.println("All desserts are tart? " + menu.stream().allMatch(getTartDesserts)); // false
        System.out.println("Neither of these dessert is a tart?" + menu.stream().noneMatch(getTartDesserts)); // false


    }

}
