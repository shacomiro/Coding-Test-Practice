class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split("");
        int wordIdx = 0;
        
        for(int i = 0; i < strArr.length; i++) {
            if(strArr[i].equals(" ")) {
                wordIdx = 0;
            } else {
                if(wordIdx % 2 == 0) strArr[i] = strArr[i].toUpperCase();
                else if(wordIdx % 2 == 1) strArr[i] = strArr[i].toLowerCase();
                wordIdx++;
            }
                
            answer = answer.concat(strArr[i]);
        }
        
        return answer;
    }
}