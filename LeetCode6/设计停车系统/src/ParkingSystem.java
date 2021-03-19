class ParkingSystem {
    private int bigSum;
    private int mediumSum;
    private int smallSum;
    public ParkingSystem(int big, int medium, int small) {
        this.bigSum = big;
        this.mediumSum = medium;
        this.smallSum = small;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1){
            if (bigSum > 0){
                bigSum--;
                return true;
            }
        }else if (carType == 2){
            if (mediumSum > 0){
                mediumSum--;
                return true;
            }
        }else if (carType == 3){
            if (smallSum > 0){
                smallSum--;
                return true;
            }
        }
        return false;
    }
}