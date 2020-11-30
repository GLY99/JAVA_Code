public class Test {
    public static int commonFactor(int num1,int num2){
        int a;
        int b;
        if (num1 > num2){
             a = num1;
             b = num2;
        }else {
             a = num2;
             b = num1;
        }
        int c;
        while (a % b != 0){
            c = a % b;
            a = b;
            b = c;
        }
        return b;
    }
}
