import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        for (int i = 9;i >= 1;i--){
            s = (s + 1) * 2;
        }
        System.out.println(s);
        for (int i = 1;i < 10;i++){
            s = s / 2 - 1;
        }
        System.out.println(s);
        System.gc();
    }
}
