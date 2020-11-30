import java.util.Scanner;
//三元一次方程组的解
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr= new int[4];
        for (int i = 0;i < 4;i++){
            arr[i] = scanner.nextInt();
        }
        String ret = Numbers(arr);
        System.out.println(ret);
    }
    public static String Numbers(int[] nums){
        double A = (nums[0] + nums[2])/2.0;
        double B = (nums[1] + nums[3])/2.0;
        double C1 = B - nums[1];
        double C2 = nums[3] - B;
        if (C1 != C2){
            return "No";
        }
        if (A < 0 || B < 0 || C1 < 0){
            return "No";
        }
        if ((int) A != A || (int) B != B || (int) C1 != C1){
            return "No";
        }
        return (int)A+" "+(int)B+" "+(int)C1;
    }
}
