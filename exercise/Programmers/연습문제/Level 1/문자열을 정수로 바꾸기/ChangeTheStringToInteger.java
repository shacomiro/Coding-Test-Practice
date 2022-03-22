class Solution {
    public int solution(String s) {
        String sign = s.substring(0);
        
        if(sign.equals("-")) {
            return 0 - Integer.parseInt(s.substring(1, s.length()));
        } else if(sign.equals("+")) {
            return Integer.parseInt(s.substring(1, s.length()));
        } else {
            return Integer.parseInt(s);
        }
    }
}