import javax.management.ListenerNotFoundException;
import java.util.ArrayList;
import java.util.List;
public class Test {
    public List<Integer> partitionLabels(String S){
        int[] map = new int[26];
        for (int i = 0;i < S.length();i++){
            map[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        List<Integer> ret = new ArrayList<>();
        for(int i = 0;i < S.length();i++) {
            end = Math.max(end, map[S.charAt(i) - 'a']);
            if(i == end) {
                ret.add(end - start + 1);
                start = end + 1;
            }
        }
        return ret;
    }
}
