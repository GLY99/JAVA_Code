public class Test {
    public static void main(String[] args) {
        String s = "acf?djei?";
        System.out.println(modifyString(s));
    }
    //给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母
    // 使最终的字符串不包含任何 连续重复 的字符。
    public static String modifyString(String s){
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length;i++){
            if (chars[i] == '?'){
                 char last = i == 0 ? ' ' : chars[i-1];
                 char next = i == chars.length - 1 ? ' ' : chars[i + 1];
                 char flag = 'a';
                 while (flag == last || flag == next){
                     flag++;
                 }
                 chars[i] = flag;
            }
        }
        return new String(chars);
    }
}
