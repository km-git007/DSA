class Solution {

    private boolean validTime(int[] ranks, long carsInGarage, long time)
    {
        long carsRepaired = 0;
        for(int rank : ranks)
        {
            // time to repair n cars is time i.e time = rank * n * n
            // that's how you calculate the number of cars 'n' repaired in that time
            carsRepaired += Math.floor(Math.sqrt(1.0 * time / rank));
            if(carsRepaired >= carsInGarage)
            return true;
        }
        return false;
    }

    public long repairCars(int[] ranks, int cars) 
    {
        long start = 1;
        long maxRank = Arrays.stream(ranks).reduce(-1, (a, b) -> Math.max(a, b));
        // tike taken would be max when the worker with worst rank repais all the cars.
        long end = maxRank*cars*cars;  
        long minTimeToRepairCars=end;
        while(start<=end)
        {
            long mid=start+(end-start)/2;
            if(validTime(ranks,cars,mid))
            {
                minTimeToRepairCars=mid;
                end=mid-1;
            }
            else
            start=mid+1;
        }
        return minTimeToRepairCars;
    }
}