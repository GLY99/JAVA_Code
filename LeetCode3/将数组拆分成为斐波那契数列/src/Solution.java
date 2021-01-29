import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> splitIntoFibonacci(String S){
        List<Integer> list = new ArrayList<>();
        backtrack(S.toCharArray(),list,0);
        return list;
    }
    public boolean backtrack(char[] digit,List<Integer> list,int index){//list用来存储最后的结果，index来标记每个数字的首位
        if (index == digit.length && list.size() >= 3){//当i走到头而且List大于三个说明找到了结果
            return true;//返回true
        }//当index截取完毕，而且List大于3说明找到一个组合
        for (int i = index;i < digit.length;i++){//用i遍历数组找数字
            if (digit[index] == '0' && i > index){//i大于Index说明是两位数，两位数不能以0开头
                break;//这个数字不可用直接结束循环
            }
            long num = subDigit(digit,index,i);//数字可用转化为数值型
            if (num > Integer.MAX_VALUE){//转化后的数字大于最大值
                break;//结束循环
            }
            int size = list.size();//得到list的大小
            if (size >= 2 && num > list.get(size - 1) + list.get(size - 2)){//如果list大于两个，而且Num大于前两项之和
                break;//结束循环，因为再找下去数会越来越大
            }
            if (size <= 1 || num == list.get(size - 1) + list.get(size - 2)){//如果list大小不足两个，或者Num等于前两项之和
                list.add((int) num);//加入结果集中
                if (backtrack(digit,list,i + 1)){//进行下一波查找,如果找到结果返回true
                    return true;
                }
                list.remove(list.size() - 1);//走到这里说明没有找到结果，移除上一个添加的元素。
            }
        }
        return false;
    }
    public long subDigit(char[] digit,int start,int end){
        long ret = 0;
        for (int i = start;i <= end;i++){
            ret = ret*10 + digit[i] - '0';
        }
        return ret;
    }
}
