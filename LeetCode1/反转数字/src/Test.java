public class Test {
    public static int oppositeNumber(int x){
        long sum = 0;
        while (x != 0){
            sum = 10 * sum + (x % 10);
            x = x / 10;
        }
        if((int)sum != sum){
            return 0;
        }
        return (int)sum;
    }
    public static int opp(int x){
        int ret = 0;
        int temp;
        while (x != 0){
            temp = x % 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && temp > 7))return 0;
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && temp < -8))return 0;
            ret = ret * 10 + temp;
            x = x / 10;
        }
        return ret;
    }
}
