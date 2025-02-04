
public class FoodRatings {

    private class Food
    {
        String name;
        String cuisine;
        int rating;
        public Food(String name, String cuisine, int rating)
        {
            this.name = name;
            this.rating = rating;
            this.cuisine = cuisine;
        }
    }

    // stores <food-name,Food> as key value pair.
    private HashMap<String,Food> foodMap;

    // HashMap that maps a cuisine to a TreeSet of Food objects
    private HashMap<String, TreeSet<Food>> cuisineMap;


    // Global static comparator for Food objects
    private static final Comparator<Food> FOOD_COMPARATOR = (food1, food2) -> {
        // First, compare by rating in descending order (max rating at the top)
        if (food1.rating != food2.rating) {
            return food2.rating - food1.rating;
        }
        // If ratings are the same, compare by name in lexicographical order (min name at the top)
        return food1.name.compareTo(food2.name);
    };
    
    
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings)
    {
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        for(int i = 0; i < foods.length; i++)
        {
            Food foodItem = new Food(foods[i],cuisines[i],ratings[i]);
            foodMap.put(foods[i],foodItem);

            // Get the priority queue for the cuisine, or create one if it doesn't exist
            cuisineMap.putIfAbsent(cuisines[i], new TreeSet<>(FOOD_COMPARATOR));

            // Add the food item to the corresponding cuisine's priority queue
            cuisineMap.get(cuisines[i]).add(foodItem);
        }
    }


    public void changeRating(String food, int newRating)
    {
        Food foodItem = foodMap.get(food);
    
        // Get the priority queue for the cuisine
        TreeSet<Food> foodSet = cuisineMap.get(foodItem.cuisine);

        // Remove the food item from the treeset
        foodSet.remove(foodItem);

        // Update the rating of the food
        foodItem.rating = newRating;

        // Reinsert the food item with the updated rating
        foodSet.add(foodItem);
    }
    
    public String highestRated(String cuisine)
    {
        return cuisineMap.get(cuisine).first().name;
    }
}


/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */