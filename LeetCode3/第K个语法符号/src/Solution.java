//在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
//
//给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
public class Solution {
    public int kthGrammar(int N, int K){
        if (N == 1){
            return 0;
        }
        if (kthGrammar(N - 1,(K + 1) / 2) == 0){//第K个数由上一行的第（K + 1）/2个数生成。
            return 1 - (K % 2);//如果上一行的数是0，生成的就是1 - （K % 2）
        }else {
            return K % 2;//否则如果上一行的数是1生成的就是K % 2
        }
    }
}
