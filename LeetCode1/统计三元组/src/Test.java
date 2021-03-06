public class Test {
    public static void main(String[] args) {
        int[] a ={3,0,1,1,9,7};
        System.out.println(countGoodTriplets(a, 7, 2, 3));
    }
    //给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量
    //如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组
    //0 <= i < j < k < arr.length
    //|arr[i] - arr[j]| <= a
    //|arr[j] - arr[k]| <= b
    //|arr[i] - arr[k]| <= c
    public static int countGoodTriplets(int[] arr, int a, int b, int c){
        int len = arr.length;
        if(len < 3){
            return 0;
        }
        int count = 0;
        for(int i = 0;i < len -2;i++){
            for(int j = i+1;j < len-1;j++){
                for(int k = j+1;k < len;k++){
                    if(Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
