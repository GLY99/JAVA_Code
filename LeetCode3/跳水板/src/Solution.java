//你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
// 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
//返回的长度需要从小到大排列。
public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0)return new int[]{};
        if (shorter == longer)return new int[]{k * shorter};
        int[] ret = new int[k + 1];
        for (int i = 0;i <= k;i++){
            ret[i] = i * longer + (k - i) * shorter;
        }
        return ret;
    }
}
