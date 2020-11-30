import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while(sc.hasNext()){
            String s = sc.nextLine();
            String array[] = s.split(" ");
            for(int i =0;i<array.length;i++){
                set.add(array[i]);
            }
        }
        System.out.println(set.size());
    }
}
