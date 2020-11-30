import java.util.*;
public class Main {
    public static boolean adjust(String str){
        int s = 0;
        int e = str.length() - 1;
        while (s < e){
            if (str.charAt(s) == str.charAt(e)){
                s++;
                e--;
            }else {
                return false;
            }
        }
        return true;
    }
    public static int insert(String str1,String str2){
        int count = 0;
        for (int i = 0;i <= str1.length();i++){
            StringBuilder stringBuilder = new StringBuilder(str1);
            stringBuilder.insert(i,str2);
            if (adjust(stringBuilder.toString()) == true){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println(insert(str1, str2));
        }
    }
}
