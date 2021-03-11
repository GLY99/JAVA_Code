/**N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。

 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。

 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 */
class Solution {
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int res = 0;
        for (int i = 0;i < len - 1;i = i + 2){
            int left = row[i];
            if ((left % 2 == 0 && row[i + 1] == left + 1) || (left % 2 == 1 && row[i + 1] == left - 1)){
                continue;
            }else {
                for (int j = i;j < len;j++){
                    if (left % 2 == 0){
                        if (row[j] == left + 1){
                            int temp = row[j];
                            row[j] = row[i + 1];
                            row[i + 1] = temp;
                            res++;
                            break;
                        }
                    }else {
                        if (row[j] == left - 1){
                            int temp = row[j];
                            row[j] = row[i + 1];
                            row[i + 1] = temp;
                            res++;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}