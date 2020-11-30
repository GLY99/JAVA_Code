public class Test {
    public static void main(String[] args) {
        String s = "abac";
        System.out.println(repeatedSubstringPattern(s));
    }
    //给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
    public static boolean repeatedSubstringPattern(String s){
        char[] chars = s.toCharArray();
        int len = chars.length;
        int i;
        int j;
        for(i = 1;i <= len / 2;i++){
            if(len % i != 0)continue;
            for(j = 0;j < len - i;j++){
                if(chars[j] != chars[j + i]){
                    break;
                }
            }
            //判断是因为break跳出循环，还是循环条件跳出循环
            if(j >= len - i){
                return true;//如果j大于等于len-i说明以i为子字串长度可以组成重复字符串
            }
        }
        return false;
    }
}
