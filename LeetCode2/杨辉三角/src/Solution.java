import java.util.*;

public class Solution {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0)return ret;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ret.add(first);
        for (int i = 1;i < numRows;i++){
            List<Integer> curRow = new LinkedList<>();
            curRow.add(1);
            List<Integer> preRow = ret.get(i - 1);
            for (int j = 1;j <i;j++){
                int tmp = preRow.get(j) + preRow.get(j - 1);
                curRow.add(tmp);
            }
            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }
}
