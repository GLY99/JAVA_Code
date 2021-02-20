/**旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出
 肯定坏掉的那些键。*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            String output = scanner.nextLine();
            String inputUp = input.toUpperCase();
            String outputUp = output.toUpperCase();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0;i < outputUp.length();i++){
                set.add(outputUp.charAt(i));
            }
            HashSet<Character> ret = new HashSet<>();
            for (int i = 0;i < inputUp.length();i++){
                if (!set.contains(inputUp.charAt(i)) && !ret.contains(inputUp.charAt(i))){
                    ret.add(inputUp.charAt(i));
                    System.out.print(inputUp.charAt(i));
                }
            }
        }
    }
}
