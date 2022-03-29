class Solution {
    int answer;
    int target;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.target = target;
        clac(numbers, 0, 0);
        
        return answer;
    }
    
    public void clac(int[] numbers, int idx, int sum) {
        if(idx == numbers.length) {
            if(sum == target)
                answer++;
            return;
        }
        
        int num = numbers[idx++];
        int tempSum = sum;
        
        clac(numbers, idx, tempSum + num);
        clac(numbers, idx, tempSum - num);
    }
}
//+1