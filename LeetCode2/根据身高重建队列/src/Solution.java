//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
//示例
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
import java.util.*;
class peopleCompare implements Comparator<int[]>{
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
    }
}
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        peopleCompare compare = new peopleCompare();
        Arrays.sort(people,compare);//按身高降序排序，身高相同按k升序排序
        LinkedList<int[]> linkedList = new LinkedList<>();
        for (int[] num : people){
            linkedList.add(num[1],num);//遍历排序结果，将其插入队列对应的k位置
        }
        return linkedList.toArray(new int [linkedList.size()][2]);
    }
}
