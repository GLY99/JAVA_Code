//给一非空的单词列表，返回前 k 个出现次数最多的单词。
//返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
import java.util.*;
public class Solution {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (String word : words){
            int count = map.getOrDefault(word,0) + 1;
            map.put(word,count);
        }
        PriorityQueue<String> samllHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).equals(map.get(o2)) ? o2.compareTo(o1) : map.get(o1) - map.get(o2);
            }
        });
        for (String word : map.keySet()){
            if (samllHeap.size() < k){
                samllHeap.offer(word);
            }else {
                if (map.get(word) > map.get(samllHeap.peek())){
                    samllHeap.poll();
                    samllHeap.offer(word);
                }else {
                    if (map.get(word) == map.get(samllHeap.peek())){
                        if (word.compareTo(samllHeap.peek()) < 0){
                            samllHeap.poll();
                            samllHeap.offer(word);
                        }
                    }
                }
            }
        }
        List<String> ret = new ArrayList<>();
        while (!samllHeap.isEmpty()){
            ret.add(samllHeap.poll());
        }
        Collections.reverse(ret);
        return ret;
    }
}