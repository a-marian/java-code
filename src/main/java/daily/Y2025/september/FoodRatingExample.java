package daily.Y2025.september;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatingExample {

        // Map food with its rating.
        private Map<String, Integer> foodRatingMap;
        // Map food with the cuisine it belongs to.
        private Map<String, String> foodCuisineMap;

        // Store all food of a cuisine in a priority queue (to sort them on ratings/name)
        // Priority queue element -> Food: (foodRating, foodName)
        private Map<String, PriorityQueue<Food>> cuisineFoodMap;

        public FoodRatingExample(String[] foods, String[] cuisines, int[] ratings) {
            foodRatingMap = new HashMap<>();
            foodCuisineMap = new HashMap<>();
            cuisineFoodMap = new HashMap<>();

            for (int i = 0; i < foods.length; ++i) {
                // Store 'rating' and 'cuisine' of the current 'food' in 'foodRatingMap' and 'foodCuisineMap' maps.
                foodRatingMap.put(foods[i], ratings[i]);
                foodCuisineMap.put(foods[i], cuisines[i]);
                // Insert the '(rating, name)' element into the current cuisine's priority queue.
                cuisineFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new Food(ratings[i], foods[i]));
            }
        }

        public void changeRating(String food, int newRating) {
            // Update food's rating in the 'foodRating' map.
            foodRatingMap.put(food, newRating);
            // Insert the '(new food rating, food name)' element into the respective cuisine's priority queue.
            String cuisineName = foodCuisineMap.get(food);
            cuisineFoodMap.get(cuisineName).add(new Food(newRating, food));
        }

        public String highestRated(String cuisine) {
            // Get the highest rated 'food' of 'cuisine'.
            Food highestRated = cuisineFoodMap.get(cuisine).peek();

            // If the latest rating of 'food' doesn't match the 'rating' on which it was sorted in the priority queue,
            // then we discard this element from the priority queue.
            while (foodRatingMap.get(highestRated.foodName) != highestRated.foodRating) {
                cuisineFoodMap.get(cuisine).poll();
                highestRated = cuisineFoodMap.get(cuisine).peek();
            }

            // Return the name of the highest-rated 'food' of 'cuisine'.
            return highestRated.foodName;
        }


}
