//比较两个版本号 version1 和 version2。
//如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
//你可以假设版本字符串非空，并且只包含数字和 . 字符。. 字符不代表小数点，而是用于分隔数字序列。
//例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
//你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
public class Solution {
    public  int compareVersion(String version1, String version2){
        String[] arr1 = version1.split("\\.");//只有\\.才代表一个点，作为分割标志的不会出现在分割结果中
        String[] arr2 = version2.split("\\.");
        int n1 = arr1.length;
        int n2 = arr2.length;
        for (int i = 0;i < Math.max(n1,n2);i++){
            int v1 = i < n1 ? Integer.parseInt(arr1[i]) : 0;
            int v2 = i < n2 ? Integer.parseInt(arr2[i]) : 0;
            if (v1 != v2){
                return v1 > v2 ? 1 : -1;
            }
        }
        return 0;
    }
}
