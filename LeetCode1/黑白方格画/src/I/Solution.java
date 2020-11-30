package I;
//小扣注意到秋日市集上有一个创作黑白方格画的摊位。摊主给每个顾客提供一个固定在墙上的白色画板，画板不能转动。画板上有 n * n 的网格。
// 绘画规则为，小扣可以选择任意多行以及任意多列的格子涂成黑色，所选行数、列数均可为 0。
//小扣希望最终的成品上需要有 k 个黑色格子，请返回小扣共有多少种涂色方案。
public class Solution {
    public int paintingPlan(int n,int x){
        if ( x== 0|| x == n * n)return 1;
        if (x < n)return 0;
        int ret = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if (n * i + (n - i) * j == x){
                    ret += get(n,i) * get(n,j);
                }
            }
        }
        return ret;
    }
    public int get(int n,int b){
        int ret = 1;
        for(int i = n;i >= n - b + 1;i--){
            ret *= i;
        }
        for(int i = 1;i <= b;i++){
            ret /= i;
        }
        return ret;
    }
}
