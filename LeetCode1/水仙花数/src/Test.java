public class Test {
    //1^3 + 5^3+ 3^3 = 153
    public static boolean narcissisticNumber(int num){
        int count = 0;
        int sum = 0;
        int temp = num;
        while (temp != 0){
            temp = temp / 10;
            count++;
        }
        temp = num;
        while (temp != 0){
            sum += Math.pow((temp % 10),count);
            temp = temp / 10;
        }
        if(sum == num){
            return true;
        }
        return false;
    }
}
