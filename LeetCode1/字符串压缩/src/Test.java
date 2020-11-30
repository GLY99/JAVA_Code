//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
// 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
public class Test {
    public String compressString(String S) {
        if (S == null || S.length() == 0){
            return "";
        }
        StringBuilder ret = new StringBuilder();
        char flag = S.charAt(0);
        int count = 0;
        for(int i = 0;i < S.length();i++){
            if(flag == S.charAt(i)){
                count++;
            }else{
                ret.append(flag);
                ret.append(count);
                flag = S.charAt(i);
                count = 1;
            }
        }
        ret.append(flag);
        ret.append(count);
        if (ret.length() >= S.length()){
            return S;
        }
        return ret.toString();
    }
}
