import java.util.HashMap;

class Solution {
    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int ans : answers) {
            if (map.containsKey(ans) && map.get(ans) > 0) {
                map.put(ans,map.get(ans) - 1);//遇见一个相同的兔子就把这个类型的兔子数量减一
            }else {
                res += ans + 1;//自己的数量和与自己相同的数量
                map.put(ans,ans);//放入和自己相同的兔子数量
            }
        }
        return res;
    }
}