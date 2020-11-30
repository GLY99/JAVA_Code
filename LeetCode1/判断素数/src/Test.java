public class Test {
    public static boolean judgePrimeNum(int num){
        if (num == 0){
            return true;
        }
        int i;
        for (i = 2;i <= Math.sqrt(num);i++){
            if (num % i == 0){
                break;
            }
        }
        if (i > Math.sqrt(num)){
            return true;
        }
        return false;
    }
}
