class UndergroundSystem {

    private class Trip{

        int cardId;
        int checkInTime;
        String checkInStation;

        public Trip(int cardId, int checkInTime, String checkInStation) {
            this.cardId = cardId;
            this.checkInStation = checkInStation;
            this.checkInTime = checkInTime;
        }
    }

    // stores the key(checkInStation + "_" + checkOutStation) and array{avgTime,trips} details as key value pair.
    private HashMap<String,Double []> tripMap;

    // stores the cardId and Trip's details as key value pair.
    private HashMap<Integer,Trip> checkInMap;

    public UndergroundSystem() 
    {
        tripMap=new HashMap<>();
        checkInMap=new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t)
    {
        // create a new trip 
        Trip trip=new Trip(id,t,stationName);
        // storing the trip details in the checkInMap.
        checkInMap.put(id,trip);
    }

    public void checkOut(int id, String stationName, int t)
    {
        Trip trip=checkInMap.get(id);
        String startStation=trip.checkInStation;
        // calculate the time taken to travel from checkInStation --> checkOutStation.
        double travelTime= t-trip.checkInTime;

        // since this trip is completed hence removing the current trip from the checkIn map.
        checkInMap.remove(Integer.valueOf(id));

        // generate a get including both station names.
        String key=startStation+"_"+stationName;

        // if a value to this key exists then it means that trips have been made earlier on this 
        // route{checkInStation --> checkOutStation}. So we already have the data about the 
        // average travel time on this route and the number of trips taken, stored in the tripMap.
        if(tripMap.get(key)!=null){
            double currentAverageTime= tripMap.get(key)[0];
            double currentTrips= tripMap.get(key)[1];
            double newAverageTime=(currentAverageTime*currentTrips+travelTime)/(currentTrips+1);
            tripMap.put(key,new Double[]{newAverageTime,currentTrips+1});
            return;
        }

        // if a value corresponding tothe key doesnot exists means this is the first trip on this
        // route{checkInStation --> checkOutStation}. hence put the values{travelTime,1} corresponding 
        // to key in tripMap.
        tripMap.put(key,new Double[]{travelTime,1.00});
    }

    public double getAverageTime(String startStation, String endStation)
    {
        // create a key
        String key=startStation+"_"+endStation;
        // get the value corresponding to key
        return tripMap.get(key)[0];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */