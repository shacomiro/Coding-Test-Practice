import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String stringN = "";
        
        String[] splitN = Long.toString(n).split("");
        Arrays.sort(splitN, Collections.reverseOrder());
        for(String num : splitN) {
            stringN = stringN.concat(num);
        }
        
        return Long.parseLong(stringN);
    }
}