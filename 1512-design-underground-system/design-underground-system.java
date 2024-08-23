class UndergroundSystem {

    HashMap<String,Double []> tripMap;

    HashMap<Integer,Traveller> checkInMap;

    private class Traveller{

        int travellerId;
        int checkInTime;
        String checkInStation;

        public Traveller(int travellerId, int checkInTime, String checkInStation) {
            this.travellerId = travellerId;
            this.checkInStation = checkInStation;
            this.checkInTime = checkInTime;
        }
    }

    public UndergroundSystem() 
    {
        tripMap=new HashMap<>();
        checkInMap=new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t)
    {
        Traveller t1=new Traveller(id,t,stationName);
        checkInMap.put(id,t1);
    }

    public void checkOut(int id, String stationName, int t)
    {
        Traveller traveller=checkInMap.get(id);
        String startStation=traveller.checkInStation;
        double travelTime= t-traveller.checkInTime;

        String key=startStation+"_"+stationName;
        if(tripMap.get(key)!=null){
            double currentAverageTime= tripMap.get(key)[0];
            double currentTrips= tripMap.get(key)[1];
            double newAverageTime=(currentAverageTime*currentTrips+travelTime)/(currentTrips+1);
            tripMap.put(key,new Double[]{newAverageTime,currentTrips+1});
            return;
        }

        tripMap.put(key,new Double[]{travelTime,1.00});
    }

    public double getAverageTime(String startStation, String endStation)
    {
        String key=startStation+"_"+endStation;
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