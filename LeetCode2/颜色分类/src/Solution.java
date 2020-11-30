//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
public class Solution {
    //单指针
    public void sortColorsI(int[] nums) {
        int cur = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] == 0){
                int temp = nums[cur];
                nums[cur] = nums[i];
                nums[i] = temp;
                cur++;
            }
        }
        for (int i = cur;i < nums.length;i++){
            if (nums[i] == 1){
                int temp = nums[cur];
                nums[cur] = nums[i];
                nums[i] = temp;
                cur++;
            }
        }
    }
    //双指针
    public static void sortColorsII(int[] nums){
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }
    //双指针
    public static void sortColorsIII(int[] nums){
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0;i < nums.length;i++){
            while(i < p2 && nums[i] == 2){  //考虑两个2互换，所以当i指的是2时，要不停的换直到i指的不是2
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
            if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
        }
    }
}
