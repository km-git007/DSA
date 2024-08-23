
class UndergroundSystem {

    private:
    class Trip {

        public:
        int cardId;
        int checkInTime;
        string checkInStation;

        Trip(int cardId, int checkInTime, string checkInStation) {
            this->cardId = cardId;
            this->checkInStation = checkInStation;
            this->checkInTime = checkInTime;
        }
    };

    // stores the key(checkInStation + "_" + checkOutStation) and pair{avgTime,trips} details as key-value pair.
    unordered_map<string, pair<double, double>> tripMap;

    // stores the cardId and Trip's details as key-value pair.
    unordered_map<int, Trip*> checkInMap;
    

    public:
    UndergroundSystem() 
    {
        tripMap = unordered_map<string, pair<double, double>>();
        checkInMap = unordered_map<int, Trip*>();
    }

    void checkIn(int id, string stationName, int t)
    {
        // create a new trip 
        Trip *trip=new Trip(id, t, stationName);
        // storing the trip details in the checkInMap.
        checkInMap[id] = trip;
    }

    void checkOut(int id, string stationName, int t)
    {
        Trip *trip = checkInMap[id];
        string startStation = trip->checkInStation;
        // calculate the time taken to travel from checkInStation --> checkOutStation.
        double travelTime = t - trip->checkInTime;

        // since this trip is completed hence removing the current trip from the checkIn map.
        checkInMap.erase(id);

        // generate a key including both station names.
        string key = startStation + "_" + stationName;

        // if a value to this key exists then it means that trips have been made earlier on this 
        // route{checkInStation --> checkOutStation}. So we already have the data about the 
        // average travel time on this route and the number of trips taken, stored in the tripMap.
        if (tripMap.find(key) != tripMap.end()) {
            double currentAverageTime = tripMap[key].first;
            double currentTrips = tripMap[key].second;
            double newAverageTime = (currentAverageTime * currentTrips + travelTime) / (currentTrips + 1);
            tripMap[key] = {newAverageTime, currentTrips + 1};
            return;
        }

        // if a value corresponding to the key does not exist means this is the first trip on this
        // route{checkInStation --> checkOutStation}. hence put the values{travelTime,1} corresponding 
        // to key in tripMap.
        tripMap[key] = {travelTime, 1.00};
    }

    double getAverageTime(string startStation, string endStation)
    {
        // create a key
        string key = startStation + "_" + endStation;
        // get the value corresponding to key
        return tripMap[key].first;
    }
};


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem* obj = new UndergroundSystem();
 * obj->checkIn(id,stationName,t);
 * obj->checkOut(id,stationName,t);
 * double param_3 = obj->getAverageTime(startStation,endStation);
 */