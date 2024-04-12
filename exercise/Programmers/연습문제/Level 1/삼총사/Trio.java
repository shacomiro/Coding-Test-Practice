class Solution {
    int answer = 0;
    
    public int solution(int[] number) {
        combination(number, 0, 0, 0);
        
        return answer;
    }
    
    public void combination(int[] arr, int sum, int cnt, int start) {
        if(cnt == 3) {
            if(sum == 0) answer++;
            return; 
        }
        
        for(int i = start; i < arr.length; i++) {
            combination(arr, sum + arr[i], cnt + 1, i + 1);
        }
    }
}