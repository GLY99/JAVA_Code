import java.util.Arrays;
import java.util.Scanner;

public class Sloution {
    /*public String connectionString(String S){
        String[] strings = S.split(" ");
        StringBuilder str = new StringBuilder();
        for(String s:strings){
            str = str.append(s);
        }
        return new String(str);
    }*/
    public static String[] mySplit(String S,char regex){
        int count = 0;
        int start=0;
        int idx=0;
        for (int i = 0;i < S.length();i++){
            if (i == 0 && S.charAt(i) == regex){
                count = count;
            }
            if (i == S.length() - 1 && S.charAt(i) == regex){
                count = count;
            }
            if (i > 0 && i < S.length() - 1){
                if (S.charAt(i) == regex){
                    count++;
                }
            }
        }
        int temp = 0;
        String[] str = new String[count + 1];
        for(int i = 0;i < S.length();i++){
            if (S.charAt(i) == regex){
                str[idx++] =S.substring(start,i);
                start = i + 1;
                temp++;
                if (temp == count){
                    str[idx++] = S.substring(start);
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = mySplit(str,' ');
        StringBuilder s = new StringBuilder();
        for (String s1 : strings){
            s = s.append(s1);
        }
       System.out.println(new String(s));
    }
}
