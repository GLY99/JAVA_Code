//给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
// 返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
import java.util.*;
public class Solution {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>();
        if (k <= 0){
            return list;
        }
        int pos = find(arr,x) - 1;
        int left = pos;
        int right = pos + 1;
        while ((right - left - 1) < k){
            if (right >= arr.length){
                left--;
                continue;
            }
            if (left < 0){
                right++;
                continue;
            }
            int tmpl = Math.abs(arr[left] - x);
            int tmpr = Math.abs(arr[right] - x);
            if (tmpl <= tmpr){
                left--;
            }else {
                right++;
            }
        }
        for (int i = left + 1;i < right;i++){
            list.add(arr[i]);
        }
        return list;
    }
    public static int find(int[] arr,int x){
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (arr[mid] == x){
                return mid;
            }else {
                if (arr[mid] < x){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return left;
    }
}
