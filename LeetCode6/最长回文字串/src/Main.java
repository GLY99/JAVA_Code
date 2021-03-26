import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            int res = maxLengthSub(s);
            System.out.println(res);
        }
    }

    private static int maxLengthSub(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1;i >= 0;i--){
            for (int j = i;j < len;j++){
                if (i == j){//单字符
                    dp[i][j] = true;
                }else if (i + 1 == j){//双字符
                    if (s.charAt(i) == s.charAt(j) || s.charAt(i) == '*' || s.charAt(j) == '*'){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = false;
                    }
                }else {//多字符
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j) || s.charAt(i) == '*' || s.charAt(j) == '*');
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0;i < len;i++){
            for (int j = 0;j < len;j++){
                if (dp[i][j]){
                    res = Math.max(res,j - i + 1);
                }
            }
        }
        return res;
    }
}
