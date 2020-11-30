import java.util.Scanner;
public class Main {
    public static int move(int num){
        if(num == 0)return 0;
        if(num == 1)return 1;
        int F0 = 0;
        int F1 = 1;
        int F2 = 1;
        while (F2 < num){
            F2 = F0 + F1;
            F0 = F1;
            F1 = F2;
        }
        return Math.min(Math.abs(F0 - num),Math.abs(F1 - num));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int step = move(num);
        System.out.println(step);
    }
}
