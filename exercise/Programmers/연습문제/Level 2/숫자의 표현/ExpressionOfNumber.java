class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int startNum = 1; startNum <= n; startNum++) {
            int currentNum = startNum;
            int sumOfNum = 0;
            
            while(sumOfNum <= n) {
                sumOfNum += currentNum;
                
                if(sumOfNum == n) {
                    answer++;
                    break;
                }
                
                currentNum++;
            }
        }
        
        return answer;
    }
}
//+7