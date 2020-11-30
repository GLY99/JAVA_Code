public class Solution {
/*    public String replaceSpace(String s){
        String ret = "";
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == ' '){
                ret += "%20";
            }else {
                ret += s.charAt(i);
            }
        }
        return ret;
    }*/
/*    public String replaceSpeac(String s){
        StringBuilder ret = new StringBuilder();
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == ' '){
                ret.append("%20");
            }else {
                ret.append(s.charAt(i));
            }
        }
        return ret.toString();
    }*/
    public String replaceSpeac(String s){
        int len = 0;
        for(int i = 0;i < s.length();i++){
            if (s.charAt(i) != ' '){
                len++;
            }else {
                len += 3;
            }
        }
        char[] ans = new char[len];
        int size = 0;
        for(int i = 0;i < s.length();i++){
            if (s.charAt(i) == ' '){
                ans[size++] = '%';
                ans[size++] = '2';
                ans[size++] = '0';
            }else {
                ans[size++] = s.charAt(i);
            }
        }
        return new String(ans);
    }
}
