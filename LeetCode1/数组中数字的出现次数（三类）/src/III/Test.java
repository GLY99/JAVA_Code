package III;
//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
public class Test {
    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,2,3};
        int i = singleNumber(a);
        System.out.println(a);
    }
    public static int singleNumber(int[] nums){
        int[] val = new int[32];
        for (int num : nums){
            int flag = 1;
            for(int i = 31;i >= 0;i--){
                if ((flag & num) != 0){
                    val[i]++;
                }
                flag = flag << 1;
            }
        }
        int ret = 0;
        for (int i = 0;i < 32;i++){
            if (val[i] % 3 != 0){
                ret = ret << 1;
                ret = ret + 1;
            }else {
                ret = ret << 1;
            }
        }
        return ret;
    }
}
