class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int min, max;
        
        if(a > b) {
            min = b;
            max = a;
        } else if(a < b) {
            min = a;
            max = b;
        } else {
            return a;
        }
        
        for(int i = min; i <= max; i++) answer += (long) i;
        
        return answer;
    }
}