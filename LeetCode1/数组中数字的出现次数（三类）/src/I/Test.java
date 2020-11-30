package I;
//有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字
public class Test {
    public static int singleNumber(int[] arr){
        int ret = 0;
        for(int num : arr){
            ret ^= num;
        }
        return ret;
    }
}
