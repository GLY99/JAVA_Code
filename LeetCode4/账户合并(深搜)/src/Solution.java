/**给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，
 * 其余元素是 emails 表示该账户的邮箱地址。

 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
 请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。

 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。

 */
import java.util.*;
public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //存储邮箱和主人的映射关系
        Map<String,ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0;i < accounts.size();i++){
            for (int j = 1;j < accounts.get(i).size();j++){
                ArrayList<Integer> list;
                if (map.containsKey(accounts.get(i).get(j))){
                    list = map.get(accounts.get(i).get(j));
                }else {
                    list = new ArrayList<>();
                }
                list.add(i);
                map.put(accounts.get(i).get(j),list);
            }
        }
        //标记被访问过的邮箱
        boolean[] visited = new boolean[accounts.size()];

        List<List<String>> ans = new ArrayList<>();
        //遍历每个用户
        for (int i = 0;i < accounts.size();i++){
            if (visited[i] != true){
                HashSet<String> hashSet = new HashSet<>();
                dfs(accounts,map,visited,hashSet,i);
                ArrayList<String> e = new ArrayList<>();
                e.add(accounts.get(i).get(0));
                for (String j : hashSet){
                    e.add(j);
                }
                ans.add(e);
            }
        }

        //对邮箱进行排序
        for (int i = 0;i < ans.size();i++){
            Collections.sort(ans.get(i));
        }
        return ans;
    }
    public void dfs(List<List<String>> accounts,Map<String,ArrayList<Integer>> map,boolean[] visited,HashSet<String> set,int n){
        if (visited[n] == true){
            return;
        }
        visited[n] = true;
        //查找同名邮箱
        for (int i = 1;i < accounts.get(n).size();i++){
            set.add(accounts.get(n).get(i));
            //查找下一个同名邮箱
            for (int j : map.get(accounts.get(n).get(i))){
                if (visited[j] != true){
                    dfs(accounts,map,visited,set,j);
                }
            }
        }
    }
}
