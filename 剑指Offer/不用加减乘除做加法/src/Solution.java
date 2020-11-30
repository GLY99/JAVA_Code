public class Solution {
    public int add(int a,int b){
        while (b != 0){
            int c = (a & b) << 1;//进位数字
            a ^= b;//不进位的数字
            b = c;//进位的数字下次加上
        }
        return a;
    }
}
