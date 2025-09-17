struct Food {
    string name, cuisine;
    int rating;
};

struct FoodComparator {
    bool operator()(const Food* f1, const Food* f2) const {
        if (f1->rating == f2->rating) {
            return f1->name < f2->name;  // lexicographically smaller comes first
        }
        return f1->rating > f2->rating; // higher rating first
    }
};

class FoodRatings {
    unordered_map<string, Food*> foodMap;  // food -> Food*
    unordered_map<string, set<Food*, FoodComparator>> cuisineMap; // cuisine -> ordered set

public:
    FoodRatings(vector<string>& foods, vector<string>& cuisines, vector<int>& ratings) {
        for (int i = 0; i < foods.size(); i++) {
            Food* food = new Food{foods[i], cuisines[i], ratings[i]};
            foodMap[foods[i]] = food;
            cuisineMap[cuisines[i]].insert(food);
        }
    }

    void changeRating(string food, int newRating) {
        if (!foodMap.count(food)) return;
        Food* f = foodMap[food];
        cuisineMap[f->cuisine].erase(f); // remove old
        f->rating = newRating;
        cuisineMap[f->cuisine].insert(f); // reinsert
    }

    string highestRated(string cuisine) {
        return (*cuisineMap[cuisine].begin())->name; // first element = best
    }
};
