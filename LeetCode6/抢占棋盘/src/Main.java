import java.util.*;

public class Main {
    private static int[][] next = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    static class  Pair{
        public int x;
        public int y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();//棋盘大小
            int[][] map = new int[n][n];
            for (int i = 0;i < n;i++){
                String in = scanner.next();
                for (int j = 0;j < in.length();j++){
                    map[i][j] = Integer.parseInt(in.charAt(j) + "");
                }
            }
            //0为白子，1为黑子
            boolean[][] visited = new boolean[n][n];
            for (int i = 0;i < n;i++){
                for (int j = 0;j < n;j++){
                    if ((i == 0 || j == 0 || i == n - 1 || j == n - 1) && map[i][j] == 0){
                        BFS(map,visited,i,j);
                    }
                }
            }
            for (int i = 0;i < n;i++){
                for (int j = 0;j < n;j++){
                    if (visited[i][j] == false){
                        map[i][j] = 1;
                    }
                }
            }
            for (int i = 0;i < n;i++){
                for (int j = 0;j < n;j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static void BFS(int[][] map,boolean[][] visited ,int i, int j) {
        int len = visited.length;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            int x = p.x;
            int y = p.y;
            visited[x][y] = true;
            for (int k = 0;k < 4;k++){
                x = p.x + next[k][0];
                y = p.y + next[k][1];
                if ((x >= 0 && x < len) && (y >= 0 && y < len) && visited[x][y] == false && map[x][y] == 0){
                    queue.add(new Pair(x,y));
                }
            }
        }
    }
}
