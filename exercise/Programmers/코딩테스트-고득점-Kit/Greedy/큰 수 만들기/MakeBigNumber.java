import java.lang.StringBuilder;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        boolean ordered = true;
        int start = 0;
        
        while(sb.length() != number.length() - k) {
            for(int i = start; i < sb.length() - 1; i++) {
                if(sb.charAt(i) < sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    ordered = false;
                    
                    if(i - 1 > 0) start = i - 1;
                    else start = 0;
                    
                    break;
                }
            }
            
            if(ordered) {
                sb.delete(sb.length() - k, sb.length());
                break;
            }
        }
        
        return sb.toString();
    }
}
//+9