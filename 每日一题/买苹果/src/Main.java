import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            int count = buyApples(num);
            System.out.println(count);
        }
    }
    public static int buyApples(int num){
        int mincount = num / 6;
        boolean flag = false;
        for (int x = 0;x <= num/6;x++){
            for (int y = 0;y <= num/8;y++){
                if (6 * x + 8 * y == num){
                    mincount = Math.min(mincount,x + y);
                    flag = true;
                }
            }
        }
        if (flag == true){
            return mincount;
        }
        return -1;
    }
}
