import java.util.*;

public class Solution {
    private String[] map = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private StringBuilder sb = new StringBuilder();
    private List<String> ret = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return ret;
        }
        backtrack(digits,0);
        return ret;
    }
    public void backtrack(String digits,int n){
        if (sb.length() == digits.length()){
            ret.add(sb.toString());
            return;
        }
        String val = map[digits.charAt(n) - '2'];//从map中取出对应的Value值。map[0]代表字符2对应的值，所有要-2
        for (char c : val.toCharArray()){
            sb.append(c);
            backtrack(digits,n + 1);
            sb.deleteCharAt(sb.length() - 1);//删除最后一次放的字符
        }
    }
}
