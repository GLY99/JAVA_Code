import java.util.Stack;
public class Finder {
    public  int findKth(int[] a, int n, int K) {
        quickSort(a);
        return a[K - 1];
    }
    public  void quickSort(int[] a){
        int low = 0;
        int high = a.length - 1;
        int par = partion(a,low,high);
        Stack<Integer> stack = new Stack<>();
        if (low < par - 1){
            stack.add(low);
            stack.add(par - 1);
        }
        if (high > par + 1){
            stack.add(par + 1);
            stack.add(high);
        }
        while (!stack.isEmpty()){
            high = stack.pop();
            low = stack.pop();
            par = partion(a,low,high);
            if (low < par - 1){
                stack.add(low);
                stack.add(par - 1);
            }
            if (high > par + 1){
                stack.add(par + 1);
                stack.add(high);
            }
        }
    }
    public  int partion (int[] a,int low,int high){
        int temp = a[low];
        while (low < high){
            while (low < high && a[high] <= temp){
                high--;
            }
            if (high >= low){
                a[low] = a[high];
            }else {
                break;
            }
            while (low < high && a[low] >= temp){
                low++;
            }
            if (low <= high){
                a[high] = a[low];
            }else {
                break;
            }
        }
        a[low] = temp;
        return low;
    }
}
