package II;
//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
public class Test {
        public int[] singleNumbers(int[] arr){
            int a = 0;
            int[] ret = {0,0};
            for(int num : arr){
                a ^= num;
            }//此时a就是要找的那两个元素的异或结果
            int b = a & (-a);//找出找出结果最低位的1
            for (int num : arr){//通过最低位的1区分所有数字
                if ((b & num) == 0){
                    ret[0] ^= num;
                }else {
                    ret[1] ^= num;
                }
            }
            return ret;
        }
}
