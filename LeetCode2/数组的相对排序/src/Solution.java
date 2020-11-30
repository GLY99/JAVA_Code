//给你两个数组，arr1 和 arr2，
//arr2 中的元素各不相同
//arr2 中的每个元素都出现在 arr1 中
//对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
import java.util.*;
public class Solution {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        int[] ret = new int[arr1.length];
        for(int i = 0;i < arr1.length;i++){
            map[arr1[i]]++;
        }
        int size = 0;
        for (int i = 0;i < arr2.length;i++){
            while (map[arr2[i]] > 0){
                ret[size++] = arr2[i];
                map[arr2[i]]--;
            }
        }
        for (int i = 0;i < map.length;i++){
            while (map[i] > 0){
                ret[size++] = i;
                map[i]--;
            }
        }
        return ret;
    }
}
class SolutionI {
    public int[] relativeSortArrayI(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : arr1) list.add(num);
        for(int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.containsKey(o1) || map.containsKey(o2)){
                    return map.getOrDefault(o1,1001) - map.getOrDefault(o2,1001);
                }
                return o1 - o2;
            }
        });
        for(int i = 0; i < arr1.length; i++) arr1[i] = list.get(i);
        return arr1;
    }
}