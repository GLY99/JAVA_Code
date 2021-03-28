import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int height = scanner.nextInt();
            int n = scanner.nextInt();
            double res = len(height,n);
            System.out.println(res);
        }
    }

    private static double len(int height, int n) {
        double h1 = height;
        double h2 = height / 2.0;
        double sum = h1 + h2;
        while (n > 1){
            h1 = h2;
            h2 = h2 / 2.0;
            sum += (h1 + h2);
            n--;
        }
        return sum;
    }
}
