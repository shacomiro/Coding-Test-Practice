class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int[] divisorNumbers = new int[right - left + 1];
        int idx = 0;
        int startNum = left;
        
        for(int target = left; target <= right; target++) {
            int numberOfDivisors = 0;
            int smallDivisor = 1;
            int bigDivisor = target;
            boolean findFlag = true;
            
            while(findFlag) {
                if(target % smallDivisor == 0) {
                    bigDivisor = target / smallDivisor;
                    
                    if(smallDivisor == bigDivisor)
                        numberOfDivisors++;
                    else
                        numberOfDivisors += 2;
                    
                }
                smallDivisor++;
                
                if(smallDivisor > bigDivisor)
                    findFlag = false;
            }
            
            divisorNumbers[idx] = numberOfDivisors;
            idx++;
        }
        
        for(int number : divisorNumbers) {
            if(number % 2 == 0)
                answer += startNum++;
            else
                answer -= startNum++;
        }

        return answer;
    }
} 