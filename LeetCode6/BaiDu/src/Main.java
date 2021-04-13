public class Main {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,7};
        int res = findNum(array);
        System.out.println(res);
    }

    private static int findNum(int[] array) {
        if (array == null || array.length == 0){
            return -1;
        }
        int len = array.length;
        int l = 0;
        int r = len - 1;

        while (l < r){
            int mid = (l + r) / 2;
            if (array[mid] != mid){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return array[l] == l ? l + 1 : l;
    }
}
