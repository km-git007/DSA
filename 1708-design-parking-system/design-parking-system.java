class ParkingSystem {

    HashMap<Integer,Integer> map;
    int big,medium,small;
    public ParkingSystem(int big, int medium, int small) 
    {
        map=new HashMap<>();
        this.big=big;
        this.medium=medium;
        this.small=small;
        map.put(1,0);
        map.put(2,0);
        map.put(3,0);
    }
    
    public boolean addCar(int carType) 
    {
        if(carType==1)
        {
            if(map.get(1)<big)
            {
                map.put(1,map.get(1)+1);
                return true;
            }
        }
        else if(carType==2)
        {
            if(map.get(2)<medium)
            {
                map.put(2,map.get(2)+1);
                return true;
            }
        }
        else
        {
            if(map.get(3)<small)
            {
                map.put(3,map.get(3)+1);
                return true;
            }
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */