import java.util.*;

public class Test {
    //找到出现第一个重复数字
    public static int findNumber(ArrayList<Integer> list){
        Set<Integer> set = new HashSet<>();
        for (int num : list){
            if (set.contains(num)){
                return num;
            }else {
                set.add(num);
            }
        }
        return -1;
    }
    //数据去重
    public static List<Integer> printNumber(ArrayList<Integer> list){
        Set<Integer> set = new HashSet<>();
        for (int num : list){
            set.add(num);
        }
        List<Integer> ret = new ArrayList<>();
        for (int num : set){
            ret.add(num);
        }
        return ret;
    }
    //统计数字出现次数
    public static List<List<Integer>> stat(ArrayList<Integer> list){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : list){
            int count = map.getOrDefault(num , 0) + 1;
            map.put(num,count);
        }
        List<List<Integer>> ret = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            List<Integer> list1 = new ArrayList<>();
            if (entry.getValue() > 1){
                int k = entry.getKey();
                list1.add(k);
                int v = entry.getValue();
                list1.add(v);
                ret.add(list1);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random(10215);
        int count = 100000;
        while (count > 0){
            list.add(random.nextInt(100000));
            count--;
        }
        List<List<Integer>> ret = stat(list);
        System.out.println(ret);
    }
}
