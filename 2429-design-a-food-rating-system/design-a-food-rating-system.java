class Food implements Comparable<Food> {
    String name, cuisine;
    int rating;
    Food() {}
    Food(String name, String cuisine, int rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }

    @Override
    public int compareTo(Food o) {
        if (this.rating == o.rating) {
            return this.name.compareTo(o.name); // lexicographically smaller first
        }
        return Integer.compare(o.rating, this.rating); // higher rating first
    }
}

class FoodRatings {

    Map<String, Food> foodMap;
    Map<String, TreeSet<Food>> cuisineMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        for(int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(food.name, food);
            cuisineMap.putIfAbsent(cuisines[i], new TreeSet<>());
            cuisineMap.get(cuisines[i]).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        if(!foodMap.containsKey(food)) {
            return;
        }

        // get hold of the old-food
        Food oldFood = foodMap.get(food);
        //remove it from the cuisineMap
        cuisineMap.get(oldFood.cuisine).remove(oldFood);

        //change the rating
        oldFood.rating = newRating;
        //put the updated food in cuisineMap
        cuisineMap.get(oldFood.cuisine).add(oldFood);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).getFirst().name;
    }
}