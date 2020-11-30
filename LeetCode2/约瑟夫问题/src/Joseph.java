//现有n个人围坐一圈，顺时针给大家编号，第一个人编号为1，然后顺时针开始报数。第一轮依次报1，2，1，2...没报1的人出局。
// 接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...没报1的人都出局。
// 以此类推直到剩下以后一个人。现给定一个int n，要求返回最后一个人的编号。
import java.util.*;
public class Joseph {
    public static int getResult(int n){
        if (n < 1)return -1;
        LinkedList<Integer> ret = new LinkedList<>();
        for (int i = 1;i <= n;i++){
            ret.add(i);
        }
        int step = 2;
        while (ret.size() > 1){
            int tmp = 0;
            int i = 0;
            while (i < ret.size()){
                tmp = (tmp + 1) % step;
                if (tmp != 1){
                    ret.remove(i);
                }else {
                    i++;
                }
            }
            step++;
            int last = ret.removeLast();
            ret.addFirst(last);
        }
        return ret.pop();
    }
}
