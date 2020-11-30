package II;

public class Solution {
    public static String reverseStr(String str,int k){
        if (k <= 0 || k > str.length())return null;
        char[] arr = str.toCharArray();
        int i = 0;
        int j = k - 1;
        char c;
        while (i < j){
            c = arr[i];
            arr[i++] = arr[j];
            arr[j--] = c;
        }
        i = k;
        j = str.length() - 1;
        while (i < j){
            c = arr[i];
            arr[i++] = arr[j];
            arr[j--] = c;
        }
        i = 0;
        j = str.length() - 1;
        while (i < j){
            c = arr[i];
            arr[i++] = arr[j];
            arr[j--] = c;
        }
        return new String(arr);
    }
}

