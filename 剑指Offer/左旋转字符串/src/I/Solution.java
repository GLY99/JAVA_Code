package I;

//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
// 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
public class Solution {
    public String reverseLeftWords(String s,int n){
        StringBuilder str1 = new StringBuilder(s.substring(0,n));
        StringBuilder str2 = new StringBuilder(s.substring(n));
        return (str2.append(str1)).toString();
    }
    /*public String reverseLeftWords(String s,int n){
        int l = 0;
        int r = n - 1;
        String ret = reverse(l,r,s);
        l = n;
        r = s.length() - 1;
        String ret1 = reverse(l,r,ret);
        l = 0;
        String ret2 = reverse(l,r,ret1);
        return ret2;
    }
    public String reverse(int l,int r,String s){
        char[] chars = s.toCharArray();
        while (l < r){
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
        return new String(chars);
    }*/
    /*public String reverseLeftWords(String s, int n){
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0;i < n;i++){
            str2.append(s.charAt(i));
        }
        for (int i = n;i < s.length();i++){
            str1.append(s.charAt(i));
        }
        str1.append(str2);
        return str1.toString();
    }*/
}
