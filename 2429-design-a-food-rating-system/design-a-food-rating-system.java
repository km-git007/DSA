
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

    // stores <cuisine,List<Food>> as key value pair.
    // stores the list of Foods belonging to the same cuisine.
    private HashMap<String,List<Food>> cuisineMap;

    // lets us know the maxRatedFood of the cuisine in O(1) time.
    private HashMap<String,Food> maxRatedFoodOfCuisineMap;


    private boolean compareRating(Food food1,Food food2)
    {
        // if this condition is satisfied then food1 becomes the max rated food of the cuisine
        if(food1.rating>food2.rating || (food1.rating==food2.rating && food1.name.compareTo(food2.name)<0))
            return true;
        return false;
    }


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings)
    {
        foodMap=new HashMap<>();
        cuisineMap=new HashMap<>();
        maxRatedFoodOfCuisineMap=new HashMap<>();

        for(int i=0;i<foods.length;i++)
        {
            Food foodItem=new Food(foods[i],cuisines[i],ratings[i]);
            foodMap.put(foods[i],foodItem);

            // if the cuisine map contains the List of Foods belonging to the same cuisine
            // just add the current foodItem in the cuisineMap.
            if(cuisineMap.containsKey(cuisines[i]))
            {
                cuisineMap.get(cuisines[i]).add(foodItem);
            }

            // if the cuisine map doesn't contain the List of Foods belonging to the same cuisine
            // Create a new list of Foods and add the foodItem in the list and map it with the cuisine.
            else
            {
                List<Food> foodList=new ArrayList<>();
                foodList.add(foodItem);
                cuisineMap.put(cuisines[i],foodList);
            }


            // Now populating the Hashmap maxRatedFoodOfCuisine which lets us know
            // the max-rated-food-of-the-cuisine in O(1) time.
            if(maxRatedFoodOfCuisineMap.containsKey(cuisines[i]))
            {
                Food food= maxRatedFoodOfCuisineMap.get(cuisines[i]);
                if(compareRating(foodItem,food))
                    maxRatedFoodOfCuisineMap.put(cuisines[i],foodItem);
            }
            else
                maxRatedFoodOfCuisineMap.put(cuisines[i],foodItem);
        }
    }


    public void changeRating(String food, int newRating)
    {
        Food foodItem=foodMap.get(food);
        int presentRating=foodItem.rating;
        
        
        // find the maxRatedFood of the current food item's cuisine
        Food maxRatedFood= maxRatedFoodOfCuisineMap.get(foodItem.cuisine);

        // Update the rating of the food
        foodItem.rating=newRating;

        
        // If the rating is getting increased then we check whether we can make this foodItem as
        // the maxRatedFood of its cuisine.
        if(presentRating<newRating)
        {
            if(compareRating(foodItem,maxRatedFood))
                maxRatedFoodOfCuisineMap.put(foodItem.cuisine,foodItem);
        }
        
        // If the rating is going to get down then we check whether the current FoodItem is
        // the maxRatedFood of its cuisine or not.If it is the maxRatedFood its cuisine then
        // we iterate over the list of foodItems belonging to the cuisine
        // and update the maxRatedFood of the current food item's cuisine.
        else if(presentRating>newRating && maxRatedFood==foodItem)
        {
            List<Food> foodList = cuisineMap.get(foodItem.cuisine);
            Food newMaxRatedFood = null;
            for (Food myFood : foodList)
            {
                if (newMaxRatedFood == null || compareRating(myFood, newMaxRatedFood))
                {
                    newMaxRatedFood = myFood;
                }
            }
            // Update the max-rated food in the map
            maxRatedFoodOfCuisineMap.put(foodItem.cuisine, newMaxRatedFood);
        }
    }


    public String highestRated(String cuisine)
    {
        return maxRatedFoodOfCuisineMap.get(cuisine).name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */