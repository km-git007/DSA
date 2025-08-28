class ParkingSystem {

    int big, small, medium;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if(carType == 1) {
            if(big > 0){
                big--;
                return true;
            }
            return false;
        }
        else if(carType == 2) {
            if(medium > 0){
                medium--;
                return true;
            }
            return false;
        }
        
        if(small > 0){
            small--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */