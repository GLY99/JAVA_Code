package I;
public class Solution {
    public static int countOne(int num){
        int count = 0;
        while (num != 0){
            if ((num & 1) !=0){
                count++;
            }
            num =num >>> 1;
        }
        return count;
    }
}
