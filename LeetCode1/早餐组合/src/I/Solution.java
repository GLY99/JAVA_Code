package I;
//给定两个数组，在两个数组中各取一个数，找出有几组数据相加小于等于指定值X。
import java.util.Arrays;

public class Solution {
    public int breakfastNumber(int[] staple, int[] drinks, int x){
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int i = 0;
        int j = drinks.length - 1;
        int count = 0;
        while (i < staple.length && j >= 0){
            if (staple[i] + drinks[j] > x){
                j--;
            }else {
                count += j+1;
                count = count % 1000000007;
                i++;
            }
        }
        return count;
    }
}
