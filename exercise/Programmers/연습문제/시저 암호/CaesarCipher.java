class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] charStr = s.toCharArray();
        
        for(int i = 0; i < charStr.length; i++) {
            char targetChar = charStr[i];
            
            if(targetChar != ' ') {
                int code = charStr[i];
                
                if(code >= 65 && code <= 90) {
                    charStr[i] = (char) (code + n);
                    
                    if(code + n > 90) charStr[i] = (char) ((int) charStr[i] - 26);    
                } else if(code >= 97 && code <= 122) {
                    charStr[i] = (char) (code + n);
                    
                    if(code + n > 122) charStr[i] = (char) ((int) charStr[i] - 26);
                }
            }
        }
        
        answer = String.valueOf(charStr);
        
        return answer;
    }
}