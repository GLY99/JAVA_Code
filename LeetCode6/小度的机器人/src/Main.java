import java.util.Scanner;

public class Main {

    static class BD{
        public int x;
        public int y;
        public BD(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String start = scanner.nextLine();
            String[] s = start.split(" ");
            int x = Integer.valueOf(s[0]);
            int y = Integer.valueOf(s[1]);
            BD baidu = new BD(x,y);
            String move = scanner.nextLine();
            baiduMove(baidu,move);
            System.out.print(baidu.x + " " + baidu.y);
            System.out.println();
        }
    }

    private static void baiduMove(BD baidu, String move) {
        for (int i = 0;i < move.length();i++){
            if (move.charAt(i) == 'L'){
                baidu.x -= 1;
            }else if (move.charAt(i) == 'R'){
                baidu.x += 1;
            }else if (move.charAt(i) == 'U'){
                baidu.y += 1;
            }else {
                baidu.y -= 1;
            }
        }
    }
}
