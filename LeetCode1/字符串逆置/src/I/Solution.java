package I;

public class Solution {
    public static String reverse(String str){
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        char temp = ' ';
        while (start < end){
            temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
        return new String(arr);
    }
}
