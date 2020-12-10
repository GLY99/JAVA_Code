//在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
//
//顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
//
//每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
//
//注意，一开始你手头没有任何零钱。
//
//如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[3];//记录零钱
        for (int i = 0;i < bills.length;i++){
            if (bills[i] == 5){//收到5元
                change[0]++;
                continue;
            }else {
                if (bills[i] == 10){//收到10元
                    change[0]--;
                    if (change[0] < 0){
                        return false;
                    }
                    change[1]++;
                    continue;
                }else {
                    if (bills[i] == 20){//收到20元
                        change[2]++;
                        if (change[0] >= 1 && change[1] >= 1){//(首选，因为留下的5元越多越好，所以先找10元)第一种选择找1个5元，一个10元
                            change[0]--;
                            change[1]--;
                            continue;
                        }else {
                            if (change[0] >= 3){//(最后没10元可找再找5元)第二种选择找3个5元
                                change[0] -= 3;
                                continue;
                            }else {
                                return false;//两种都找不开就只能false
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
