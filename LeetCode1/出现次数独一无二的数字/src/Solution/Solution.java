package Solution;

import java.util.*;

public class Solution {
    public boolean uniqueOccurrences(int[] arr){
        Set<Integer>  set= new HashSet<Integer>();
        Arrays.sort(arr);
        for(int i = 0;i < arr.length;i++){
            int count = 1;
            while (i < arr.length - 1){
                if (arr[i + 1] == arr[i]){
                    count++;
                    i++;
                }else {
                    break;
                }
            }
            if (set.contains(count)){
                return false;
            }else {
                set.add(count);
            }
        }
        return true;
    }
}
