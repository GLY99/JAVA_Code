/**给定一个无重复元素的有序整数数组 nums 。

 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 */
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0){
            return list;
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        for (int i = 1;i < nums.length;i++){
            if (nums[i] == nums[i - 1] + 1){
                end = i;
            }else {
                list.add(help(nums,start,end));
                sb = new StringBuilder();
                start = i;
                end = i;
            }
        }
        list.add(help(nums,start,end));
        return list;
    }
    public String help (int[] nums,int start,int end){
        StringBuilder sb = new StringBuilder();
        if (start == end){
            sb.append(nums[start]);
        }else {
            sb.append(nums[start]);
            sb.append("->");
            sb.append(nums[end]);
        }
        return sb.toString();
    }
}
