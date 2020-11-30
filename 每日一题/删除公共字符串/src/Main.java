import java.util.*;
//从第一个字符串中删除第二个字符串中的字符。
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            String ret = deleteString(str1,str2);
            System.out.println(ret);
        }
    }
    public static String deleteString(String str1,String str2){
        HashSet<Character> hashSet = new HashSet<>();
        for (char c : str2.toCharArray()){
            if (c != ' '){
                hashSet.add(c);
            }
        }
        StringBuilder ret = new StringBuilder();
        for (char c : str1.toCharArray()){
            if (!hashSet.contains(c)){
                ret.append(c);
            }
        }
        return ret.toString();
    }
}
