public class Test {
    public static String printBinaryNumbers(int num){
        StringBuilder ret = new StringBuilder();
        for(int i = 31;i >= 1;i = i-2){
           ret.append(((num >> i) & 1));
        }
        ret.append(' ');
        for (int i = 30;i >= 0;i = i - 2){
            ret.append(((num >> i) & 1));
        }
        return ret.toString();
    }
}
