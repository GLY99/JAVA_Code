import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            System.out.println(findLongestNumber(str));
        }
    }
    public static String findLongestNumber(String str){
        String ret = "";
        int begin = 0;
        int end = 0;
        int maxLength = 0;
        int retbegin = 0;
        int retend = 0;
        while (begin < str.length() && end < str.length()){
            while (begin < str.length() && (str.charAt(begin) < '0' || str.charAt(begin) > '9')){
                begin++;
            }
            end = begin;
            while (end < str.length() && (str.charAt(end) >= '0' && str.charAt(end) <= '9')){
                end++;
            }
            if (end - begin > maxLength){
                maxLength = end - begin;
                retbegin = begin;
                retend = end;
            }
            begin = end;
        }
        ret = str.substring(retbegin,retend);
        return ret;
    }
}
