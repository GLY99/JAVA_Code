public class Test {
    public String sortString(String s){
        StringBuilder ret = new StringBuilder();
        char[] chars = new char[26];
        for (int i = 0;i < s.length();i++){
            chars[s.charAt(i) - 'a']++;
        }
        while (ret.length() != s.length()){
            for (int i = 0;i < 26;i++){
                if (chars[i] != 0){
                    ret.append((char)(i + 'a'));
                    chars[i]--;
                }
            }
            for (int i = 25;i >= 0;i--){
                if (chars[i] != 0){
                    ret.append((char)(i + 'a'));
                    chars[i]--;
                }
            }
        }
        return ret.toString();
    }
}
