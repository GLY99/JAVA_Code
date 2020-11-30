import java.util.Scanner;
public class Main {
    public static int n;
    public static int[] bags;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        bags = new int[n];
        for (int i = 0;i < n;i++){
            bags[i] = scanner.nextInt();
        }
        System.out.println(chooseCount(0,40));
    }
    public static int chooseCount(int i,int sum){
        if (sum == 0)return 1;
        if (i == n || sum < 0)return 0;
        return chooseCount(i + 1,sum - bags[i]) + chooseCount(i + 1,sum);
        //递归方程 count(i,sum) = count (i + 1,sum) + count(i + 1,sum - bags[i])
    }
}
