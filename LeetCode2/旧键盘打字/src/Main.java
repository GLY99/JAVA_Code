import java.util.*;
public class Main {
    public static void func(String strMust,String strAct){
        HashSet<Character> hashSet = new HashSet<>();
        for (char ch : strAct.toUpperCase().toCharArray()){
            hashSet.add(ch);
        }
        HashSet<Character> hashSet1 = new HashSet<>();
        char[] charArr = strMust.toUpperCase().toCharArray();
        for (char ch : charArr){
            if (!hashSet.contains(ch) && !hashSet1.contains(ch)){
                hashSet1.add(ch);
                System.out.print(ch);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String strMust = scanner.nextLine();
            String strAct = scanner.nextLine();
            func(strMust,strAct);
        }
    }
}
