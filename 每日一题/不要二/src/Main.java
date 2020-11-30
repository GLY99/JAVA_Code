//二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
//对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
//( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
//小易想知道最多可以放多少块蛋糕在网格盒子里。

//两点之间距离为2只有横纵距离会为2
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int[][] arr = new int[H][W];
        for (int h = 0;h < H;h++){
            if (h % 4 == 1 || h % 4 == 0){
                for (int w = 0;w < W;w++){
                    if (w % 4 == 1 || w % 4 == 0){
                        arr[h][w] = 1;
                    }
                }
            }else {
                for (int w = 0;w < W;w++){
                    if (w % 4 == 2 || w % 4 == 3){
                        arr[h][w] = 1;
                    }
                }
            }
        }
        int count = 0;
        for (int h = 0;h < H;h++){
            for (int w = 0;w < W;w++){
                if (arr[h][w] == 1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
