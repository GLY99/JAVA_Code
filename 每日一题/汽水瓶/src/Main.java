import java.util.Scanner;

public class Main {
    //递归
    public static int drink(int nums){
        if (nums == 0 || nums == 1)return 0;
        if (nums == 2)return 1;
        int temp = nums / 3;
        int count = temp + drink(temp + nums % 3);
        return count;
    }
    //迭代
    public static int drinkI(int nums){
        int count = 0;
        while (nums > 2){
            int temp = nums / 3;
            count += temp;
            nums = temp + (nums % 3);
        }
        if (nums == 2){
            return count + 1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            int count = drinkI(num);
            if (count == 0){
                System.out.println();
            }else {
                System.out.println(count);
            }
        }
    }
}