import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sumOfReq = 0;
        
        Arrays.sort(d);
        
        for(int req : d) {
            sumOfReq += req;
            
            if(sumOfReq <= budget)
                answer++;
            else
                break;
        }
        
        return answer;
    }
}