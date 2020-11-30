public class Test {0
    public static boolean isLongPressedName(String name, String typed){
        int len1 = name.length();
        int len2 = typed.length();
        if (len1 > len2)return false;
        int i = 0;
        int j = 0;
        while (j < len2){
            if (i < len1 && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else if(j > 0 && typed.charAt(j) == typed.charAt(j-1)){
                j++;
            }else {
                return false;
            }
        }
        return i == name.length();
    }
}
