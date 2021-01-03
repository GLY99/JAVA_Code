/**用字符串数组作为井字游戏的游戏板 board。当且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。
该游戏板是一个 3 x 3 数组，由字符 " "，"X" 和 "O" 组成。字符 " " 代表一个空位。
以下是井字游戏的规则：
玩家轮流将字符放入空位（" "）中。
第一个玩家总是放字符 “X”，且第二个玩家总是放字符 “O”。
“X” 和 “O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。
当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
当所有位置非空时，也算为游戏结束。
如果游戏结束，玩家不允许再放置字符。*/
public class Solution {
    //在任何一局比赛中，只能有 3 种结果，要么没有玩家获胜，要么只有一个玩家获胜，要么两个玩家都获胜。
    // 在前两种情况下，通过检查两种棋的数量关系即可验证是否有效。最后这一种情况下，不允许两个玩家同时获胜。
    public boolean validTicTacToe(String[] board) {
        int countX = 0;
        int countO = 0;
        for (String row : board){
            for (char c : row.toCharArray()){
                if (c == 'X'){
                    countX++;
                }
                if (c == 'O'){
                    countO++;
                }
            }
        }
        //如果第一个玩家获胜，则 X 的数量比 O 的数量多 1。
        //如果第二个玩家获胜，则 X 的数量与 O 的数量相同。
        //两个人都没有胜，则 X 的数量比 O 的数量多 1。
        if (countO != countX && countO != countX - 1){
            return false;
        }
        if (win(board,'X') && countO != countX - 1){//如果玩家1赢了，棋子数量关系不相等，那么就说明棋子数量有问题
            return false;
        }
        if (win(board,'O') && countO != countX){//如果玩家2赢了，棋子数量关系不相等，那么就说明棋子数量有问题
            return false;
        }
        return true;
    }
    public boolean win(String[] board,char c){
        for (int i = 0;i < board.length;i++){
            //检查列
            if (c == board[0].charAt(i) && c == board[1].charAt(i) && c == board[2].charAt(i)){
                return true;
            }
            //检查行
            if (c == board[i].charAt(0) && c == board[i].charAt(1) && c == board[i].charAt(2)){
                return true;
            }
        }
        //检查对角线
        if (c == board[0].charAt(0) && c == board[1].charAt(1) && c == board[2].charAt(2)){
            return true;
        }
        if (c == board[0].charAt(2) && c == board[1].charAt(1) && c == board[2].charAt(0)){
            return true;
        }
        return false;
    }
}
