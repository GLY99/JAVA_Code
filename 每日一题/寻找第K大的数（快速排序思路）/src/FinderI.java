public class FinderI {
    public  static int findKth(int[] a, int n, int K) {
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int par = partion(a,low,high);
            if (par + 1 == K){
                return a[K - 1];
            }else {
                if (par + 1 < K){
                    low = par + 1;
                }else {
                    high = par - 1;
                }
            }
        }
        return -1;
    }
    public  static int partion (int[] a,int low,int high){
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
