class Solution {

    private boolean validTime(int[] ranks, long carsInGarage, long time)
    {
        long carsRepaired = 0;
        for(int rank : ranks)
        {
            carsRepaired += Math.floor(Math.sqrt((double)time/(double)rank));
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