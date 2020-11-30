package I;
//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
public class Solution {
    public int[] printNumbers(int n){
        int len = 0;
        for(int i =0;i < n;i++){
            len += 9 * Math.pow(10,i);
        }
        int[] arr = new int[len];
        for (int i =0;i < len;i++){
            arr[i] = i + 1;
        }
        return arr;
    }
}
