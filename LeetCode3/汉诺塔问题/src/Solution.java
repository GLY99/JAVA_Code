import java.util.*;

public class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(),A,B,C);
    }
    //A为起点
    //B为中转
    //C为终点
    public void move(int n,List<Integer> A,List<Integer> B, List<Integer> C){
        if (n == 1){
            C.add(A.remove(A.size() - 1));
            return;
        }
        move(n - 1,A,C,B);
        move(1,A,B,C);
        move(n - 1,B,A,C);
    }
}

