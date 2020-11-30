import java.util.Random;
import java.util.Scanner;
public class Test {
    //猜数字游戏
    public static void main12(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rand = random.nextInt(100)+1;
        while(true){
            System.out.println("请输入你猜的数字：");
            int n = scanner.nextInt();
            if(n > rand){
                System.out.println("猜大了");
            }
            if(n == rand){
                System.out.println("猜对了");
                break;
            }
            if(n<rand){
                System.out.println("猜小了");
            }
        }
    }
}
