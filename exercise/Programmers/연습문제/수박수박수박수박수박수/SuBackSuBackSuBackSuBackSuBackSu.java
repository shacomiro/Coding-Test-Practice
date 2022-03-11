class Solution {
    public String solution(int n) {
        String answer = "";
        
        for(int i = 0; i < n / 2; i ++) answer = answer.concat("수박");
        if(n % 2 == 1) answer = answer.concat("수");
        
        return answer;
    }
}