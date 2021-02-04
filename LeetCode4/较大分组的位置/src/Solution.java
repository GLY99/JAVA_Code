/**在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。

 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。

 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。

 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。

 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。*/
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<List<Integer>> largeGroupPositions(String s){
        s = s + 'A';
        List<List<Integer>> lists = new ArrayList<>();
        int start = 0;
        for (int i = 1;i < s.length();i++){
            if (s.charAt(i) != s.charAt(i - 1)){
                if (i - start >= 3){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(start);
                    tempList.add(i - 1);
                    lists.add(tempList);
                }
                start = i;
            }
        }
        return lists;
    }
    public List<List<Integer>> largeGroupPositionsI(String s) {
        s = s + 'A';
        List<List<Integer>> lists = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 1;i < s.length();i++){
            if (s.charAt(i) == s.charAt(i - 1)){
                end++;
            }else {
                if (end - start >= 2){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(start);
                    tempList.add(end);
                    lists.add(tempList);
                }
                start = i;
                end = i;
            }
        }
        return lists;
    }
}
