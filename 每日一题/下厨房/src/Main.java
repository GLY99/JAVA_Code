import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static int Func(String str){
        HashSet<String> hashSet = new HashSet<>();
        String[] strings = str.split(" ");
        for (String s : strings){
            if (s == null){
                continue;
            }else {
                hashSet.add(s);
            }
        }
        return hashSet.size();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ret = 0;
        while (scanner.hasNext()){
            String str= scanner.nextLine();
            ret += Func(str);
        }
        System.out.println(ret);
    }
}
