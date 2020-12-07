import java.util.Arrays;
import java.util.Scanner;

//TOPK问题
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String string = scanner.nextLine();
            String[] array = string.split(" ");
            int[] nums = new int[array.length - 1];
            for (int i = 0;i < nums.length;i++){
                nums[i] = Integer.parseInt(array[i]);
            }
            int k = Integer.parseInt(array[array.length - 1]);
            int left = 0;
            int right = nums.length - 1;
            int part = partion(nums,left,right);
            while (part + 1 != k){
                if (part + 1 > k){
                    right = part - 1;
                    part = partion(nums,left,right);
                }else {
                    left = part + 1;
                    part = partion(nums,left,right);
                }
            }
            Arrays.sort(nums,0,k);
            for (int i = 0;i < k;i++){
                System.out.print(nums[i] + " ");
            }
        }
    }
    public static int partion(int[] nums,int left,int right){
        int temp = nums[left];
        while (left < right){
            while (left < right && nums[right] >= temp){
                right--;
            }
            if (left < right){
                nums[left] = nums[right];
            }else {
                break;
            }
            while (left < right && nums[left] <= temp){
                left++;
            }
            if (left < right){
                nums[right] = nums[left];
            }else {
                break;
            }
        }
        nums[left] = temp;
        return left;
    }
}
