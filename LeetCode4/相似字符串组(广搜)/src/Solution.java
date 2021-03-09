import java.util.LinkedList;
import java.util.Queue;

/**如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。

 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。

 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。

 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
 */
public class Solution {
    public int numSimilarGroups(String[] strs) {
        if (strs.length <= 1){
            return strs.length;
        }
        boolean[] visited = new boolean[strs.length];
        int ret = 0;
        for (int i = 0;i < strs.length;i++){
            if (visited[i] == false){
                ret++;//每搜索一次相当于分完了一组
                BFS(strs,visited,i);
            }
        }
        return ret;
    }
    //广度优先搜索
    private void BFS(String[] strs,boolean[] visited,int index){
        Queue<String> queue = new LinkedList<>();
        queue.offer(strs[index]);
        visited[index] = true;
        while (!queue.isEmpty()){
            String temp = queue.poll();
            for (int i = 0;i < strs.length;i++){
                if (visited[i] == false && similar(temp,strs[i])){
                    queue.offer(strs[i]);
                    visited[i] = true;
                }
            }
        }
    }
    //相似字符串判断
    private boolean similar(String str1,String str2){
        if (str1.length() != str2.length()){
            return false;
        }
        int count = 0;
        for (int i = 0;i < str1.length();i++){
            if (str1.charAt(i) != str2.charAt(i)){
                count++;
            }
        }
        if (count == 2 || count == 0){
            return true;
        }
        return false;
    }
}
