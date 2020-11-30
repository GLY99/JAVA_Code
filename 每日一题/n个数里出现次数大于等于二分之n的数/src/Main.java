import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        int ret = findNumber(list);
        System.out.println(ret);
    }
    //摩尔投票算法
    public static int findNumber(ArrayList<Integer> list){
        int ret = list.get(0);
        int count = 1;
        for (int i = 1;i < list.size();i++){
            if (list.get(i) == ret){
                count++;
            }else {
                count--;
                if (count == 0){
                    ret = list.get(i);
                    count = 1;
                }
            }
        }
        return ret;
    }
}
