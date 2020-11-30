//给定一个栈及一个操作序列int[][2] ope代表所进行的入栈出栈操作。
// 第一个元素为1则入栈，第二个元素为数的正负号；
// 第一个元素为2则出栈，第二个元素若为0则出最先入栈的那个数，为1则出最先入栈的正数，为-1则出最先入栈的负数。请按顺序返回出栈的序列，并做异常处理忽略错误操作。
//测试样例：
//[[1,1],[1,-1],[2,0],[2,-1]]
//返回：[1,-1]
import java.util.*;
public class CatDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
        List<Integer> ret = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i < ope.length;i++){
            switch (ope[i][0]){
                case 1:
                    ans.add(ope[i][1]);
                    break;
                case 2:
                    if (!ans.isEmpty() && ope[i][1] == 0){
                        ret.add(ans.get(0));
                        ans.remove(0);
                    }
                    if (!ans.isEmpty() && ope[i][1] == -1){
                        for (int j = 0;j < ans.size();j++){
                            if (ans.get(j) < 0){
                                ret.add(ans.get(j));
                                ans.remove(j);
                                break;
                            }
                        }
                    }
                    if (!ans.isEmpty() && ope[i][1] == 1){
                        for (int j = 0;j < ans.size();j++){
                            if (ans.get(j) > 0){
                                ret.add(ans.get(j));
                                ans.remove(j);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        return new ArrayList<Integer>(ret);
    }
}
