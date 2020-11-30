import java.util.Scanner;

//最小公倍数等于两数乘积除以最大公因子
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println(num1 / smallNumber(num1,num2) * num2);
    }
    //最大公因数
    public static int smallNumber(int a,int b){
        if (a < b){
            int temp = b;
            b = a;
            a = temp;
        }
        while (b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
