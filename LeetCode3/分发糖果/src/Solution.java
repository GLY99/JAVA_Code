//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
//
//你需要按照以下要求，帮助老师给这些孩子分发糖果：
//
//每个孩子至少分配到 1 个糖果。
//相邻的孩子中，评分高的孩子必须获得更多的糖果。
//那么这样下来，老师至少需要准备多少颗糖果呢？
public class Solution {
    //例子： 1 2 2 1
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0){
            return 0;
        }
        int[] nums = new int[ratings.length];
        nums[0] = 1;
        //先正序遍历，如果后一位比前一位高分，就给比前一位多1的糖果，否则给1
        for (int i = 1;i < ratings.length;i++){
            if (ratings[i] > ratings[i - 1]){
                nums[i] = nums[i - 1] + 1;
            }else {
                nums[i] = 1;
            }
        }
        //在倒叙遍历，如果前一位比后一位高分并且得到的糖果小于或等于后一位，就给前一位孩子比后一位孩子多一个糖果
        for (int i = ratings.length - 2;i >= 0;i--){
            if (nums[i] <= nums[i + 1] && ratings[i] > ratings[i + 1]){
                nums[i] = nums[i + 1] + 1;
            }
        }
        int count = 0;
        for (int c : nums){
            count += c;
        }
        return count;
    }
}
